<html>
<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <link href="RegisterCSS.css" rel="stylesheet">
    <!DOCTYPE html>
</head>
        <jsp:include page="Header.jsp"/>
          <% Object obj = request.getAttribute("msg1");
  if(obj != null){
    out.println(obj);
  }
%>
<body>
    <div id="header">
        <b>AutoTotaalDienst</b><br>
        <i>Auto's in hun totaliteit</i>
    </div> 
    <form action = "registerServlet" method = "post">
    <div id="hoofdschermdiv">
        <% String functie = "klant" ;%>
        <p><b>Vul hier uw gegevens in</b></p>
        <p>
            Gebruikersnaam
            <input class = "ltf" type = "text" name = "gebruikersnaam" placeholder="Gebruikersnaam" />
        </p>    
        <p>
            Wachtwoord
            <input class = "ltf" type = "text" name = "Password"  placeholder="Password" />
        </p>    
        <p>
            Wachtwoord bevestiging
            <input class = "ltf" type = "text" name = "Password2"  placeholder="Password bevestiging" />
        </p>    
        <p>
            Real name
            <input class = "ltf" type = "text" name = "RealName"  placeholder="Real name" />
        </p>    
        <p>
            Straatnaam
            <input class = "ltf" type = "text" name = "straatnaam"  placeholder="Straatnaam" />
        </p>    
        <p>
            Huisnummer
            <input class = "ltf" type = "text" name = "huisnummer"  placeholder="Huisnummer" />
        </p>    
        <p>
            Woonplaats
            <input class = "ltf" type = "text" name = "Woonplaats"  placeholder="Woonplaats" />
        </p>    
        <p>
            Postcode
            <input class = "ltf" type = "text" name = "postcode"  placeholder="Postcode" />
        </p>    
        <p>
            Email
            <input class = "ltf" type = "text" name = "email" placeholder="Email" />
        </p>    
        <p>
            Email bevestiging
            <input class = "ltf" type = "text" name = "email2" placeholder="Email bevestiging:" />
        </p>    
        <p>
            Functie
            <input class = "ltf" type = "text "  name = "functie" readonly value=<%= functie %> /> 
        </p>
        <div id="registreerdiv">
            <input type = "submit" name = "actie" value = "Registreer"/>
        </div>
    </div>
</body>
</html>
