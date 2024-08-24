<%-- 
    Document   : TryBean1
    Created on : 23-Aug-2024, 1:32:49 PM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:setProperty name="emp" property="empno" value="5"/>
        <jsp:setProperty name="emp" property="ename" value="Paresh"/>
        <jsp:setProperty name="emp" property="salary" value="5000"/>
        
        <jsp:forward page="TryBean2.jsp"/>
            
  
        <h1>Hello World!</h1>
    </body>
</html>
