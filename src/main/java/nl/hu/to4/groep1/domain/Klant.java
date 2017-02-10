package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Klant implements Serializable{

	private ArrayList<Auto> autos = new ArrayList<Auto>();
	private String naam;
	private String Straatnaam;
	private int huisnummer;
	private String woonplaats;
	private String postcode;
	private Calendar laatsteBezoek;
        private String inlognaam;
        private String inloggegevens;
        private String Functie = "Klant";
        

	public Klant(String naam, String straatnaam, int huisnummer, String woonplaats, String postcode, String inlognaam, String inloggegevens) {
        this.naam = naam;
        this.Straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.inlognaam = inlognaam;
        this.inloggegevens = inloggegevens;
    }
        
        public void setAuto(Auto a)
        {
            autos.add(a);
        }
        
        public ArrayList<Auto> getAutoLijst()
        {
            return autos;
        }
        
        public String getNaam()
        {
            return naam;
        }
        
      public String getFunctie(){
        return  Functie ;
    }
        
        
        public boolean login(String pw){
        boolean b = false;
        if( inloggegevens.equals(pw)){
            b = true;
        }
        return b;
    }
         public boolean userBestaat(Klant k){
        boolean userBestaat = false;
          if (naam.equals(k.naam)) {
                            userBestaat = true;
                        }
          return userBestaat;
    }

    public boolean naamCheck(String nm){
        boolean n = false;
        if (this.inlognaam.equals(nm)) {
            n = true;
        }
        return n;
    }
}
