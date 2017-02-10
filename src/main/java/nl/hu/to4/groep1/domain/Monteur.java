package nl.hu.to4.groep1.domain;

import java.io.Serializable;

public class Monteur extends Werknemer implements Serializable{


	private boolean beschikbaarheid[][];
        private WeekPlanning[] weekPlanning;
        
	public Monteur(String naam, String straatnaam, int huisnummer, String woonplaats, String postcode, String email, String functie, double uurloon, String inlognaam , String wachtwoord)
        {
            super(naam, straatnaam, huisnummer, woonplaats, postcode, email, functie, uurloon, inlognaam, wachtwoord);
            weekPlanning = new WeekPlanning[54];
        }
        public void setBeschikbaarheid(boolean[][] besch)
        {
            for(int i = 0; i < 5; i++)
            {
                for(int y = 0; y < 8; y++)
                {
                    boolean b = besch[i][y];
                    beschikbaarheid[i][y] = b;
                }
            }
        }

	public boolean[][] getBeschikbaarheid()
        {
            return beschikbaarheid;
        }
        
        public boolean checkBeschikbaarheid(int d, int u)
        {
            return beschikbaarheid[d][u];
        }
        
        
        public boolean addKlus(Klus k, int d, int u, int w)
        {
            boolean geslaagd = false;
            if(checkBeschikbaarheid(d, u))
            {
                if(weekPlanning[w].getKlussen()[d][u] == null)
                {
                    weekPlanning[w].setBehandelDatum(k, d, u);
                    geslaagd = true;
                }
            }
            return geslaagd;
        }
        public WeekPlanning getWeekPlanning(int i)
        {
            System.out.println("check : " + this.weekPlanning.length);
            WeekPlanning obj = null;
            if(weekPlanning != null)
            {
               obj = weekPlanning[i];
            }
            return obj;
        }
        
        public void addWeekPlanning(WeekPlanning wp, int i)
        {
            this.weekPlanning[i] = wp;
        }

}
