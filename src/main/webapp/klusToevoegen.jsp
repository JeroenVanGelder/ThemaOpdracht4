<%-- 
    Document   : javaWeekPlanning
    Created on : Jun 15, 2015, 2:10:06 PM
    Author     : Jeroen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nl.hu.to4.groep1.domain.Bedrijf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="klusToevoegenCss.css" />
<!DOCTYPE html>
    <jsp:include page="HeaderJSTL.jsp">
        <jsp:param name="title" value="Klus inplannen"/>
    </jsp:include>
        <form action ="klusToevoegenServlet" method ="post">
            <div class="klusAanmaakSelect">
                <h1>Klus gegevens</h1>
                <div class="selectBox">
                    <h1>Alle Klanten</h1>
                    <select name="klantenSelect">
                        <c:if test="${klus != null}"><option>${klus.klant.naam}</option></c:if>
                        <c:forEach var="klant" items="${bedrijf.klantenRegister}">
                            <option value= "${klant.naam}">${klant.naam}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="selectBox">
                    <h1>Alle auto's</h1>
                    <select name="autoSelect">
                        <c:if test="${klus != null}"><option>${klus.auto.kenteken}</option></c:if>
                        <c:forEach var="klant" items="${bedrijf.klantenRegister}">
                            <c:forEach var="auto" items="${klant.autoLijst}">
                                <option value="${auto.kenteken}">${auto.kenteken}</option>
                            </c:forEach>
                        </c:forEach>
                    </select>
                </div>   
                <div class="omschrijving">
                    <h1>Omschrijving</h1>
                    <input name="omschrijving" type="text" value="${klus.beschrijving}"/>
                </div>
                <input type="submit" name="button" value="nieuweKlus">
            </div>

            <div class="klusTijdSelect">
                <h1>Klus inplannen</h1>
                <label>Week select</label>
                <select name = "weekSelect">
                    <c:forEach begin="0" end="53" step="1" var="weekNummers">
                        <option value ="${weekNummers}">${weekNummers + 1}</option>
                    </c:forEach>
                </select>
                
                <br/>
                
                <label>Dag select</label>
                <select name = "dagSelect">
                    <c:forEach var="i" begin="0" end="4" step="1">
                        <c:choose>
                            <c:when test ="${i == 0}">
                                <option class = "dagTabel" value="${i}"> Maandag </option>
                            </c:when>
                            <c:when test ="${i == 1}">
                                <option class = "dagTabel" value="${i}"> Dinsdag </option>
                            </c:when>
                            <c:when test ="${i == 2}">
                                <option class = "dagTabel" value="${i}"> Woensdag </option>
                            </c:when>
                            <c:when test ="${i == 3}">
                                <option class = "dagTabel" value="${i}"> Donderdag </option>
                            </c:when>
                            <c:when test ="${i == 4}">
                                <option class = "dagTabel" value="${i}"> Vrijdag </option>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </select>
                
                <br/>
                
                <label>Aantal uur</label>
                <input type="number" name="uurSelect" value="uurSelect">              
                
                <br/>
                
                <input type="submit" name="button" value="klusInplannen">
                
                <br/>
                
                <c:if test="${boodschap != \"\"}"><p>${boodschap}</p></c:if>
            </div>
        </form>
    </body>
</html>
