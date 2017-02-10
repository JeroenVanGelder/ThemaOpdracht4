package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.HashMap;

public class Leverancier implements Serializable{

	private String naam;
	private String straatnaam;
	private int huisnummer;
	private String woonplaats;
	private String postcode;
	private String email;
           private int telefoonnummer;
    private HashMap<Artikel, Double> artikelen = new HashMap<Artikel, Double>();
     
    public Leverancier(String naam, String email){
        this.naam = naam;
        this.email = email;
    }
     
    public Leverancier(String naam, int telefoonnummer){
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
    }
 
    public Leverancier(String naam, String email, int telefoonnummer) {
        this.naam = naam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
    }
     
    public void voegArtikelToe(Artikel a, double prijs){
        artikelen.put(a, prijs);
    }
     
    public void verwijderArtikel(Artikel art){
        for (Artikel a : artikelen.keySet()){
            if(a.equals(art)){
                artikelen.remove(a);
            }
        }
    }
     
    public boolean levertArtikel(Artikel a){
        boolean b = false;
        for (Artikel art : artikelen.keySet()){
            if(art.equals(a)){
                b = true;
            }
        }
        return b;
    }
     
    public double getPrijs(Artikel a){
        double d = 0.00;
        for(Artikel art : artikelen.keySet()){
            if(art.equals(a)){
                d = artikelen.get(art);
            }
        }
        return d;
    }
 
    public String getNaam() {
        return naam;
    }
 
    public String getEmail() {
        return email;
    }
 
    public int getTelefoonnummer() {
        return telefoonnummer;
    }
}