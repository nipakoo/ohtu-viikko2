/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.webkauppa.model.tietokantayhteydet;

import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import java.util.List;

/**
 *
 * @author albis
 */
public interface Listaus {

    List<Tuote> findAll();

    void save(Tuote tuote);
    
}
