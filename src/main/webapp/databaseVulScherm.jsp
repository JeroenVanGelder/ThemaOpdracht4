<%-- 
    Document   : databaseVulScherm
    Created on : May 18, 2015, 9:02:48 AM
    Author     : Jeroen
--%>

<%@page import="java.util.Calendar"%>
<%@page import="nl.hu.to4.groep1.domain.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
           Calendar c = Calendar.getInstance();
           //c = setDate(Calendar.now());
           Bedrijf bedrijf = new Bedrijf(); 
           // eerst maak ik een weekplanning aan
           WeekPlanning weekplanning = new WeekPlanning(0);
           // dan maak ik 2 monteuren aan
           Monteur m1 = Werknemer.createMonteur("Jan", new Adres("Jansplein", 44, "Arnhem", "6782 HU"), "ATDwebGroep1@gmail.com", "Monteur", 100.0, "jan", "jan");
           Eigenaar e1 = Werknemer.createEigenaar("Henk", "Paladein", 44, "Henklaan", "6782 HE", "Henk@gmail.com", "Eigenaar", 1.0, "henk", "henk");
           Monteur m2 = Werknemer.createMonteur("Pieter", new Adres("Hertoglaan", 23, "Arnhem", "6823 HG"), "ATDwebGroep1@gmail.com", "Monteur", 90.0, "pieter", "pieter");
           ParkeerMedewerker pm1 = Werknemer.createParkeerMedewerker("Jopie", "butjeslaan", 1, "het dorp", "3789 WY", "ATDwebGroep1@gmail.com", "ParkeerMedewerker", 200, "jopie", "jopie");

            bedrijf.addMonteurAlsWerknemer(m1);
            bedrijf.addMonteurAlsWerknemer(m2);
            bedrijf.addMonteurAlsWerknemer(e1);
            bedrijf.addMonteurAlsWerknemer(pm1);
            // dan maak ik voorbeeld klussen aan
           Klant klant1 = new Klant("Jeroen", "Johan de Wittlaan", 178, "Arnhem", "6828 WN", "jeroen", "jeroen");
           Klant klant2 = new Klant("Rami", "Edense straatlaan", 34, "Ede", "1515 EY", "Rami", "Rami");
           Klant klant3 = new Klant("Jordi", "Johan de Wittlaan", 67, "Utka", "8126 JD", "Jordi", "Jordi");
           Klant klant4 = new Klant("Jerry", "Johan de Wittlaan", 1, "Ochten", "2671 FU", "Jerry", "Jerry");
           Klant klant5 = new Klant("Hendrik", "Henrikstraat", 14, "Hendrikstad", "3619 WU", "Hendrik", "Hendrik");
           Klant klant6 = new Klant("Pieter", "PIETERLAAAAAAN", 3, "Pieterstad", "3678 AU", "Pieter", "Pieter");
           Klant klant7 = new Klant("Klaas", "Klaas vaak", 1337, "Noordpool", "0000 AA", "Klaas", "Klaas");
           Klant klant8 = new Klant("Face", "Hunter", 1, "win/loss", "1000 WL", "Face", "Face");
           Klant klant9 = new Klant("Pieter", "Die anderestraat", 178, "Arnhem", "7362 HA", "Pieter", "Pieter");
           Klant klant10 = new Klant("Dirk", "Prins mauritsplain", 41, "Arnhem", "6828 UH", "Dirk", "Dirk");
           
           bedrijf.voegKlantToe(klant1);
           bedrijf.voegKlantToe(klant2);
           bedrijf.voegKlantToe(klant3);
           bedrijf.voegKlantToe(klant4);
           bedrijf.voegKlantToe(klant5);
           bedrijf.voegKlantToe(klant6);
           bedrijf.voegKlantToe(klant7);
           bedrijf.voegKlantToe(klant8);
           bedrijf.voegKlantToe(klant9);
           bedrijf.voegKlantToe(klant10);
           
           Auto a1 = new AutoBuilder().setKenteken("AE-36-UE").setLaatsteOnderhoud(c).createAuto();
           Auto a2 = new AutoBuilder().setKenteken("YS-92-ME").setLaatsteOnderhoud(c).createAuto();
           Auto a3 = new AutoBuilder().setKenteken("AU-37-DU").setLaatsteOnderhoud(c).createAuto();
           Auto a4 = new AutoBuilder().setKenteken("MR-27-DJ").setLaatsteOnderhoud(c).createAuto();
           Auto a5 = new AutoBuilder().setKenteken("VC-83-EH").setLaatsteOnderhoud(c).createAuto();
           Auto a6 = new AutoBuilder().setKenteken("EH-37-DG").setLaatsteOnderhoud(c).createAuto();
           Auto a7 = new AutoBuilder().setKenteken("DH-16-HG").setLaatsteOnderhoud(c).createAuto();
           Auto a8 = new AutoBuilder().setKenteken("JE-00-KK").setLaatsteOnderhoud(c).createAuto();
           Auto a9 = new AutoBuilder().setKenteken("AU-28-UK").setLaatsteOnderhoud(c).createAuto();
           Auto a10 = new AutoBuilder().setKenteken("QM-94-ME").setLaatsteOnderhoud(c).createAuto();
           Auto a11 = new AutoBuilder().setKenteken("FY-72-HH").setLaatsteOnderhoud(c).createAuto();
           Auto a12 = new AutoBuilder().setKenteken("YY-47-EY").setLaatsteOnderhoud(c).createAuto();
           Auto a13 = new AutoBuilder().setKenteken("UE-93-ME").setLaatsteOnderhoud(c).createAuto();
           Auto a14 = new AutoBuilder().setKenteken("RM-27-DU").setLaatsteOnderhoud(c).createAuto();
           Auto a15 = new AutoBuilder().setKenteken("CV-83-GH").setLaatsteOnderhoud(c).createAuto();
           
           klant1.setAuto(a1);
           klant1.setAuto(a11);
           klant2.setAuto(a2);
           klant3.setAuto(a3);
           klant3.setAuto(a13);
           klant3.setAuto(a14);
           klant4.setAuto(a4);
           klant5.setAuto(a5);
           klant2.setAuto(a6);
           klant7.setAuto(a7);
           klant7.setAuto(a12);
           klant8.setAuto(a8);
           klant9.setAuto(a9);
           klant9.setAuto(a15);
           klant10.setAuto(a10);
           
           Klus k1 = new Klus("Total loss", a11, bedrijf.vindKlantOpAuto(a11));
           Klus k2 = new Klus("Deuk in de zijkant", a14, bedrijf.vindKlantOpAuto(a14));
           Klus k3 = new Klus("Uitlaat rookt", a6, bedrijf.vindKlantOpAuto(a6));
           Klus k4 = new Klus("Mist een deur", a4, bedrijf.vindKlantOpAuto(a4));
           Klus k5 = new Klus("Nieuwe lak nodig", a9, bedrijf.vindKlantOpAuto(a9));
           Klus k6 = new Klus("APK", a10, bedrijf.vindKlantOpAuto(a10));
           Klus k7 = new Klus("Ruitenwissers & spiegels", a3, bedrijf.vindKlantOpAuto(a3));
           Klus k8 = new Klus("Nieuwe spoiler nodig", a8, bedrijf.vindKlantOpAuto(a8));
           Klus k9 = new Klus("Echt alles", a7, bedrijf.vindKlantOpAuto(a7));
           Klus k10 = new Klus("Toeter toeterd niet had genoeg", a2, bedrijf.vindKlantOpAuto(a2));
           Klus k11 = new Klus("Motorkap zit echt veel te stevig", a11, bedrijf.vindKlantOpAuto(a1));

           k1.setMonteur(m1);
           k2.setMonteur(m2);
           k3.setMonteur(m1);
           k4.setMonteur(m2);
           k5.setMonteur(m1);
           k6.setMonteur(m2);
           k7.setMonteur(m1);
           k8.setMonteur(m2);
           k9.setMonteur(m1);
           k10.setMonteur(m2);
           k11.setMonteur(m2);
           
           
           
           
           
           weekplanning.setBehandelDatum(k1,2,3);
           weekplanning.setBehandelDatum(k1,2,4);
           weekplanning.setBehandelDatum(k1,2,5);
           
           weekplanning.setBehandelDatum(k2,4,5);
           weekplanning.setBehandelDatum(k2,4,6);
           weekplanning.setBehandelDatum(k2,4,7);
           
           weekplanning.setBehandelDatum(k3,0,1);
           weekplanning.setBehandelDatum(k3,0,2);
           weekplanning.setBehandelDatum(k3,0,4);
           
           weekplanning.setBehandelDatum(k4,1,0);
           weekplanning.setBehandelDatum(k4,1,1);
           weekplanning.setBehandelDatum(k4,1,2);
           
           weekplanning.setBehandelDatum(k5,1,4);
           weekplanning.setBehandelDatum(k5,1,5);
           weekplanning.setBehandelDatum(k5,1,6);
           
           weekplanning.setBehandelDatum(k8,0,3);
           weekplanning.setBehandelDatum(k8,4,3);
           weekplanning.setBehandelDatum(k8,4,4);
           
           bedrijf.addWeekplanning(weekplanning);
           m1.addWeekPlanning(weekplanning, 0);
           m2.addWeekPlanning(weekplanning, 0);
           
           for(int i = 0; i < 50; i++)
           {
            bedrijf.setParkeerPlek(i, new ParkeerPlek());
           }
           //weekplanning 0 staan klussen in, de rest is ongevuld
           for(int i = 1; i < 54; i ++)
           {
               WeekPlanning wp = new WeekPlanning(i);
               m1.addWeekPlanning(wp, i);
               m2.addWeekPlanning(wp, i);
               bedrijf.addWeekplanning(wp);
           }
           
           getServletContext().setAttribute("bedrijf", bedrijf);
           System.out.println("database is geinitialliseerd");
           
           //hier schrijf ik bedrijf uit naar bedrijf.obj
           bedrijf.schrijfBedrijfWeg();
           
           response.sendRedirect("Beginscherm.jsp");
        %>
    </head>
    <body>
        <h1>Database is gevuld</h1>
        <h2>I'm afraid i can't  let you continue</h2>
    </body>
</html>
