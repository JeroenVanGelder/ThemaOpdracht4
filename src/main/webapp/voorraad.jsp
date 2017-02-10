<%-- 
    Document   : voorraad
    Created on : 21-jun-2015, 10:48:04
    Author     : Rami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
          <form action ="voorraadServlet" method = "post">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lijst met artikelen!</h1>
    </body>
    <table>
       
  ${ArrayList = request.getAttribute("ArtikelenLijst")};
  <c: forEach var="VOER HIER IETS IN" items="bedrijf.list">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
        <button type="button" onclick="location.href='VoegArtikelToe.jsp'" class="terugKnop">voegArtikelToe</button>         
</table>
    </form>
</html>
