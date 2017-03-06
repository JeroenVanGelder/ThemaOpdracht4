package nl.hu.to4.groep1.domain;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Dienst implements Serializable, BelastbaarProduct {

	private double totaalPrijs;
	private ArrayList<ParkeerReservering> reservering = new ArrayList<ParkeerReservering>();
	private ArrayList<Klus> klus = new ArrayList<Klus>();

	private Factuur deFactuur;

	public Dienst (){

	}

}
