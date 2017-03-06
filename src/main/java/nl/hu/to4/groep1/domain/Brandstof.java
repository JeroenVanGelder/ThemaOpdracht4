package nl.hu.to4.groep1.domain;

import java.io.Serializable;

public class Brandstof implements Serializable{

    private final MyArtikel artikel;

    public Brandstof(String naam, double prijs){
        artikel = new MyArtikel(naam, prijs);
    }
     
    public Brandstof(String naam, double prijs, double minVoorraad){
        artikel = new MyArtikel(naam, prijs, minVoorraad);
    }

    public double isErGenoegOpVoorraad() {
        return artikel.isErGenoegOpVoorraad();
    }

    public void veranderAantal(double verandering) {
        artikel.veranderAantal(verandering);
    }

    public int getArtikelId() {
        return artikel.getArtikelId();
    }

    public String getNaam() {
        return artikel.getNaam();
    }

    public double getPrijs() {
        return artikel.getPrijs();
    }



    public double getAantal() {
        return artikel.getAantal();
    }

    public double getMinVoorraad() {
        return artikel.getMinVoorraad();
    }

    public MyArtikel getArtikel()
    {
        return this.artikel;
    }

    public String toString() {
        return artikel.toString();
    }

    private class MyArtikel extends Artikel {
        public MyArtikel(String naam, double prijs) {
            super(naam, prijs);
        }

        public MyArtikel(String naam, double prijs, double minVoorraad) {
            super(naam, prijs, minVoorraad);
        }

        public String toString(){
            String s = " - " + super.getNaam() + ", Aantal: " + super.getAantal();
            return s;
        }
    }

    public double getPrijsMetBTW(double prijsPerLiter, double btwInPercentage, double liter, int kortingFactor)
    {
        return new PrijsBTW(prijsPerLiter, btwInPercentage, liter, kortingFactor).invoke();
    }

    private class PrijsBTW {
        private double prijsPerLiter;
        private double btwInPercentage;
        private double liter;
        private int kortingFactor;

        public PrijsBTW(double prijsPerLiter, double btwInPercentage, double liter, int kortingFactor) {
            this.prijsPerLiter = prijsPerLiter;
            this.btwInPercentage = btwInPercentage;
            this.liter = liter;
            this.kortingFactor = kortingFactor;
        }

        public double invoke() {
            double prijsMetBTW = verekenPrijsMetLiter(liter, prijsPerLiter);
            prijsMetBTW = berekenBTW(prijsMetBTW, btwInPercentage);
            prijsMetBTW = berekenKorting(prijsMetBTW, kortingFactor);
            return prijsMetBTW;
        }

        public double verekenPrijsMetLiter(double liter, double prijsPerLiter)
        {
            return liter * prijsPerLiter;
        }

        public double berekenBTW(double prijsExBTW, double btwInPercentage){
            return prijsExBTW * (1 + btwInPercentage);
        }

        public double berekenKorting(double prijsExKorting, double kortingFactor)
        {
            for(int i = 0; i < kortingFactor; i ++)
            {
                prijsExKorting = prijsExKorting * 0.99;
            }
            return prijsExKorting;
        }
    }
}