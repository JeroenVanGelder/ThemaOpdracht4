package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ParkeerPlek implements Serializable{
    private ArrayList<ParkeerReservering> reserveringen;
	
    public ParkeerPlek() {
        reserveringen = new ArrayList<ParkeerReservering>();
    }

    public ArrayList<ParkeerReservering> getReservering() {
        return reserveringen;
    }
    
    public Calendar StringToDate(String s) throws ParseException{
        Calendar c = Calendar.getInstance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        Date dateObj = sdf.parse(s);
        
        c.setTime(dateObj);
        
        return c;
    }
    
    public boolean isBezet(String s) throws ParseException{
        Calendar c = StringToDate(s);
        boolean b = false;
        for(ParkeerReservering p : reserveringen)
        {
            if(c.equals(p.getDatum()))
            {
                b = true;
            }
        }
        return b;
        
    }
    
    public boolean reserveer(String datum, Klant k) throws ParseException{
        Calendar date = StringToDate(datum);
        boolean b = false;
        if(!isBezet(datum))
        {
            reserveringen.add(new ParkeerReservering(date, k));
            b = true;
        }
        return b;
    }

    public boolean reserveerAlsDatumVrijIs(String datum, Klant klant) throws ParseException
    {
        if (this.isBezet(datum) == false) {
            reserveer(datum, klant);
            return true;
        }
    }
}
