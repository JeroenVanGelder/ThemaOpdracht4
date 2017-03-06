package nl.hu.to4.groep1.domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Bedrijf implements Serializable {

    private WeekPlanning[] weekplanning;
    private ArrayList<Werknemer> werknemers = new ArrayList<Werknemer>();
    private ArrayList<Klant> klantenRegister = new ArrayList<Klant>();
    private ParkeerPlek[] parkeerPlekken;
    private ArrayList<Artikel> voorraad = new ArrayList<Artikel>();
    private Bestelling bestellinglijst;
    private Auto auto;
    private ArrayList<Monteur> monteurLijst;


    public Bedrijf() {
        this.monteurLijst = new ArrayList<Monteur>();
        weekplanning = new WeekPlanning[54];
        parkeerPlekken = new ParkeerPlek[50];
    }

    public WeekPlanning getWeekplanningOpWeeknummer(int i) {
        return weekplanning[i];
    }

    public void addWeekplanning(WeekPlanning planning) {
        weekplanning[planning.getWeekNummer()] = planning;
    }

    public ArrayList<Klant> getKlantenRegister() {
        return klantenRegister;
    }

    public void voegKlantToe(Klant k) {
        klantenRegister.add(k);
    }

    public void voegWerknemerToe(Werknemer w) {
        werknemers.add(w);
    }

    public ArrayList<Werknemer> getAlleWerknemers() {
        return werknemers;
    }

    public ArrayList<Artikel> getVoorraad() {
        return voorraad;
    }

    public void addArtikel(Artikel a) {
        voorraad.add(a);
    }


    public void addMonteurAlsWerknemer(Werknemer w) {
        werknemers.add(w);
        if (w instanceof Monteur) {
            this.monteurLijst.add((Monteur) w);
        }
    }

    public Klant vindKlantOpNaam(String naam) {
        Klant klant = null;
        for (Klant k : klantenRegister) {
            klant = checkOvereenkomstTussenNaamEnKlant(naam, k);
        }
        return klant;
    }

    private static Klant checkOvereenkomstTussenNaamEnKlant(String naam, Klant klant) {
        Klant returnKlant = null;
        if (naam.equals(klant.getNaam())){
            klant = klant;
        }
        return returnKlant;
    }

    public Klant vindKlantOpAuto(Auto auto) {
        Klant klant = null;
        for (Klant k : klantenRegister) {
            if (k.getAutoLijst().contains(auto)) {
                klant = k;
            }
        }
        return klant;
    }

    public Klant vindKlantOpNaamEnAuto(String naam, Auto auto) {
        Klant klant = vindKlantOpAuto(auto);
        if (!klant.getNaam().equals(naam)) {
            for (Klant k : this.klantenRegister) {
                if (k.getNaam().equals(naam)) {
                    klant = k;
                }
            }
        }
        return klant;
    }

    public void setParkeerPlek(int parkeerPlekNummer, ParkeerPlek plek) {
        this.parkeerPlekken[parkeerPlekNummer] = plek;
    }

    public int getAantalVrijeParkeerplaatsenOpDatum(String datum) throws ParseException {
        int VrijeParkeerplaatsen = 0;
        for (ParkeerPlek p : parkeerPlekken) {
            if (p.isBezet(datum)) {
                VrijeParkeerplaatsen++;
            }
        }
        return VrijeParkeerplaatsen;
    }

    public boolean maakReservering(Klant klant, String date) throws ParseException {
        boolean b = false;
        for (ParkeerPlek parkeerPlek : parkeerPlekken) {
            if (parkeerPlek.reserveerAlsDatumVrijIs(date, klant))
            {
                break;
            }
        }
        return b;
    }

    public Klus getKlusOpPlanningDatum(PlanningDatum datum)
    {
        Klus klus = getKlusUitWeekPlanning(datum);
        return klus;
    }

    public Klus getKlusUitWeekPlanning(PlanningDatum datum)
    {
        WeekPlanning weekPlanning = getWeekplanningOpWeeknummer(datum.getWeeknummer());
        return weekPlanning.getKlussenOpPlanningDatum(datum);
    }

    public void schrijfBedrijfWeg() throws IOException {
        FileOutputStream fos = new FileOutputStream("bedrijf.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public Auto vindAutoOpKenteken(String kenteken) {
        return vindAutoUitKlantenregister(kenteken);
    }

    public Auto vindAutoUitKlantenregister(String kenteken)
    {
        for (Klant klant : klantenRegister) {
            return klant.vindAutoInAutolijst(kenteken);
        }
        return null;
    }

    public boolean klusInplannen(Klus k, int weekNummer, int dag, int aantalUur) {
        boolean returnBoolean = false;
        for (Monteur m : this.monteurLijst) {
            returnBoolean = m.planKlus(k, weekNummer, dag, aantalUur);
        }
        return returnBoolean;
    }
}
