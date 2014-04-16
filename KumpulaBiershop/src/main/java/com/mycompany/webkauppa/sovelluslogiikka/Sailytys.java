/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.webkauppa.sovelluslogiikka;

import java.util.List;

/**
 *
 * @author albis
 */
public interface Sailytys {

    Tuote etsiTuote(long id);

    boolean lisaaTuote(String nimi, int hinta, int saldo);

    boolean otaVarastosta(long id);

    void paivitaTuotteenTiedot(long tuoteId, int uusiHinta, int uusiSaldo);

    void palautaVarastoon(long id);

    void palautaVarastoon(Ostos ostos);

    List<Tuote> tuotteidenLista();
    
}
