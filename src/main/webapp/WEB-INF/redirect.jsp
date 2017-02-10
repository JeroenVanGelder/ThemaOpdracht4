<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page import="java.io.IOException"%>
<%@page import="nl.hu.to4.groep1.domain.Bedrijf"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%// als het zo mag wordt hier de obj file uitgelezen en online gezet.
    String returnAddress = "Beginscherm.jsp";
    Bedrijf bedrijf = null;
    try
    {
        FileInputStream fis = new FileInputStream("bedrijf.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        bedrijf = (Bedrijf)obj;
        getServletContext().setAttribute("bedrijf", bedrijf);
    }
    catch(IOException io)
    {
        System.err.println("IOException");
    }
    catch(ClassNotFoundException fnfe)
    {
        System.err.println("ClassNotFoundException");
    }
    if(bedrijf == null){
        returnAddress = "databaseVulScherm.jsp";
    }
    
%>


<% response.sendRedirect("Beginscherm.jsp"); %>
