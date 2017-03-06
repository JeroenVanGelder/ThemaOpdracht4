package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class Auto implements Serializable{

	private String kenteken;
	private Calendar laatsteOnderhoud;
    private String model;
    private boolean heeftSpoiler;
    private boolean heeftVerfbeurt;

	public Auto(String kenteken , Calendar laatsteOnderhoud){
		this.kenteken = kenteken;
		this.laatsteOnderhoud = laatsteOnderhoud;
        model = null;
        heeftSpoiler = false;
        heeftVerfbeurt = false;
	}

    public Auto(String kenteken , Calendar laatsteOnderhoud, String model, boolean heeftSpoiler, boolean heeftVerfbeurt)
    {
        this.kenteken = kenteken;
        this.laatsteOnderhoud = laatsteOnderhoud;
        this.model = model;
        this.heeftSpoiler = heeftSpoiler;
        this.heeftVerfbeurt = heeftVerfbeurt;
    }

	public Calendar localDateToCalendar(int month, int i) {
        LocalDate d = null;
        Calendar c = Calendar.getInstance();
        c.set(d.getYear(), d.getMonthValue()-1, d.getDayOfMonth());
        return c;
    }
	public boolean onderhoudsbeurtNodig() {
        boolean b = false;
        if(localDateToCalendar(Calendar.MONTH, -6).after(laatsteOnderhoud)) {
            b = true;
        }
		return b;
	}
        
        public String getKenteken()
        {
            return kenteken;
        }
}
