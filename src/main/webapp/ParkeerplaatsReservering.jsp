<%-- 
    Document   : ParkeerplaatsReservering
    Created on : 1-jun-2015, 13:08:08
    Author     : Nederlandhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe Reservering</title>
         <link href="HoofdschermCSS.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div>
        <div class="hoofdschermdiv">
            <div class="hoofdschermdivcontent">
            U heeft gekozen voor datum: <c:out value="${requestScope.date}" />.
        
        <label>Op deze dag zijn er nog <c:out value="${vrijePlekken}" /> beschikbaar.
                    Wilt u een plek reserveren of teruggaan naar de vorige pagina?</label>
        <div id ="buttons">
            <form action="ParkeerReserveringServlet" method="post">
                <div class="selectBox">
                    <h1>Alle Klanten</h1>
                    <select name="klantenSelect">
                        <c:if test="${klus != null}"><option>${klus.klant.naam}</option></c:if>
                        <c:forEach var="klant" items="${bedrijf.klantenRegister}">
                            <option value= "${klant.naam}">${klant.naam}</option>
                        </c:forEach>
                    </select>
                </div>
                <br><button name="button" value="Reserveer">Reserveer een plek</button>
            </form>
        </div>
            </div>
                        <div class="knoppenmenu">
            <form action="Parkeerplaats.jsp" method="post">
                <button name="button" value="terug" class="divknoppen">Terug</button>
            </form>
        </div>
        </div>
    </body>
</html>
