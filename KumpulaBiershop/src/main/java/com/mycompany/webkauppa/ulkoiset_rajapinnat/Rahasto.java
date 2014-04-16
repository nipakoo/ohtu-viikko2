/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.webkauppa.ulkoiset_rajapinnat;

import java.util.ArrayList;

/**
 *
 * @author albis
 */
public interface Rahasto {

    boolean maksa(String nimi, String luottokortti, int hinta);

    ArrayList<String> maksut();
    
}
