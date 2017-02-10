<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="HoofdschermCSS.css" rel="stylesheet" type="text/css">
    <title>Auto's in hun totaliteit!</title>
</head>
<body>
    <div class="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div>
    <hr>
    <div class="hoofdschermdiv">
        <div class="hoofdschermdivcontent">
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
                dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non 
                proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </div>
        <div class="knoppenmenu">
               <button type="button" onclick="location.href='Parkeerplaats.jsp'" class="divknoppen">Parkeerplek Reserveren</button>
            <button type="button" onclick="location.href='Factuuroverzicht.jsp'" class="divknoppen">Factuuroverzicht</button>
            <c:if test="${ingelogdeUser.functie == 'Eigenaar'}">
                <button type="button" onclick="location.href='MedewerkerAanmaken.jsp'" class="divknoppen">Medewerker aanmaken</button>
                <button type="button" onclick="location.href='klusToevoegen.jsp'" class="divknoppen">Klus Toevoegen</button>  
                <button type="button" onclick="location.href='weekPlanningJSTL.jsp'" class="divknoppen">Weekplanning</button>
            </c:if>              
        </div>    
    </div>
</body>
</html>
