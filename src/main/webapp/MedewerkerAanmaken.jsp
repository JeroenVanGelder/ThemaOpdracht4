<html>
<head>
    <form action = "MedewerkerAanmakenServlet" method = "post">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <link href="MedewerkerAanmakenCSS.css" rel="stylesheet">
    <!DOCTYPE html>
</head>
<body>
    <div id="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div> 
    <div id="hoofdschermdiv">
        <div class="CSSTableGenerator" >
            <p><b>Vul hier de gegevens van uw nieuwe medewerker in</b></p>
            <p>
                Voornaam
                <input class = "ltf" type = "text" name = "naam"  placeholder="Real name">
            </p>    
            <p>
                Straatnaam
                <input type="text" name="straatnaam" placeholder="Straatnaam">
            </p>    
            <p>
                Huisnummer
                <input type="text" name="huisnummer" placeholder="Huisnummer"> 
            </p>    
            <p>
                Woonplaats
                <input type="text" name="Woonplaats" placeholder="Woonplaats">
            </p>    
            <p>
                Postcode
                <input type="text" name="postcode" placeholder="Postcode">
            </p>
            <p>
                Email
                <input type="text" name="email" placeholder="Email">
            </p>    
            <p>
                Bevestiging email
                <input type="text" name="email2" placeholder="Herhaal email">
            </p>    
            <p>
                Functie
                <select name="select">
                    <option value="Parkeermedewerker">Parkeermedewerker</option>
                    <option value="Monteur" selected> Monteur </option>
                </select>
            </p>    
            <p>
                Uurloon
                <input type = "text " name = "uurloon"  placeholder="Uurloon"/>
            </p>    
            <p>
                Gebruikersnaam
                <input type = "text" name = "inlognaam"  placeholder="Gebruikersnaam"/>
            </p>    
            <p>
                Wachtwoord
                <input type = "text" name = "wachtwoord"  placeholder="Wachtwoord"/>
            </p>    
            <p>
                Bevestiging wachtwoord
                <input type = "text" name = "wachtwoordCheck"  placeholder="Herhaal wachtwoord"/><br>               
            </p>
            <div id="registreerdiv">
                <input type = "submit" name = "actie" value = "Registreer"/>
            </div>    
</body>
</html>
