package nl.hu.to4.groep1.controllers;

import nl.hu.to4.groep1.domain.*;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author Rami
*/

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet
{
    private Bedrijf hetBedrijf;
    public loginServlet(){
        super();
    }

    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        RequestDispatcher rd = null;
        String msg2 = null;
        String gebruikersnaam = request.getParameter("gebruikersnaam");
        String password = request.getParameter("wachtwoord");
        String functie = request.getParameter("select");
        String returnAdres = ("inlogScherm.jsp");
        
       
        if (functie.equals("Klant"))
        {
            Object obj = getServletContext().getAttribute("bedrijf");
            Bedrijf bedrijf = (Bedrijf)obj ;
            
            if (obj != null)
            {
                System.out.println(functie + "if");
               
                if (gebruikersnaam != null && !gebruikersnaam.equals("") && password != null && !password.equals("")) {
                    System.out.println(functie + " ww check , email check");
                    System.out.println("Gebruiker : " + gebruikersnaam);
                    
                    for(Klant k: bedrijf.getKlantenRegister()) 
                    {
                        System.out.println("k naam : " + k.getNaam());
                        
                        if (k.naamCheck(gebruikersnaam)) 
                        {
                            System.out.println("Gelijke gebruikersnaam | " + k.getNaam() + " | " +  gebruikersnaam);
                            if (k.login(password)) 
                            {
                                System.out.println("Ingelogd == true");
//                                Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
//                                response.addCookie(cookie);
                                
                                request.getSession().setAttribute("ingelogdeUser", k);

                                returnAdres = "Hoofdscherm.jsp";
                            } 
                        } 
                    }
                }           
            }
            
            else
            {
                System.out.println("alles fout");
            }
                
            


            request.setAttribute("msg2", msg2);


        }
        
        else if (functie.equals("Werknemer"))
        {
            Object obj = getServletContext().getAttribute("bedrijf");
            Bedrijf bedrijf = (Bedrijf)obj ;
            
            if (obj != null)
            {
                System.out.println(functie + "if");
               
                if (gebruikersnaam != null && !gebruikersnaam.equals("") && password != null && !password.equals("")) {
                    System.out.println(functie + " ww check , email check");
                    System.out.println("Gebruiker : " + gebruikersnaam);
                    
                    for(Werknemer w: bedrijf.getAlleWerknemers())
                    {
                        System.out.println("k naam : " + w.getNaam());
                        
                        if (w.naamCheck(gebruikersnaam)) 
                        {
                            System.out.println("Gelijke gebruikersnaam | " + w.getNaam() + " | " +  gebruikersnaam);
                            if (w.checkWachtwoord(password))
                            {
                                System.out.println("Ingelogd == true");
//                                Cookie cookie = new Cookie("gebruikersnaam", gebruikersnaam);
//                                response.addCookie(cookie);
                                
                                request.getSession().setAttribute("ingelogdeUser", w);

                                returnAdres = "Hoofdscherm.jsp";
                            } 
                        } 
                        else
                    {
                            System.out.println("w.naamCheck gebruikersnaam");
                            }
                    }
                    
                }           
            }
            
            else
            {
                System.out.println("alles fout");
            }
                
            


            request.setAttribute("msg2", msg2);


        }

        
      
        else{
             System.out.println("Functie klopt niet");
            
            returnAdres = "loginScherm.jsp";
        }


        rd = request.getRequestDispatcher(returnAdres);
        rd.forward(request,response);
    }
}
