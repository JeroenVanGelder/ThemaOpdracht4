package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeekPlanning implements Serializable{
        private Klus klussen[][] = new Klus[5][8];
        
        private int weekNummer;

	public WeekPlanning(int wN) 
        {
            weekNummer = wN;
	}

	public void setBehandelDatum(Klus klus, int dag, int uur) 
        {
            klussen[dag][uur] = klus;
        }
        
        public int getWeekNummer()
        {
            return weekNummer;
        }
        
        public Klus[][] getKlussen()
        {
            return klussen;
        }

        public Klus getKlussenOpPlanningDatum(PlanningDatum datum)
        {
            return klussen[datum.getDagInDeWeek()][datum.getUurOpDeDag()];
        }

}
