package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Factuur implements Serializable{

	private Klus deKlus;
	private ParkeerReservering deReservatie;
	private Klant deKlant;

	public Factuur(){}
        
        public Factuur(Klant klant, Klus klus)
        {
            deKlant = klant;
            deKlus = klus;
        }
        
        public Factuur(Klant klant, ParkeerReservering pr)
        {
            deKlant = klant;
            deReservatie = pr;
        }

        public Klant getKlant() {
           return this.deKlant;
        }
        public Klus getKlus() {
            return this.deKlus;
        }

}
