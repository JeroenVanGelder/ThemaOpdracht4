package nl.hu.to4.groep1.domain;

import java.io.Serializable;

public class ParkeerMedewerker extends Werknemer implements Serializable{

	private ParkeerReservering parkeerReservering;
        
        public ParkeerMedewerker(String naam, String straatnaam, int huisnummer, String woonplaats, String postcode, String email, String functie, double uurloon , String inlognaam , String wachtwoord)
        {
            super(naam, straatnaam, huisnummer, woonplaats, postcode, email, functie, uurloon,inlognaam , wachtwoord);
        }
}
