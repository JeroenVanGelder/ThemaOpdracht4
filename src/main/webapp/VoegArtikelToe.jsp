
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <jsp:include page="Header.jsp"/>
  
        <form action = "voegArtikelToeServlet" method = "post">
              <link href="ramicss.css" rel="stylesheet">
         <image src="http://ak.picdn.net/shutterstock/videos/1167619/preview/stock-footage-animated-bubbles-over-a-blue-neutral-background.jpg" id="image" alt="">
    <div id = "scherm">
         <h1>
             <div class="CSSTableGenerator" >
                <table >
                    <tr>
                        <td >
                             naam :
                        </td>
                        <td>
                          <input class = "ltf" type = "text" name = "naam" placeholder="naam" />
                        </td>
                       
                    </tr>
                    <tr>
                        <td >
                           prijs :
                        </td>
                        <td>
                           <input class = "ltf" type = "text" name = "prijs"  placeholder="prijs" /><br />
                        </td>
                     
                    </tr>
                    <tr>
                        <td >
                           minVoorraad : 
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "minVoorraad"  placeholder="minVoorraad" /><br />
                        </td>
                      
                    </tr>
                     <tr>
                        <td >
                           beschrijving : 
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "beschrijving"  placeholder="beschrijving" /><br />
                        </td>
                      
                    </tr>
                   
                      <tr>
                        <td >
                         functie : 
                        </td>
                                  <td>
                             <select name="select">
              <option value="Onderdeel">Onderdeel</option>
              <option value="Brandstof" selected> BrandStof  </option>
                </select><br>
                        </td>    
                       
                    </tr>
                </table>
            </div>
      <br>
      <input type = "submit" name = "actie" value = "VoegToe"/>
    </div>
      </h1>

</body>
</html>
