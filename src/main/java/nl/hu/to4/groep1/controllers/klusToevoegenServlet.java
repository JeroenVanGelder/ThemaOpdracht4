/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import nl.hu.to4.groep1.services.BedrijfService;
import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.domain.Klus;
import nl.hu.to4.groep1.domain.WeekPlanning;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep1.domain.Auto;
import nl.hu.to4.groep1.domain.Klant;

/**
 *
 * @author Jeroen
 */
@WebServlet("/klusToevoegenServlet")
public class klusToevoegenServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

//    @Inject
//    BedrijfService bedrijfService;
    
    public klusToevoegenServlet() {
        super();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String returnAdress = "klusToevoegen.jsp";
        RequestDispatcher rd = null;
        String act = request.getParameter("button");
        System.out.println("De servlet begint");
        Bedrijf b = (Bedrijf)getServletContext().getAttribute("bedrijf");
        
        if(act.equals("nieuweKlus"))
        {
            System.out.println("de nieuwe klus button is ingecheckt");
            String klant = request.getParameter("klantenSelect");
            String autoKenteken = request.getParameter("autoSelect");
            String omschrijving = request.getParameter("omschrijving");
            System.out.println("de volgende waarde zijn opgeslagen : " + klant + " | " + autoKenteken + " | " + omschrijving + " |");
            
            Auto auto = b.vindAuto(autoKenteken);
            System.out.println("de auto " + auto.getKenteken() + " bestaat");
            
            if(b.vindEigenaar(auto).getNaam().equals(klant))
            {
                System.out.println("De auto is van " + klant);
                Klant klant1 = b.vindKlant(klant, auto);
                Klus k = new Klus(omschrijving, auto, klant1);
                System.out.println("De Klus is aangemaakt");
                returnAdress = "weekPlanningJSTL.jsp";
                request.setAttribute("klus", k);
                
            }
        }
        
        else if(act.equals("klusInplannen") && request.getAttribute("klus") != null)
        {
            int weekNummer = Integer.parseInt(request.getParameter("weekSelect"));
            int dag = Integer.parseInt(request.getParameter("dagSelect"));
            Klus k = (Klus)request.getAttribute("klus");
            int aantalUur = Integer.parseInt(request.getParameter("uurSelect"));
            String boodschap = "niet gelukt";
            
            if(k != null)
            {
                if(b.klusInplannen(k, weekNummer, dag, aantalUur) == true)
                {
                    returnAdress = "weekPlanningJSTL.jsp";
                    boodschap = "gelukt";
                }
            }
            
            else
            {
                boodschap = "er moet eerst een klus aan worden gemaakt";
            }
            
            request.setAttribute("boodschap", boodschap);
        }
        
        rd = request.getRequestDispatcher(returnAdress);
        rd.forward(request, response);
    }
}
