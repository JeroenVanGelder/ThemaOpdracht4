package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Rami on 21-5-2015.
 */
public abstract class Werknemer implements Serializable{

    private String naam;
    private String straatnaam;
    private int huisnummer;
    private String woonplaats;
    private String postcode;
    private String email;
    private String functie;
    private double uurloon;
    private String inlognaam;
    private String wachtwoord;

    private ArrayList<ParkeerMedewerker> parkeerMedewerker = new ArrayList<ParkeerMedewerker>();

    public Werknemer(String naam, String straatnaam, int huisnummer, String woonplaats, String postcode, String email, String functie, double uurloon,String inlognaam,String wachtwoord) {
        this.naam = naam;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.email = email;
        this.functie = functie;
        this.uurloon = uurloon;
        this.inlognaam = inlognaam;
        this.wachtwoord = wachtwoord;
    }
    public boolean checkWachtwoord(String pw){
        boolean b = false;
        if( wachtwoord.equals(wachtwoord)){
            b = true;
        }
        return b;
    }
    public String getNaam(){
        return naam;
    }
        public boolean werknemerBestaat(Werknemer w){
        boolean werknemerBestaat = false;
          if (naam.equals(w.naam)) {
                      werknemerBestaat = true;
                }
          return werknemerBestaat;
    }
    public boolean naamCheck(String nm){
        boolean n = false;
        if (this.inlognaam.equals(nm)) {
            n = true;
        }
        return n;
    }
    public String getFunctie(){
        return functie;
    }
    public double getUurLoon() {
        return uurloon;
    }

}
