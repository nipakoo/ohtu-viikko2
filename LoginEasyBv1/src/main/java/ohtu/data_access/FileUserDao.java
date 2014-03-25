/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author albis
 */
public class FileUserDao implements UserDao{
    private Scanner lukija;
    
    public FileUserDao(String tiedostonNimi) {
        File tiedosto = new File("salasanat.txt");
        
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            try {
                tiedosto.createNewFile();
                lukija = new Scanner(tiedosto);
            } catch (IOException ex1) {
                System.out.println("Virhe tiedostoa luotaessa! " + ex.getMessage());
            }
        }
    }

    @Override
    public List<User> listAll() {
        ArrayList<User> kayttajat = new ArrayList<User>();
        
        while (lukija.hasNext()) {
            kayttajat.add(new User(lukija.next(), lukija.next()));
        }
        
        return kayttajat;
    }

    @Override
    public User findByName(String name) {
        while (lukija.hasNext()) {
            String kayttaja = lukija.next();
            if (kayttaja.equals(name)) {
                return new User(kayttaja, lukija.next());
            }
        }
        
        return null;
    }

    @Override
    public void add(User user) {
        FileWriter kirjoittaja;
        
        try {
             kirjoittaja = new FileWriter("salasanat.txt");
             kirjoittaja.append(user.getUsername() + " " + user.getPassword() + "\n");
        } catch (IOException ex) {
            System.out.println("Virhe! Tiedostoa ei löydetty! " + ex.getMessage());
        }
    }
    
}
