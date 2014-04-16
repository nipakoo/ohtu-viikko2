/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author albis
 */
public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int vanhaArvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        vanhaArvo = Integer.parseInt(tuloskentta.getText());
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText(""+sovellus.tulos());
    }

    @Override
    public void peru() {
        tuloskentta.setText(""+vanhaArvo);
    }
    
}
