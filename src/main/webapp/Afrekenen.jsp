

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="AfrekenenCSS.css" rel="stylesheet">
    <title></title>
</head>
<div id="header">
    <b>AutoTotaalDienst</b><br>
    <i>Auto's in hun totaliteit</i>
</div> 
<body>
    <div id="hoofdschermdiv">
        <button class="terugknop" type="button" onclick="location.href='Hoofdscherm.jsp'" id="terugknop">Terug</button>
        <form action="AfrekenenServlet.do" method="submit">
            <input type="submit" name="betalenknop" value="Betalen" id="betalenknop">
            <div id="messagebox">

            </div>
        </form>
    </div>
</body>
</html>
