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

/**
 *
 * @author Jeroen
 */
@WebServlet("/WeekPlanningServletJSTL")
public class WeekPlanningServletJSTL extends HttpServlet {
private static final long serialVersionUID = 1L;

//    @Inject
//    BedrijfService bedrijfService;
    
    public WeekPlanningServletJSTL() {
        super();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String act = request.getParameter("button");
        String returnAdress = "weekPlanningJSTL.jsp";
        RequestDispatcher rd = null;
        if (act == null) {}
        
        else if (act.contains("kies")) 
        {
            String weekNummerSelect = request.getParameter("weekNummerSelect");

            if(weekNummerSelect != null)
            { 
                int weekNummer = Integer.parseInt(weekNummerSelect);
                Object obj = getServletContext().getAttribute("bedrijf");
                if(obj instanceof Bedrijf)
                {
                    Bedrijf b = (Bedrijf)obj;
                    request.setAttribute("weekNummer", weekNummer);
                    request.setAttribute("weekPlanning", b.getWeek(weekNummer));
                }
            }
        }
        
        else if(act.contains("geplanned"))
        {
            Object obj = getServletContext().getAttribute("bedrijf");
            
            if(obj instanceof Bedrijf)
            {
                String weekString = request.getParameter("weekNummerHidden");
                int week = Integer.parseInt("" + weekString);
                int dag = Integer.parseInt("" + act.charAt(9));
                int uur = Integer.parseInt("" + act.charAt(10));
                Bedrijf b = (Bedrijf)obj;
                request.setAttribute("overzichtKlus", b.getKlus(week, dag, uur));
                returnAdress = "klusOverzichtScherm.jsp";
            }
            
        }
        
        else if(act.contains("inplannen"))
        {
            getServletContext().setAttribute("inplanDatum", act);
            request.setAttribute("inplanDatum", act);
            returnAdress= "weekPlanningWijzigScherm.jsp";            
        }

        rd = request.getRequestDispatcher(returnAdress);
        rd.forward(request, response);
    }
}
