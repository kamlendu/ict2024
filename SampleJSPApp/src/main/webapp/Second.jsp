<%-- 
    Document   : Second
    Created on : 22-Aug-2024, 11:14:38 AM
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
        <h1> This is Second JSP</h1>
        <%--
         <jsp:include page="Third.jsp">
             <jsp:param name="first" value="Paresh"/>
             <jsp:param name="last" value="Patel"/>
         
         </jsp:include>
        --%>
         <jsp:forward page="Third.jsp">
             <jsp:param name="first" value="Paresh"/>
             <jsp:param name="last" value="Patel"/>
         
         </jsp:forward>
    </body>
</html>
