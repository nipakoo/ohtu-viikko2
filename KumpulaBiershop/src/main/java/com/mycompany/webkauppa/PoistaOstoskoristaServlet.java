package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import com.mycompany.webkauppa.sovelluslogiikka.Sailytys;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Logistiikka;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Rahasto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoistaOstoskoristaServlet extends WebKauppaServlet {
    
    public PoistaOstoskoristaServlet(Sailytys varasto, Rahasto pankki, Logistiikka logistiikka) {
        komennot = new Komentotehdas(varasto, pankki, logistiikka);
    }
             
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
        
        komennot.ostoksenPoistoKorista(haeSessionOstoskori(request), tuoteId).suorita();      
        
        naytaSivu("/MaksaOstokset", request, response);
    }
}
