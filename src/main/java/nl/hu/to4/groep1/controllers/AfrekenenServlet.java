
package nl.hu.to4.groep1.controllers;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hu.to4.groep1.domain.*;

@WebServlet(name = "AfrekenenServlet", urlPatterns = {"/AfrekenenServlet"})
public class AfrekenenServlet extends HttpServlet {
    private Calendar cal;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
          
        Bedrijf b = new Bedrijf(); 

        
        
    }
}
