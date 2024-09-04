<%-- 
    Document   : test
    Created on : 04-Sep-2024, 12:24:17 PM
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
        <h1>
            ${dept}
            
            <%
                application.setAttribute("subject", "Java");
                %>
        </h1>
    </body>
</html>
