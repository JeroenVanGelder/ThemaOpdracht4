
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="Header.jsp"/>

<%
  String gebruikersID= "";
  Cookie[] cookies = request.getCookies();
  if(cookies != null) {
    for (Cookie koek : cookies)
      if( koek.getName().equals("gebruikersnaam")) {
        gebruikersID = koek.getValue();
      }
  }
%>

<form action = "wachtwoordWijzigenServlet" method = "post">
     <link href="ramicss.css" rel="stylesheet">
  <div id = message >
    <% Object obj1 = request.getAttribute("msg2");
      if(obj1 != null){
        out.println(obj1);
      }
    %>
  </div>
  <image src="http://ak.picdn.net/shutterstock/videos/1167619/preview/stock-footage-animated-bubbles-over-a-blue-neutral-background.jpg" id="image" alt="">
  <div id = "scherm">  
      <h1>
           <tr>
                        <td >
                        username: 
                        </td>
                        <td>
                            <input class = "ltf" type = "text" name = "gebruikersnaam" required value=<%=gebruikersID %> /><br />
                        </td>
                       
                    </tr>
                    <tr>
                        <td >
                        password: 
                        </td>
                        <td>
                            <input class = "ltf" type = "password" name = "wachtwoord" /><br />
                        </td>
                     
                    </tr>
                      <tr>
                        <td >
                          password:
                        </td>

                    </tr>


   <br>
  <br>

    <input type = "wijzig" name = "actie" value = "login"/>
     </div>
  </div>





</form>
</body>
</html>
