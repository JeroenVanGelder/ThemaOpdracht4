/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import nl.hu.to4.groep1.domain.Auto;
import nl.hu.to4.groep1.domain.Klus;
import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.domain.Klant;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeroen
 */
@WebServlet("/WeekPlanningWijzigServlet")
public class WeekPlanningWijzigServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    public WeekPlanningWijzigServlet() {
        super();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String act = request.getParameter("button");
        String returnAdress = "weekPlanning.jsp";
        RequestDispatcher rd = null;
        if (act == null) {}
        
        else if (act.contains("klant")) 
        {
            Bedrijf bedrijf = (Bedrijf)getServletContext().getAttribute("bedrijf");
            ArrayList<Klant> klantRegister = bedrijf.getKlantenRegister();
            String klant = request.getParameter("klantNaamSelect");
            Klant sorteerKlant;
            for(Klant k : klantRegister)
            {
                if(k.getNaam().equals(klant))
                {
                    sorteerKlant = k;
                    getServletContext().setAttribute("sorteerKlant", sorteerKlant);
                    System.out.println("sorteerKlant : " + sorteerKlant.getNaam());
                }
            }
            
            returnAdress = "weekPlanningWijzigScherm.jsp";
        }
        
        else if(act.contains("auto"))
        {
            Bedrijf bedrijf = (Bedrijf)getServletContext().getAttribute("bedrijf");
            ArrayList<Klant> klantRegister = bedrijf.getKlantenRegister();
            ArrayList<Auto> alleAutos = new ArrayList<Auto>();
            String auto = request.getParameter("autoKentekenSelect");
            for(Klant k : klantRegister)
            {
                alleAutos.addAll(k.getAutoLijst());
                
            }
            for(Auto a : alleAutos)
            {
                if(a.getKenteken().equals(auto))
                {
                    getServletContext().setAttribute("sorteerAuto", a);
                }
            }
            returnAdress = "weekPlanningWijzigScherm.jsp";
        }
        
        else if(act.contains("opslaan"))
        {
            // waarden checken 
            if(request.getParameter("omschrijving") != null)
            {
                if(getServletContext().getAttribute("sorteerAuto") != null)
                {
                    // waarde ophalen
                    String beschrijvingOpslaan = request.getParameter("omschrijving");
                    Auto deAuto = (Auto)getServletContext().getAttribute("sorteerAuto");
                    
                    // nieuwe klus aanmaken
                    Klus k = new Klus(beschrijvingOpslaan);
                    //Er moet nog een monteur toe worden gewezen
                    k.setAuto(deAuto);
                    // klus inplannen
                    Bedrijf bedrijf = (Bedrijf)getServletContext().getAttribute("bedrijf");
                    if(getServletContext().getAttribute("weekPlanningNummer") != null)
                    {
                        int i = (int)getServletContext().getAttribute("weekPlanningNummer");
                        String inplanDatum = (String)getServletContext().getAttribute("inplanDatum");
                        
                        bedrijf.getWeek(i).setBehandelDatum(k, Integer.parseInt("" + inplanDatum.charAt(9)), Integer.parseInt("" + inplanDatum.charAt(10)));
                        
                    }
                    // naar bedrijf in de servlet uploaden
                    bedrijf.schrijfBedrijfWeg();
                }
                    
                else
                {
                    System.out.println("foute auto");
                }
            }
            
            else
            {
                System.out.println("foute omschrijving");
            }
        }
        //en vervolgens wordt de gebruiker terug gestuurd naar de weekplanning met de vernieuwde gegevens.
        rd = request.getRequestDispatcher(returnAdress);
        rd.forward(request, response);
    }
}
