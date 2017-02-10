package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import nl.hu.to4.groep1.domain.Artikel;


public class Onderdeel extends Artikel implements Serializable{

	private String beschrijving;
     
    public Onderdeel(String naam, double prijs, String beschrijving, double minVoorraad) {
        super(naam, prijs, minVoorraad);
 
        this.setBeschrijving(beschrijving);
    }
 
    public String getBeschrijving() {
        return beschrijving;
    }
 
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
     
    public String toString(){
        String s = " - " + super.getNaam()+ ", Aantal: " + super.getAantal();
        return s;
    }
}