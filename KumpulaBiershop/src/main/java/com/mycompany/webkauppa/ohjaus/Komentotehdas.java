/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Sailytys;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Logistiikka;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Rahasto;

/**
 *
 * @author albis
 */
public class Komentotehdas {
    private Komento komento;
    private Sailytys varasto;
    private Rahasto pankki;
    private Logistiikka logistiikka;
    
    public Komentotehdas(Sailytys varasto, Rahasto pankki, Logistiikka logistiikka) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.logistiikka = logistiikka;
    }

    public Komentotehdas ostoksenLisaysKoriin(Ostoskori haeSessionOstoskori, long tuoteId) {
        komento = new OstoksenLisaysKoriin(haeSessionOstoskori, tuoteId, varasto);
        return this;
    }

    public Komentotehdas ostoksenPoistoKorista(Ostoskori haeSessionOstoskori, long tuoteId) {
        komento = new OstoksenPoistoKorista(haeSessionOstoskori, tuoteId, varasto);
        return this;
    }

    public Komentotehdas ostoksenPoistoKorista(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori) {
        komento = new OstoksenSuoritus(nimi, osoite, luottokorttinumero, ostoskori, varasto, pankki, logistiikka);
        return this;
    }
    
    public boolean suorita() {
        return komento.suorita();
    }
}
