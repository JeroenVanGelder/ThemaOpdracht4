package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Klus extends Dienst implements Serializable{

	private ArrayList<GebruiktArtikel> gebruiktArtikel = new ArrayList<GebruiktArtikel>();
	

	private String beschrijving;
	private boolean klaar;
	private Auto deAuto;
	private Monteur monteur;
        private Factuur deFactuur;

	public Klus(String beschrijving) {
		this.beschrijving = beschrijving;       
	}
        
        public Klus(String beschrijving,Auto auto ,Klant klant)
        {
            this.beschrijving = beschrijving;
            this.deAuto = auto;
            if(klant.getAutoLijst().contains(auto))
            {
                deFactuur = new Factuur(klant, this);
            }
            
            else
            {
                 deFactuur = new Factuur();       
            }
        }

	public double berekenKosten() {
		return 0;
	}
        
        public String getBeschrijving()
        {

            return "" + beschrijving;

        }

	public void voegArtikel(Artikel artikel, int aantal) {

	}
        
        public void setMonteur(Monteur m)
        {
            monteur = m;
        }
        
        public Werknemer getMonteur()
        {
            return monteur;
        }

        public void setAuto(Auto a)
        {
            deAuto = a;
        }
        
        public Auto getAuto()
        {
            return deAuto;
        }

        public String getAutoKenteken()
        {
            return deAuto.getKenteken();
        }
        
        public Factuur getFactuur()
        {
            return deFactuur;
        }
        
        public Klant getKlant()
        {
            return this.deFactuur.getKlant();
        }
}
