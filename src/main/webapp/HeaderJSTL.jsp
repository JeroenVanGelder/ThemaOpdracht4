<%-- 
    Document   : HeaderJSTL
    Created on : May 25, 2015, 11:34:25 AM
    Author     : Jeroen
--%>
<%@page import="nl.hu.to4.groep1.domain.Bedrijf"%>
<link rel="stylesheet" type="text/css" href="HeaderJSTLCss.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>        
    </head>
    
    <body>
        <div id="Menubalk">
            <H1>Auto Totaal Dienst Web Application</H1> <button type="button" onclick="location.href='Hoofdscherm.jsp'" class="terugKnop">Hoofdscherm</button>           
            <c:if test="${ ingelogdeUser.functie != null }" >
                    <button type="button" onclick="location.href='KlantGegevens.jsp;'" class="klantGegevens"> account gegevens </button> 
            </c:if>
           <button type="button" onclick="location.href='voorraad.jsp'" class="terugKnop">voorraad</button>         
        </div>
        
        <H2> Welkom bij ${param.title} ${ingelogdeUser.naam}</h2>
        <br/>