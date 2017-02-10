/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet("/klusOverzichtSchermServlet")
public class klusOverzichtSchermServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    public klusOverzichtSchermServlet() {
        super();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String act = request.getParameter("button");
        String returnAdress = "klusOverzichtScherm.jsp";
        RequestDispatcher rd = null;
        if (act == null) {}
        
        else if (act.contains("terug")) 
        {
            returnAdress = "weekPlanningJSTL.jsp";
        }

        
        //en vervolgens wordt de gebruiker terug gestuurd naar de weekplanning met de vernieuwde gegevens.
        rd = request.getRequestDispatcher(returnAdress);
        rd.forward(request, response);
    }
}

