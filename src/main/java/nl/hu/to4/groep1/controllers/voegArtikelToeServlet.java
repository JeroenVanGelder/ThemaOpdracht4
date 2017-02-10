package nl.hu.to4.groep1.controllers;
import nl.hu.to4.groep1.domain.*;

import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import static java.util.Collections.list;
/**
 *
 * @author Rami
 */
@WebServlet("/voegArtikelToeServlet")
public class voegArtikelToeServlet extends HttpServlet {
    public voegArtikelToeServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException , ConcurrentModificationException{
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("register.jsp");
        String naam = request.getParameter("naam");
         double prijs = Double.parseDouble(request.getParameter("prijs"));
        double minVoorraad = Double.parseDouble(request.getParameter("minVoorraad"));
         String beschrijving = request.getParameter("beschrijving");
          String functie = request.getParameter("select");
          
         
        boolean b = false;

        if (functie.equals("Onderdeel")) {

                    Onderdeel O = new Onderdeel (naam,prijs,beschrijving,minVoorraad);
                    Object obj = getServletContext().getAttribute("bedrijf");
                    Bedrijf bedrijf = (Bedrijf)obj ;
                    
                
                    
                     
                    
                    if (obj != null) 
                    {
                        for(Artikel A : bedrijf.getArtikelen())  
                        {                                

                                rd = request.getRequestDispatcher("voegArtikelToe.jsp");
                                rd.forward(request, response);
                                b = true;
                            
                        }
                        
                        if(!b) 
                        {

                            bedrijf.addArtikel(O);
                            getServletContext().setAttribute("bedrijf", bedrijf);
                            bedrijf.schrijfBedrijfWeg();
                            
                      
                            
                            rd = request.getRequestDispatcher("HoofdScherm.jsp");
                            rd.forward(request, response);
                        }         
                    }
                    else 
                    {
                        System.out.println("Comleet mislukt");
                    }
        }

                 if (functie.equals("Brandstof")) {

                    Brandstof bs = new Brandstof (naam,minVoorraad);
                    Object obj = getServletContext().getAttribute("bedrijf");
                    Bedrijf bedrijf = (Bedrijf)obj ;
                    
                
                    
                     
                    
                    if (obj != null) 
                    {
                        for(Artikel A : bedrijf.getArtikelen())  
                        {                                

                                rd = request.getRequestDispatcher("voegArtikelToe.jsp");
                                rd.forward(request, response);
                                b = true;
                            
                        }
                        
                        if(!b) 
                        {

                            bedrijf.addArtikel(bs);
                            System.out.print(bedrijf.getArtikelen());
                            getServletContext().setAttribute("bedrijf", bedrijf);
                            bedrijf.schrijfBedrijfWeg();
                            
                      
                            
                            rd = request.getRequestDispatcher("HoofdScherm.jsp");
                            rd.forward(request, response);
                        }         
                    }
                    else 
                    {
                        System.out.println("Comleet mislukt");
                    }
        } 
}
}
           
    





