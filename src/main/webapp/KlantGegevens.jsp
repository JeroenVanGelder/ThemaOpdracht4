<%-- 
    Document   : KlantGegevens
    Created on : 19-jun-2015, 11:59:38
    Author     : Rami
--%>
<%@page import="nl.hu.to4.groep1.domain.Bedrijf"%>
<%@page import="nl.hu.to4.groep1.domain.Klant"%>
<link rel="stylesheet" type="text/css" href="HeaderJSTLCss.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
 <c:if test="${ingelogdeUser.functie == 'Eigenaar' || 'Monteur' ||'ParkeerMedewerker' }" > 
          <div id = "scherm">
         <h1>
             <div class="CSSTableGenerator" >
                <table >
                Vul hier de gegevens van uw nieuwe medewerker in<br>
                <br>
                  <tr>
                        <td >
                             Voornaam:
                        </td>
                        <td>
                              <input class = "ltf" type = "text" name = "naam"  placeholder="RealName" /><br />
                        </td>
                    </tr>
                    <tr>
                        <td >
                           Straatnaam:
                        </td>
                        <td>
                           <input type="text" name="straatnaam" placeholder="straatnaam">
                        </td>                    
                    </tr>
                    <tr>
                        <td >
                           Huisnummer:
                        </td>
                        <td>
                          <input type="text" name="huisnummer" placeholder="huisnummer" ><br>               
                        </td>                     
                    </tr>
                    <tr>
                        <td >
                            Woonplaats:
                        </td>
                        <td>
                             <input type="text" name="Woonplaats" placeholder="Woonplaats"><br>                       
                        </td>                      
                    </tr                 
                     <tr>
                        <td >
                           postcode :
                        </td>
                        <td>
                         <input type="text" name="postcode" placeholder="postcode"><br>
                        </td>                       
                    </tr>
                     <tr>
                        <td >
                          email :
                        </td>
                        <td>
                           <input type="text" name="email" placeholder="email"><br>
                        </td>                      
                    </tr>
                       <tr>
                        <td >
                        Bevesteging:
                        </td>
                        <td>
                                      <input type="text" name="email2" placeholder="emailCheck"><br>
                        </td>                      
                    </tr>
                     <tr>
                        <td >
                             Uurloon:
                        </td>
                        <td>
                             <input type = "text " name = "uurloon"  placeholder="uurloon"/><br>
                        </td>                     
                    </tr>
                    <tr>
                        <td >
                           Gebruikernaam:
                        </td>
                        <td>
                               <input type = "text" name = "inlognaam"  placeholder="gebruikersnaam"/><br>
                        </td>   
                    </tr>
                    <tr>
                        <td >
                           Wachtwoord:
                        </td>
                        <td>
                           <input type = "text" name = "wachtwoord"  placeholder="wachtwoord"/><br>
                        </td>  
                    </tr>
            </c:if>
                    <c:if test="${ingelogdeUser.functie == 'Klant' } ">
                             <tr>
                        <td >
                             Gebruikersnaam :
                        </td>
                        <td>
                          <input class = "ltf" type = "text" name = "gebruikersnaam" placeholder="gebruikersnaam" />
                        </td>
                       
                    </tr>
                    <tr>
                        <td >
                           Wachtwoord :
                        </td>
                        <td>
                           <input class = "ltf" type = "text" name = "Password"  placeholder="Password" /><br />
                        </td>
                     
                    </tr>
                    <tr>
                        <td >
                           Bevesteging: : 
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "Password2"  placeholder="Password2" /><br />
                        </td>
                      
                    </tr>
                    <tr>
                        <td >
                            Realname :
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "RealName"  placeholder="RealName" /><br />
                        </td>
                       
                    </tr>
                     <tr>
                        <td >
                            StraatNaam : 
                        </td>
                        <td>
                             <input class = "ltf" type = "text" name = "straatnaam"  placeholder="straatnaam" /><br />
                        </td>
                       
                    </tr>
                     <tr>
                        <td >
                            Huisnummer :
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "huisnummer"  placeholder="huisnummer" /><br />
                        </td>
                       
                    </tr>
                     <tr>
                        <td >
                             woonplaats :
                        </td>
                        <td>
                           <input class = "ltf" type = "text" name = "Woonplaats"  placeholder="Woonplaats" /><br />
                        </td>
                       
                    </tr>
                     <tr>
                        <td >
                           postcode :
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "postcode"  placeholder="postcode" /><br />
                        </td>
                       
                    </tr>
                     <tr>
                        <td >
                          email :
                        </td>
                        <td>
                           <input class = "ltf" type = "text" name = "email" placeholder="email" />
                        </td>
                       
                    </tr>
                       <tr>
                        <td >
                        Bevesteging:
                        </td>
                        <td>
                          <input class = "ltf" type = "text" name = "email2" fill="Bevesteging:" />
                        </td>
                       
                    </tr>
                    </c:if>
</html>
