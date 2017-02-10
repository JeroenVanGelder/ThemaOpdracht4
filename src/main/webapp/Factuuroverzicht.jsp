
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="FactuuroverzichtCSS.css" rel="stylesheet" type="text.css">
        <title>JSP Page</title>
    </head>
        <div id="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div> 
    <body>
        <div id="hoofdschermdiv">
            <div id="tablediv">
            <table>
                <tr>
                    <td>
                        Klant
                    </td>
                    <td >
                        Klusbeschrijving
                    </td>
                    <td>
                        Totaalprijs
                    </td>
                    <td>
                        
                    </td>
                </tr>
            <c:forEach var="factuur" items="${bedrijf.alleKlantFacturen}">
                <c:if test="${factuur.klant == ingelogdeUser}">
                <tr>
                    <td>
                        ${factuur.klant.naam}
                    </td>
                    <td>
                        ${factuur.klus.beschrijving}
                    </td>
                    <td>
                        ${bedrijf.getFactuurKosten(factuur)}
                    </td>
                    <td>
                        <button id="divknoppen" type="button" onclick="location.href='Afrekenen.jsp'">Factuur Afrekenen</button>
                    </td>
                </tr>
                </c:if> 
            </c:forEach> 
            </table>
            </div>        
    </div>        
    </body>
</html>
