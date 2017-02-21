/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep1.domain.Bedrijf;

/**
 *
 * @author Nederlandhc
 */
@WebServlet(name = "ParkeerplaatsServlet", urlPatterns = {"/ParkeerplaatsServlet"})
public class ParkeerplaatsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        
        System.out.println("ParkeerplaatsServlet: Meegegeven waarde is: " + request.getParameter("date"));
        
        if(request.getParameter("date") != null){
            try {
                Bedrijf b = (Bedrijf) getServletContext().getAttribute("bedrijf");
                String date = request.getParameter("date");
                System.out.println("ParkeerplaatsServlet: datum = " + date);
                int vP = b.getAantalVrijeParkeerplaatsenOpDatum(date);
                System.out.println("ParkeerplaatsServlet: Vrije Plekken int: " + vP);
                
                request.setAttribute("vrijePlekken", b.getAantalVrijeParkeerplaatsenOpDatum(request.getParameter("date")));
                System.out.println("ParkeerplaatsServlet: vrijeplekken uit bedrijf gehaald: " + request.getAttribute("vrijePlekken"));
                request.getSession().setAttribute("date", request.getParameter("date"));
                rd = request.getRequestDispatcher("ParkeerplaatsReservering.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ParkeerplaatsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            rd = request.getRequestDispatcher("Parkeerplaats.jsp");
            rd.forward(request, response);
        }
        
        
        
    }
}
