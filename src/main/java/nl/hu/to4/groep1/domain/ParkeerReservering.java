package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ParkeerReservering extends Dienst implements Serializable{

    private Calendar datum;
    private Klant klant;
    private Factuur deFactuur;

    public ParkeerReservering(Calendar datum, Klant klant) {
	    this.datum = datum;
        this.klant = klant;
        deFactuur = new Factuur(klant, this);
    }
       
    public Calendar getDatum(){
        return datum;
    }

    public void setDatum(Calendar nwDatum) {
        this.datum = nwDatum;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Factuur getDeFactuur() {
        return deFactuur;
    }

    public void setDeFactuur(Factuur deFactuur) {
        this.deFactuur = deFactuur;
    }
}
