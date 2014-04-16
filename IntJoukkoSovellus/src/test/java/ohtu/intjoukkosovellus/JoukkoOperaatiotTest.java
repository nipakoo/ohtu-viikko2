package ohtu.intjoukkosovellus;




import java.util.Arrays;
import ohtu.intjoukkosovellus.IntJoukko;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JoukkoOperaatiotTest {
    
    
    @Test
    public void testSomething() {
        IntJoukko eka = teeJoukko(1,2);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = IntJoukko.yhdiste(eka, toka);
        
        int[] vastauksenLuvut = new int[tulos.mahtavuus()];
        for (int i = 0; i < tulos.mahtavuus(); i++) {
            vastauksenLuvut[i] = tulos.haeAlkiot().get(i);
        }
        
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 

    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.lisaa(luku);
        }
        
        return joukko;
    }
}