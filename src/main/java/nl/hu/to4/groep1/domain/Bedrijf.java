package nl.hu.to4.groep1.domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class Bedrijf implements Serializable{

        private WeekPlanning[] weekplanning;
	private ArrayList<Werknemer> werknemers = new ArrayList<Werknemer>();
	private ArrayList<Klant> klantenRegister = new ArrayList<Klant>();
        private ParkeerPlek[] parkeerPlekken;
        private ArrayList<Artikel> voorraad = new ArrayList<Artikel>();
	private Bestelling bestellinglijst;
	private Auto auto;
        private ArrayList<Monteur> monteurLijst;
    

	public Bedrijf()
        {
            this.monteurLijst = new ArrayList<Monteur>();
            weekplanning = new WeekPlanning[54];
            parkeerPlekken = new ParkeerPlek[50];
            
            
	}
        
        public ArrayList<Monteur> getMonteurLijst()
        {
            return this.monteurLijst;
        }

	public void checkVoorraad() {

	}
        
        public WeekPlanning getWeek(int i)
        {
            return weekplanning[i];
        }
      
        public WeekPlanning[] getWeekPlanning()
        {
            return weekplanning;
        }
        
      
        public void addWeekplanning(WeekPlanning planning)
        {
            weekplanning[planning.getWeekNummer()] = planning;
        }
        
        public ArrayList<Klant> getKlantenRegister()
        {
            return klantenRegister;
        }
        public void voegKlantToe(Klant k){
            klantenRegister.add(k);
        }
        public void voegWerknemerToe(Werknemer w){
            werknemers.add(w);
        }
        
        public ArrayList<Werknemer> getWerknemersRegister()
        {
            return werknemers;
        }
          public ArrayList<Artikel> getArtikelen(){
            return voorraad;
        }
        public void addArtikel(Artikel a){
            voorraad.add(a);
        }
        
        public void setKlanten(ArrayList<Klant> k){
            this.klantenRegister = k;
            
        }
        public void setWerknemers(ArrayList<Werknemer> w){
            
            this.werknemers = w;
        }
        
        
        public void addKlant(Klant k)
        {
            klantenRegister.add(k);
        }
        
        public Klant vindKlant(String s){
            Klant kl = null;
            for(Klant k: klantenRegister){
                if(s.equals(k.getNaam()))
                    kl = k;
            }
            return kl;
        }
           
        public void addWerknemer(Werknemer w)
        {
            werknemers.add(w);
            if(w instanceof Monteur)
            {
                this.monteurLijst.add((Monteur)w);
            }
        }
        
        public Klant vindEigenaar(Auto a)
        {
            Klant klant = null;
            for(Klant k: klantenRegister)
            {
                if(k.getAutoLijst().contains(a))
                {
                    klant = k;
                }
            }
            return klant;
        }
        
        public void setWerknemer(Werknemer w)
        {
            if(!werknemers.contains(w))
            {
                werknemers.add(w);
            }
        }
        
        public void setParkeerPlek(int i, ParkeerPlek p)
        {
            this.parkeerPlekken[i] = p;
        }
        
        public ParkeerPlek getParkeerPlek(int i)
        {
            return parkeerPlekken[i];
        }
        
        public ParkeerPlek[] getAllePlekken(){
            return parkeerPlekken;
        }
        
        public int getVrijePlekken(String s) throws ParseException{
            System.out.println("Bedrijf: getVrijePlekken: " + s);
            int vrijePlekken = 50;
            Calendar c = Calendar.getInstance();
        
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            Date dateObj = sdf.parse(s);
        
            System.out.println("Bedrijf: " + dateObj);
            
            c.setTime(dateObj);
            System.out.println("check 1");
            for(ParkeerPlek p : parkeerPlekken){
                System.out.println("check 2: " + s + " | " + p.getClass());
                if(p.getBezet(s)){
                    System.out.println("check 3");
                    vrijePlekken--;
                }
         }
            return vrijePlekken;
        }
        
        public boolean maakReservering(Klant k, String date) throws ParseException{
            System.out.println("Bedrijf, maakReservering: Beginnen aan maakreservering");
            boolean b = false;
            for(ParkeerPlek p: parkeerPlekken){
                if(p.getBezet(date) == false){
                    p.reserveer(date, k);
                    b = true;
                    break;
                }
            }
            return b;
        }

        
        public Klus getKlus(int week, int dag, int uur)
        {
            Klus k = null;
            System.out.println("checkpoint 2 : " + "| week :" + week + "| dag : " + dag + "| uur : " + uur);
            
            WeekPlanning wP = this.getWeek(week);

            if(wP.getKlussen()[dag][uur] != null)
            {
                k = wP.getKlussen()[dag][uur];
            }
            System.out.println("Checkpoint 3 : " + "| Auto : " + k.getAuto().getKenteken());
            return k;
        }
        public void schrijfBedrijfWeg () throws IOException
        {
            FileOutputStream fos = new FileOutputStream("bedrijf.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            System.out.println("bedrijf is weggeschreven naar bedrijf.obj");
        }

        public Auto vindAuto(String auto) {
        Auto a = null;
            for(Klant k: klantenRegister)
            {
                for(Auto at: k.getAutoLijst())
                {
                    if(at.getKenteken().equals(auto))
                    {
                        a = at;
                    }
                }
            }
            return a;
        }
        
        public boolean klusInplannen(Klus k, int weekNummer, int dag, int aantalUur) 
        {
        boolean returnBoolean = false;
        for(Monteur m : this.monteurLijst)
        {
            for(int i = 0; i < 8; i++)
            {
                if(m.checkBeschikbaarheid(dag, i) == true)
                {
                    m.addKlus(k, weekNummer, dag, i);
                    aantalUur--;
                }
                if(aantalUur == 0)
                {
                    i=8;
                    returnBoolean = true;
                }
            }
        }
        return returnBoolean;
    }

    public Klant vindKlant(String klant, Auto auto) 
    {
        Klant klant1 = vindEigenaar(auto);
        if(!klant1.getNaam().equals(klant))
        {
            for(Klant k : this.klantenRegister)
            {
                if(k.getNaam().equals(klant))
                {
                    klant1 = k;
                }
            }
        }
        return klant1;
    }
    public Monteur getMonteur(String monteurSelect) {
       Monteur returnM = null;
       for(Monteur m : this.monteurLijst)
       {
           if(m.getNaam().equals(monteurSelect))
           {
               returnM = m;
           }
       }
       return returnM;
    }
    public ArrayList<Factuur> getAlleKlantFacturen() {
        ArrayList<Factuur> klantFacturen = new ArrayList<Factuur>();
        for(Monteur m : this.monteurLijst) {
            System.out.println("check 1");
            for(int i = 0 ; i < 54 ; i++) {
                System.out.println("check 2");
                if(m.getWeekPlanning(i) != null) {
                for(Klus[] k1 : m.getWeekPlanning(i).getKlussen()) {
                    System.out.println("check 3");
                    for(Klus k2 : k1) {
                        System.out.println("check 4");
                        if(k2 != null) {
                            System.out.println("check 5");
                            if(k2.getFactuur() != null) {
                                System.out.println("check 6");
                                if(!klantFacturen.contains(k2.getFactuur())) {
                                    klantFacturen.add(k2.getFactuur());
                                    System.out.println("klasse: " + k2.getFactuur().getClass());
                                }
                            }
                            }
                        }
                    }
                }
            }
        }
        return klantFacturen;
    }
    
    public double getFactuurKosten(Factuur f) {
        double d = 0.0;
        for(Monteur m : this.monteurLijst) {
            for(int i = 0 ; i < 54 ; i++) {
                for(Klus[] k1 : m.getWeekPlanning(i).getKlussen()) {
                    for(Klus k2 : k1) {
                        if(k2 != null) {
                            if(k2.getFactuur() != null) {
                                if(k2.getFactuur() == f) {
                                    d = d + m.getUurLoon();
                                }                              
                            }
                        }
                    }
                }
            }
        }
        return d;
    }
    
}
