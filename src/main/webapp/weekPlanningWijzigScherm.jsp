<%-- 
    Document   : weekPlanningWijzigScherm
    Created on : May 20, 2015, 5:14:39 PM
    Author     : Jeroen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="nl.hu.to4.groep1.domain.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="HeaderJSTL.jsp">
        <jsp:param name="title" value="het klus toevoegen"/>
    </jsp:include>
        
        <%
            //Eerst haal ik het bedrijf op
            Bedrijf bedrijf = (Bedrijf)getServletContext().getAttribute("bedrijf");
        %> 
        
        <div id ="weekNummerSelect">
            <%
                    //hier vul ik de OPTION met opties vanuit de voorbeeld database
                    ArrayList<Klant> KlantRegister = bedrijf.getKlantenRegister();
                    Klant sorteerKlant = (Klant)getServletContext().getAttribute("sorteerKlant");
                    ArrayList<Auto> autoLijst = new ArrayList<Auto>();
                    ArrayList<Monteur> monteurLijst;
                    if(sorteerKlant != null)
                    {   
                        for(Klant k: KlantRegister)
                        {
                            if(k.equals(sorteerKlant))
                            {
                                autoLijst.addAll(k.getAutoLijst());
                            }
                        }
                    }
            %>
            <FORM action ="WeekPlanningWijzigServlet" method ="post">
                
                <SELECT NAME = "klantNaamSelect" TYPE = "submit">
                <%
                    if(sorteerKlant != null)
                    {
                        out.println("<OPTION VALUE = \"x\"> " + sorteerKlant.getNaam() + " </OPTION>");
                    }
                    
                    for(Klant k: KlantRegister)
                    {
                        
                        String x = k.getNaam();
                        out.println("<OPTION VALUE = " + x + "> " + x + " </OPTION>");
                    }
                %>
                </SELECT>
                <input type ="submit" name="button" value ="klant">
                
                <SELECT NAME = "autoKentekenSelect" TYPE = "submit">
                <%
                    if(sorteerKlant != null)
                    {
                        for(Auto a: autoLijst)
                        {
                            String x = a.getKenteken();
                            out.println("<OPTION VALUE = " + x + "> " + x + " </OPTION>");
                        }
                    }
                %>
                </SELECT>
                
                <input type ="submit" name="button" value ="auto">
                
                <SELECT>
                    <OPTION value ="Jan">Jan</option>
                    <option value ="Peter">Peter</option>
                </SELECT></br>
                
                <input type="text" name ="omschrijving" value ="omschrijving">
                
                <input type ="submit" name="button" value ="opslaan">

            </FORM>
        </div>
    </body>
</html>
