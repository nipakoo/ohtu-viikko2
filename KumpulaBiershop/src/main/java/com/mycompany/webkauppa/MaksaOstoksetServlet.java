package com.mycompany.webkauppa;

import com.google.gson.Gson;
import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.Sailytys;
import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Logistiikka;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Rahasto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaksaOstoksetServlet extends WebKauppaServlet {
    private Sailytys varasto;
    
    public MaksaOstoksetServlet(Sailytys varasto, Rahasto pankki, Logistiikka logistiikka) {
        this.varasto = varasto;
        komennot = new Komentotehdas(varasto, pankki, logistiikka);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Ostoskori ostoskori = haeSessionOstoskori(request);

        request.setAttribute("hinta", ostoskori.hinta());
        request.setAttribute("ostokset", ostoskori.ostokset());

        naytaSivu("/maksa_ostokset.jsp", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nimi = request.getParameter("nimi");
        String osoite = request.getParameter("osoite");
        String luottokorttinumero = request.getParameter("luottokorttinumero");

        Ostoskori ostoskori = haeSessionOstoskori(request);

        if (request.getParameter("ostokset") != null) {
            ostoskori = muodostaOstoskori(request);
        }

        request.setAttribute("osoite", osoite);
        request.setAttribute("hinta", ostoskori.hinta());

        if (komennot.ostoksenPoistoKorista(nimi, osoite, luottokorttinumero, ostoskori).suorita()) {
            naytaSivu("/maksu_suoritettu.jsp", request, response);
        } else {
            naytaSivu("/maksu_epaonnistui.jsp", request, response);
        }

    }

    private Ostoskori muodostaOstoskori(HttpServletRequest request) {
        String ostokset = request.getParameter("ostokset");
        Ostoskori kori = new Ostoskori();
        
        System.out.println(ostokset);

        for (String ostos : ostokset.split(";") ) {

            String[] ostoksenOsat = ostos.split(",");
            Tuote tuote = varasto.etsiTuote(Long.parseLong(ostoksenOsat[0]));
            for (int i = 0; i < Integer.parseInt(ostoksenOsat[1]); i++) {
                varasto.otaVarastosta(tuote.getId());
                kori.lisaaTuote(tuote);
            }
        }

        return kori;
    }
}

class Ostos {

    public Ostos(long id, int maara) {
        this.id = id;
        this.maara = maara;
    }
    long id;
    int maara;
}

class Ostokset {

    List<Ostos> ostokset;
}
