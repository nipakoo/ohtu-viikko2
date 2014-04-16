package com.mycompany.webkauppa.ulkoiset_rajapinnat;

import com.mycompany.webkauppa.sovelluslogiikka.Ostos;
import java.util.*;

public class ToimitusjarjestelmaFasaadi implements Logistiikka {
    private ArrayList<String> toimitukset;

    public ToimitusjarjestelmaFasaadi() {
        toimitukset = new ArrayList<String>();
    }    
    
    @Override
    public void kirjaatoimitus(String nimi, String osoite, List<Ostos> ostokset){
        toimitukset.add( new Date() + " "+ nimi + " "+ osoite + "\n"+ merkkijonona(ostokset) );
    }
    
    @Override
    public ArrayList<String> toimitukset() {
        return toimitukset;
    }

    private String merkkijonona(List<Ostos> ostokset) {
        String mj = "";
        for (Ostos ostos : ostokset) {
            mj += " "+ostos.tuotteenNimi() + " x " +ostos.lukumaara() + "\n";
        }
        
        return mj;        
    }
}
