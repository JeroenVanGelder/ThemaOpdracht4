package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class Auto implements Serializable{

	private String kenteken;
	private Calendar laatsteOnderhoud;

	public Auto(String kenteken , Calendar laatsteOnderhoud){
		this.kenteken = kenteken;
		this.laatsteOnderhoud = laatsteOnderhoud;
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
