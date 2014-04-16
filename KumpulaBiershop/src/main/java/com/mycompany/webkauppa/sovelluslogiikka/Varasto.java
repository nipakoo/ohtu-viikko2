package com.mycompany.webkauppa.sovelluslogiikka;

import com.mycompany.webkauppa.model.tietokantayhteydet.Listaus;
import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import java.util.*;

public class Varasto implements Sailytys {
    private Listaus tuoteDAO;
    
    public void setTuoteDAO(Listaus dao) {
        tuoteDAO = dao;
    }
    private List<Tuote> tuotteet;

    public Varasto(Listaus dao) {
        tuoteDAO = dao;
        tuotteet = tuoteDAO.findAll();
    }

    @Override
    public List<Tuote> tuotteidenLista() {
        return tuotteet;
    }

    @Override
    public Tuote etsiTuote(long id) {        
        for (Tuote tuote : tuotteet) {            
            if (tuote.getId() == id) {
                return tuote;
            }
        }

        return null;
    }

    @Override
    public boolean otaVarastosta(long id) {
        Tuote tuote = etsiTuote(id);
        if (tuote.getSaldo() == 0) {
            return false;
        }
        tuote.setSaldo(tuote.getSaldo() - 1);

        return true;
    }

    @Override
    public void palautaVarastoon(long id) {
        Tuote tuote = etsiTuote(id);
        tuote.setSaldo(tuote.getSaldo() + 1);
        tuoteDAO.save(tuote);
    }

    @Override
    public void palautaVarastoon(Ostos ostos) {
        Tuote tuote = etsiTuote(ostos.tuotteenId());
        tuote.setSaldo(tuote.getSaldo() + ostos.lukumaara());
        tuoteDAO.save(tuote);
    }

    @Override
    public void paivitaTuotteenTiedot(long tuoteId, int uusiHinta, int uusiSaldo) {
        Tuote tuote = etsiTuote(tuoteId);
        tuote.setSaldo(uusiSaldo);
        tuote.setHinta(uusiHinta);
        tuoteDAO.save(tuote);
    }

    @Override
    public boolean lisaaTuote(String nimi, int hinta, int saldo) {
        for (Tuote tuote : tuotteet) {
            if ( tuote.getNimi().equals(nimi) ) return false;
        }
        
        Tuote tuote = new Tuote(nimi, hinta);
        tuote.setSaldo(saldo);
        tuoteDAO.save(tuote);
        tuotteet.add(tuote);
        return true;
    }
}
