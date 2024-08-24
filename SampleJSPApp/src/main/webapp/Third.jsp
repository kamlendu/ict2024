<%-- 
    Document   : Third
    Created on : 22-Aug-2024, 11:14:46 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        First Name : <%=request.getParameter("first") %>
      <br/>  Last Name : <%=request.getParameter("last") %>
       
      
    <br/>  User Name : <%=session.getAttribute("username") %>
     <br/> Company : <%=application.getAttribute("company") %>
     <%
         session.invalidate();
         %>
      
     <br/>   <h1>This is Third JSP</h1>
    </body>
</html>
