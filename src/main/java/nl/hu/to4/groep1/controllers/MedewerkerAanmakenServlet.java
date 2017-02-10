package nl.hu.to4.groep1.controllers;

import nl.hu.to4.groep1.domain.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;



/**
 * Created by Rami on 21-5-2015.
 */

@WebServlet("/MedewerkerAanmakenServlet")
public class MedewerkerAanmakenServlet extends HttpServlet {
    public MedewerkerAanmakenServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ConcurrentModificationException {
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("MedewerkerAanmaken.jsp");
        String msg2 = null;
        String gebruikersnaam = request.getParameter("inlognaam");
        String password = request.getParameter("wachtwoord");
        String password2 = request.getParameter("wachtwoordCheck");
        String realname = request.getParameter("naam");
        String StraatNaam = request.getParameter("straatnaam");
        int Huisnummer = Integer.parseInt(request.getParameter("huisnummer"));
        String woonplaats =  request.getParameter("Woonplaats");
        String postcode = request.getParameter("postcode");
        String email = request.getParameter("email");
        String email2 = request.getParameter("email2");
        String functie = request.getParameter("select");
        double uurloon = Double.parseDouble(request.getParameter("uurloon"));
        boolean b = false;

            if (functie.equals("Parkeermedewerker")) {
           
                 
            if (password.equals(password2) && email.equals(email2)) {
                   
                if (gebruikersnaam != null && realname != null && password != null && email != null && StraatNaam != null && Huisnummer >=0 && woonplaats != null && postcode != null) {

                   ParkeerMedewerker pm = new ParkeerMedewerker (realname , StraatNaam , Huisnummer , woonplaats , postcode , email ,functie , uurloon,gebruikersnaam , password);  
                    Object obj = getServletContext().getAttribute("bedrijf");
                    Bedrijf bedrijf = (Bedrijf)obj ;
                    
                   ParkeerMedewerker r = new ParkeerMedewerker ("q","q",1,"q","q","q","Parkeermedewerker",1,"q","q");
                    
                     
                    
                    if (obj != null) 
                    {
                        for (Werknemer W : bedrijf.getWerknemersRegister()) 
                        {                                
                            System.out.println(password2 + password);
                            
                            if (W.werknemerBestaat(pm)) 
                            {
                                System.out.println("Klant Bestaat al");
                                rd = request.getRequestDispatcher("register.jsp");
                                rd.forward(request, response);
                                b = true;
                            }
                        }
                        
                        if(!b) 
                        {

                            bedrijf.voegWerknemerToe(pm);
                            getServletContext().setAttribute("bedrijf", bedrijf);
                            bedrijf.schrijfBedrijfWeg();
                            
                            System.out.print("toegevoegde klant" + bedrijf.getKlantenRegister().get(bedrijf.getKlantenRegister().size()-1).getNaam());
                            
                            rd = request.getRequestDispatcher("Hoofdscherm.jsp");
                            rd.forward(request, response);
                        }         
                    }
                    else 
                    {
                        System.out.println("Comleet mislukt");
                    }
                }
                    
                else  
                {
                    rd = request.getRequestDispatcher("register.jsp");
                    System.out.print( "een textfield is nog leeg");
                    rd.forward(request, response);
                }
            }
         
        else
        {
            rd = request.getRequestDispatcher("register.jsp");
            System.out.print( "wachtwoord / email komt niet overeen");
            rd.forward(request, response);

        }
     }
   
        
        
            else if(functie.equals("Monteur")) 
        {
                   
            if (password.equals(password2) && email.equals(email2)) 
            {
          
                if (gebruikersnaam != null && realname != null && password != null && functie != null && email != null && StraatNaam != null && Huisnummer >=0 && woonplaats != null && postcode != null) 
                {
                     
                    Monteur M = new Monteur (realname , StraatNaam , Huisnummer , woonplaats , postcode , email ,functie , uurloon,gebruikersnaam , password);
                    Object obj = getServletContext().getAttribute("bedrijf");
                    Bedrijf bedrijf = (Bedrijf)obj ;
                    
                    if (obj != null)
                    {
                        
                       for (Werknemer W : bedrijf.getWerknemersRegister()) 
                        {
                              System.out.println(password2 + password);
                             if (W.werknemerBestaat(M))
                                {
                                    b = true;
                                    rd = request.getRequestDispatcher("MedewerkerAanmaken.jsp");
                                }
                           } 
                     if( !b)
                     {
                        bedrijf.voegWerknemerToe(M);
                        getServletContext().setAttribute("bedrijf", bedrijf);
                        bedrijf.schrijfBedrijfWeg();
                        
                         System.out.print("toegevoegde werknemer" + bedrijf.getWerknemersRegister().get(bedrijf.getWerknemersRegister().size()-1).getNaam());
                        
                        rd = request.getRequestDispatcher("inlogScherm.jsp");
                        rd.forward(request, response);
                     }
                   } 
                    else 
                    {                 
                         System.out.println("Comleet mislukt");
                    }
                    
                   
              
                  
                }
                else
                {
                    rd = request.getRequestDispatcher("MedewerkerAanmaken.jsp");
                   System.out.print("is iets leeg");

                }
            }
            else 
            {
                rd = request.getRequestDispatcher("MedewerkerAanmaken.jsp");
                System.out.print( "wachtwoord / adress komt niet overeen");
            }
            rd.forward(request, response);
       } 
   }
}
