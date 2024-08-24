<%-- 
    Document   : First
    Created on : 21-Aug-2024, 12:02:58 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            int x;
            int y;
            int sum;        
            %>
 
        <%@include  file="header.jsp"%>
       
        <%-- This is a Scriptlet --%>
        <%
            x= Integer.parseInt(request.getParameter("x"));
            y= Integer.parseInt(request.getParameter("y"));
            sum = x+y;
      
            out.println("<br/><h3> The sum of"+ x+" and "+ y +" is "+ sum+ "</h3>");
            %>
        <h2>
            The current Date is <%=new Date().toString()%>
            
            <%
                session.setAttribute("username", "admin");
                
                 application.setAttribute("company", "ABC Ltd.");
                
                %>
            
        </h2>
        
    </body>
</html>
