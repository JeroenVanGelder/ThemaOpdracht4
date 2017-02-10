
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="Header.jsp"/>
    <form action="loginServlet" method="post">
    <link href="inlogSchermCSS.css" rel="stylesheet">
</head>    
<body>
    <div id="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div> 
    <div id="hoofdschermdiv">
        <p>
            <b>Username</b>
        </p>
        <input type="text" name="gebruikersnaam"  />
        <p>
            <b>Password</b>
        </p>
        <input type="password" name="wachtwoord" />
        <p>
            <b>Functie</b>
        </p>
        <select name="select">
            <option value="Klant">Klant</option>
            <option  value="Werknemer">Werknemer</option
        </select>
    <input id="loginknop" type = "submit" name = "actie" value = "login"/>
    </div>
</form>
</body>
</html>
