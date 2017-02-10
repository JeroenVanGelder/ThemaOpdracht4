/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hu.to4.groep1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep1.domain.Artikel;
import nl.hu.to4.groep1.domain.Bedrijf;
import nl.hu.to4.groep1.domain.Onderdeel;

/**
 *
 * @author Rami
 */
@WebServlet(name = "voorraadServlet", urlPatterns = {"/voorraadServlet"})
public class voorraadServlet extends HttpServlet {

    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
              RequestDispatcher rd = null;
             Object obj = getServletContext().getAttribute("bedrijf");
             Bedrijf bedrijf = (Bedrijf)obj ;
             System.out.print("komt die wel");
              Onderdeel schroef = new Onderdeel("schroef", 1.50, "een hele dure schroef." , 10.0);
              bedrijf.addArtikel(schroef);
              System.out.print(bedrijf.getArtikelen());
              
              
            for(Artikel  A  : bedrijf.getArtikelen()){
              
                request.getSession().setAttribute("ArtikelenLijst", A);
            }
     
             
        
        
        
        
            rd = request.getRequestDispatcher("voegArtikelToeServlet.jsp");
          rd.forward(request,response);
     
    }

}
