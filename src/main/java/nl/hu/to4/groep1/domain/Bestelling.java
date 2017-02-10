package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Bestelling implements Serializable{

    private ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
     
    public Bestelling(){
         
    }
     
    public void voegArtikelToe(Artikel a){
        artikelen.add(a);
    }
     
    @SuppressWarnings("rawtypes")
    public HashMap checkVoorraad(){
        HashMap<Artikel, Integer> hm = new HashMap<Artikel, Integer>();
        for(Artikel a : artikelen){
            if (a.getAantal() - a.getMinVoorraad() <= 0){
                hm.put(a, (int) Math.abs(a.getAantal() - a.getMinVoorraad()));
            }
        }
        return hm;
    }
}