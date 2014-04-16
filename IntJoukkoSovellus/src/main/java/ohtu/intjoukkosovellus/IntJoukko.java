
package ohtu.intjoukkosovellus;

import java.util.ArrayList;

public class IntJoukko { 
    private ArrayList<Integer> ljono;

    public IntJoukko() {
        ljono = new ArrayList<>();
    }
    
    public ArrayList<Integer> haeAlkiot() {
        return ljono;
    }

    public void lisaa(int luku) {
        if (!ljono.contains(luku)){
            ljono.add(luku);
        }
    }

    public boolean kuuluu(int luku) {
        return ljono.contains(luku);
    }

    public void poista(int luku) {
        ljono.remove(ljono.indexOf(luku));
    }

    public int mahtavuus() {
        return ljono.size();
    }


    @Override
    public String toString() {
        return ljono.toString();
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        
        kopioiUudetAlkiot(x, a);
        kopioiUudetAlkiot(x, b);
        
        return x;
    }
    
    private static void kopioiUudetAlkiot(IntJoukko kohde, IntJoukko lahde) {
        ArrayList<Integer> alkiot = lahde.haeAlkiot();
        
        for (int i = 0; i < lahde.mahtavuus(); i++) {
            if (!kohde.kuuluu(alkiot.get(i))) {
                kohde.lisaa(alkiot.get(i));
            }
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (b.kuuluu(a.haeAlkiot().get(i))) {
                y.lisaa(a.haeAlkiot().get(i));
            }
        }
        return y;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (!b.kuuluu(a.haeAlkiot().get(i))) {
                z.lisaa(a.haeAlkiot().get(i));
            }
        }
        return z;
    }
}