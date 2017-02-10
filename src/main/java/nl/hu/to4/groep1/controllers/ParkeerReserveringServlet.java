/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import nl.hu.to4.groep1.domain.Klant;

/**
 *
 * @author Nederlandhc
 */
@WebServlet(name = "ParkeerReserveringServlet", urlPatterns = {"/ParkeerReserveringServlet"})
public class ParkeerReserveringServlet extends HttpServlet {
    private String reservationDate;
    //ingelogde user = request.getSession.getAttribute("ingelogde user");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParkeerReserveringServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkeerReserveringServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println("ParkeerReserveringServlet: Begonnen aan doGet");
                RequestDispatcher rd;
                
                //reservationDate = request.getParameter("date");
                //System.out.println("ParkeerReserveringServlet: Reserverings datum gezet op: " + reservationDate);
                
        rd = request.getRequestDispatcher("ParkeerplaatsReservering.jsp");
        
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Reserveren begint");
        RequestDispatcher rd = null;
        
        Bedrijf b = (Bedrijf)getServletContext().getAttribute("bedrijf");
        
        if(request.getParameter("klantenSelect") != null){
            System.out.println("klantenSelect != null");
            String klant = request.getParameter("klantenSelect");
            String datum = (String) request.getSession().getAttribute("date");
            Klant k = b.vindKlant(klant);
            System.out.println("opgeslagen waarde : " + klant + " | " + k.getNaam() + " | " + datum);
            try {
                System.out.println("we gaan de try in");
                if(b.maakReservering(k , datum)){
                    System.out.println("Het maken van de reservering is gelukt");
                    rd = request.getRequestDispatcher("Hoofdscherm.jsp");
                    rd.forward(request, response);
                }
            } catch (ParseException ex) {
               System.out.println(ex);
            }
        }
        else{
            rd = request.getRequestDispatcher("ParkeerplaatsReservering.jsp");
                    rd.forward(request, response);
        }
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
