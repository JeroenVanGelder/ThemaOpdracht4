package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Artikel implements Serializable{
    public static final double BTW = 0.21;
    private int artikelId;
    private String naam;
    private double prijs;
    private double aantal;
    private double minVoorraad;
     
    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;
  
    }
     
    public Artikel(String naam, double prijs, double minVoorraad){
        this.naam = naam;
        this.prijs = prijs;
        this.minVoorraad = minVoorraad;

    }
     
    public double isErGenoegOpVoorraad() {
        if(aantal - minVoorraad < 0){
            return (aantal - minVoorraad);
        }
        return 0.0;
    }
     
    public void veranderAantal(double verandering) {
        aantal += verandering;
    }
 
    public int getArtikelId() {
        return artikelId;
    }
 
    public String getNaam() {
        return naam;
    }
 
    public double getPrijs() {
        prijs = prijs * (1+BTW);
        return prijs;
    }
     
    public double getAantal() {
        return aantal;
    }
     
    public void voegAantalToe(double aantal){
        this.aantal += aantal;
    }
 
    public void setAantal(double aantal) {
        this.aantal = aantal;
    }
 
    public double getMinVoorraad() {
        return minVoorraad;
    }
     
    public String toString(){
         String s = naam + " : " + aantal +  " aanwezig, de prijs van dit artikel is : " + prijs + ". De minimum voorraad is : " + minVoorraad;
         return s;
    }
}
