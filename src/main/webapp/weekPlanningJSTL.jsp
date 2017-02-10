<%-- 
    Document   : weekPlanningJSTL
    Created on : May 25, 2015, 11:32:43 AM
    Author     : Jeroen
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nl.hu.to4.groep1.domain.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="weekPlanningCss.css" />
<!DOCTYPE html>
    
    <jsp:include page="HeaderJSTL.jsp">
        <jsp:param name="title" value="De WeekPlanning"/>
    </jsp:include>
        <%
            //Eerst probeer ik de weekplanning op te halen
            Object obj = null;
            WeekPlanning wP = null;
            Klus klussen[][] = null;
            int weekNummer = -1;
            
            if(request.getAttribute("weekPlanning") != null)
            {
                obj = request.getAttribute("weekPlanning");
                if(obj != null && obj instanceof WeekPlanning)
                {
                    wP = (WeekPlanning)obj;
                    klussen = wP.getKlussen(); 
                }
            }
            
            if(request.getAttribute("weekNummer") != null)
            {
                obj = request.getAttribute("weekNummer");
                if(obj != null && obj instanceof Integer)
                {
                    weekNummer = (Integer)obj;
                }
            }
        %> 
    <c:set var="klussen" value="<%=klussen%>"/>
    <c:set var="weekNummer" value="<%=weekNummer%>"/>
    
        
    
        <div id ="weekNummerSelect">
            <FORM action ="WeekPlanningServletJSTL" method ="post">
                <SELECT NAME = "weekNummerSelect" TYPE = "submit">
                    <c:if test="${weekNummer != -1}">
                        <OPTION VALUE = ${weekNummer}>${weekNummer}</OPTION>
                    </c:if>
                    <c:forEach var="i" begin="0" end="52" step="1">
                        <OPTION VALUE = ${i}>  ${i} </OPTION>
                    </c:forEach>

                </SELECT>
                <input type ="submit" name="button" value ="kies">
            </FORM>
        </div>  
                    
            <FORM action ="WeekPlanningServletJSTL" method ="post">
                <div id = "weekplanningBox">                
 
                    <c:if test="${klussen != null}"> 
                        
                        <input name = "weekNummerHidden" type="hidden" value ="${weekNummer}"/>
                        
                        <TABLE id = "weekplanningtabel">
                            <TD class = "dagTabel">
                                <c:forEach var="i" begin="0" end="7" step="1">
                                   <TD class = "uurTabel"> ${i + 8}
                                </c:forEach>

                        <c:forEach var="i" begin="0" end="4" step="1">
                            <TR class = "urenRij">
                                <c:choose>
                                    <c:when test ="${i == 0}">
                                        <TD class = "dagTabel"> Maandag
                                    </c:when>

                                    <c:when test ="${i == 1}">
                                        <TD class = "dagTabel"> Dinsdag
                                    </c:when>

                                    <c:when test ="${i == 2}">
                                        <TD class = "dagTabel"> Woensdag
                                    </c:when>

                                    <c:when test ="${i == 3}">
                                        <TD class = "dagTabel"> Donderdag
                                    </c:when>

                                    <c:when test ="${i == 4}">
                                        <TD class = "dagTabel"> Vrijdag
                                    </c:when>
                                </c:choose>
                                           
                                <c:forEach var="y" begin="0" end="7" step="1">
                                    
                                    <c:set var="klus" value="${klussen[i][y].auto.kenteken}" />
                                    <c:choose>
                                        <c:when test ="${klus != null}">
                                            <TD class = "beschrijvingTabel"><BUTTON name="button" value ="geplanned${i}${y}"> ${klus}</BUTTON>
                                        </c:when>                       
                                        <c:otherwise>
                                           <TD class = "beschrijvingTabel"><BUTTON name="button" value="inplannen${i}${y}"> inplannen </BUTTON>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </c:forEach>       

                        </TABLE>
                    </c:if>
                  
                </div>
            </form>
        
    </body>
</html>
