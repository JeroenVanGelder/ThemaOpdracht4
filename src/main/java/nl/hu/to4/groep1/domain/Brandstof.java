package nl.hu.to4.groep1.domain;

import java.io.Serializable;

public class Brandstof extends Artikel implements Serializable{
     
    public Brandstof(String naam, double prijs){
        super(naam, prijs);
    }
     
    public Brandstof(String naam, double prijs, double minVoorraad){
        super(naam, prijs, minVoorraad);
    }
     
    public String toString(){ 
        String s = " - " + super.getNaam() + ", Aantal: " + super.getAantal();
        return s;
    }
}