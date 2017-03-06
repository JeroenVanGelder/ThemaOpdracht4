/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.domain;


import java.io.Serializable;

public class Eigenaar extends Werknemer implements Serializable{

        
        Eigenaar(String naam, String straatnaam, int huisnummer, String woonplaats, String postcode, String email, String functie, double uurloon, String inlognaam, String wachtwoord)
        {
            super(naam, straatnaam, huisnummer, woonplaats, postcode, email, functie, uurloon,inlognaam , wachtwoord);
        }
}
