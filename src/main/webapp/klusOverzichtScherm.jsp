<%-- 
    Document   : klusOverzichtScherm
    Created on : May 11, 2015, 10:35:49 AM
    Author     : Jeroen
--%>

<%@page import="nl.hu.to4.groep1.domain.Klus"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="HeaderJSTL.jsp">
        <jsp:param name="title" value="Het klus overzicht scherm"/>
    </jsp:include>
        <h1></h1>
        <form action ="klusOverzichtSchermServlet" method = "post">
            <button name = "button" value = "terug">Weekplanning</button>
        </form>
        <div id = "klusOverzicht">
            <%
            Object obj = request.getAttribute("overzichtKlus");
            String omschrijving = "";
            String kenteken = "";
            String monteur = "";
            // eerst check ik of de opgevraagde weekplanning een weekplanning is.
            if (obj != null && obj instanceof Klus)
            {
                Klus k = (Klus)obj;
                omschrijving = k.getBeschrijving();
                System.out.println(omschrijving);
                if(k.getAuto() != null)
                {
                    kenteken = k.getAuto().getKenteken();
                }
                if(k.getMonteur()!= null)
                {
                    monteur = k.getMonteur().getNaam();
                }
            }
            
            %>
            
            <label>Kenteken : </label><input class = "ltf" type = "text" name = "omschrijving" value = <%=kenteken%>><br />
            <label>Monteur : </label><input class = "ltf" type = "text" name = "omschrijving" value = <%=monteur%>><br />
            <label>Omschrijving : </label><input class = "ltf" type = "text" name = "omschrijving" value = <%=omschrijving%>><br />
            
        </div>
    </body>
</html>
