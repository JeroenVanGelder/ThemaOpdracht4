package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Klant implements Serializable{

	private ArrayList<Auto> autolijst = new ArrayList<Auto>();
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
            autolijst.add(a);
        }
        
        public ArrayList<Auto> getAutoLijst()
        {
            return autolijst;
        }
        
        public String getNaam()
        {
            return naam;
        }
        
      public String getFunctie(){
        return  Functie ;
    }

    public Auto vindAutoInAutolijst(String kenteken)
    {
        for (Auto auto : autolijst) {
            if (auto.getKenteken().equals(kenteken)) {
                return auto;
            }
        }
        return null;
    }
        
        
        public boolean login(String pw)
        {
        return inloggegevens.equals(pw);
        }

         public boolean userBestaat(Klant k)
         {
            return naam.equals(k.naam);
         }

        public boolean naamCheck(String nm)
        {
            return this.inlognaam.equals(nm);
        }

}
