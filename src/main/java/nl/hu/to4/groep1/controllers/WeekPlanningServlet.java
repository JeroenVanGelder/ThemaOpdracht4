/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.domain.Klus;
import nl.hu.to4.groep1.domain.WeekPlanning;
import java.io.IOException;
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
@WebServlet("/WeekPlanningServlet")
public class WeekPlanningServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    public WeekPlanningServlet() {
        super();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String act = request.getParameter("button");
        String returnAdress = "weekPlanning.jsp";
        RequestDispatcher rd = null;
        if (act == null) {}
        
        else if (act.contains("kies")) 
        {
            //eerst wordt het weeknummer uit de request gehaald.
            
            String weekNummerSelect = request.getParameter("weekNummerSelect");
            int weekNummer = Integer.parseInt(weekNummerSelect);
            //als dit antwoord niet null is wordt er pas iets gedaan
            if(weekNummerSelect != null)
            {
                //het bedrijf wordt dan uit de servletcontext gehaald
                Object obj = getServletContext().getAttribute("bedrijf");
                if(obj instanceof Bedrijf)
                {
                    //hier wordt de weekplanning van het bedrijf adhv de weeknummer naar de request gestuurd
                    Bedrijf b = (Bedrijf)obj;
                    request.setAttribute("weekPlanning", b.getWeek(weekNummer));
                    getServletContext().setAttribute("weekPlanningNummer", weekNummer);
                }
            }
        }
        
        if(act.contains("geplanned"))
        {
            // alle nodig waarde worden gedeclareerd
            
            
            Klus k = new Klus("");
            WeekPlanning wP;
            Bedrijf b;
            
            String weekNummerSelect = request.getParameter("weekNummerSelect");
            int weekNummer = 0;
            
            //het de weekplanning word opgehaald
            Object obj = getServletContext().getAttribute("bedrijf");
            if(obj instanceof Bedrijf)
            {
                //hier wordt de weekplanning van het bedrijf adhv de weeknummer naar de request gestuurd
                b = (Bedrijf)obj;
                wP = b.getWeek(weekNummer);

                //de bijhorende klus vinden op basis van de waarde van de knop
                int i = Integer.parseInt("" + act.charAt(9));
                int y = Integer.parseInt("" + act.charAt(10));
                if(wP.getKlussen()[i][y] != null)
                {
                    k = wP.getKlussen()[i][y];
                }
            }

            //de klus uploaden naar de "cloud"
            if(k != null)
            {
                //getServletContext().setAttribute("teBekijkenKlus", k);
                request.setAttribute("overzichtKlus", k);
                returnAdress = "klusOverzichtScherm.jsp";
            }
        }
        
        if(act.contains("inplannen"))
        {
            getServletContext().setAttribute("inplanDatum", act);
            returnAdress= "weekPlanningWijzigScherm.jsp";            
        }
        //en vervolgens wordt de gebruiker terug gestuurd naar de weekplanning met de vernieuwde gegevens.
        rd = request.getRequestDispatcher(returnAdress);
        rd.forward(request, response);
    }
}
