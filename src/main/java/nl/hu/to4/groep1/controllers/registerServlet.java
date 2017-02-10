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
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    public registerServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException , ConcurrentModificationException{
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("register.jsp");
        String gebruikersnaam = request.getParameter("gebruikersnaam");
        String password = request.getParameter("Password");
        String password2 = request.getParameter("Password2");
        String realname = request.getParameter("RealName");
        String StraatNaam = request.getParameter("straatnaam");
        int Huisnummer = Integer.parseInt(request.getParameter("huisnummer"));

        String woonplaats =  request.getParameter("Woonplaats");
        String postcode = request.getParameter("postcode");
        String email = request.getParameter("email");
        String email2 = request.getParameter("email2");
        String functie = ("klant");
        boolean b = false;


        Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
        response.addCookie(cookie);

        if (functie.equals("klant")) {
           
                 
            if (password.equals(password2) && email.equals(email2)) {
                   
                if (gebruikersnaam != null && realname != null && password != null && email != null && StraatNaam != null && Huisnummer >=0 && woonplaats != null && postcode != null) {

                    Klant K = new Klant (realname , StraatNaam , Huisnummer , woonplaats , postcode , gebruikersnaam , password);
                    Object obj = getServletContext().getAttribute("bedrijf");
                    Bedrijf bedrijf = (Bedrijf)obj ;
                    
                    Klant r = new Klant ("q","q",1,"q","q","q","q");
                    
                     
                    
                    if (obj != null) 
                    {
                        for(Klant k : bedrijf.getKlantenRegister())  
                        {                                
                            System.out.println(password2 + password);
                            
                            if (k.userBestaat(K)) 
                            {
                                System.out.println("Klant Bestaat al");
                                rd = request.getRequestDispatcher("register.jsp");
                                rd.forward(request, response);
                                b = true;
                            }
                        }
                        
                        if(!b) 
                        {

                            bedrijf.voegKlantToe(K);
                            getServletContext().setAttribute("bedrijf", bedrijf);
                            bedrijf.schrijfBedrijfWeg();
                            
                            System.out.print("toegevoegde klant" + bedrijf.getKlantenRegister().get(bedrijf.getKlantenRegister().size()-1).getNaam());
                            
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
                    rd = request.getRequestDispatcher("register.jsp");
                    System.out.print( "een textfield is nog leeg");
                    rd.forward(request, response);
                }
            }
        } 
        else
        {
            rd = request.getRequestDispatcher("register.jsp");
            System.out.print( "wachtwoord / email komt niet overeen");
            rd.forward(request, response);

        }
           
    }
}




