<%-- 
    Document   : Parkeerplaats
    Created on : 31-mei-2015, 14:19:33
    Author     : Nederlandhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="HoofdschermCSS.css" rel="stylesheet" type="text/css">
        <title>Parkeerplaats</title>
    </head>
    <body>
        <div class="header">
            <b>AutoTotaalDienst</b><br>
            <i>Auto's in hun totaliteit</i>
        </div>
        
        <div class="hoofdschermdiv">
            <form action="ParkeerplaatsServlet" method="post">
            <div class="hoofdschermdivcontent">
                Welkom op het overzicht van de parkeerplaats.
                Hieronder kunt u de gewenste parkeerplek selecteren en vervolgens de datum invullen om de beschikbaarheid te bekijken.
            
                
                    <label for="date">Datum: </label>
                    <input type="text" name="date" id="date" placeholder="dd/mm/yyyy" maxlength="10" required>
                    <button name="button" value="overzicht">Overzicht</button>
                
                <br />
            </div>
            </form>
            <div class="knoppenmenu">
                <button type="button" onclick="location.href='Hoofdscherm.jsp'" class="divknoppen">Terug</button>
            </div>
            
        </div>
        
    </body>
</html>
