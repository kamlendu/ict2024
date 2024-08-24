<%-- 
    Document   : TryBean2
    Created on : 23-Aug-2024, 1:40:43 PM
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
        <h1>
            <br/> Try Bean 2
            
  <br/>    Empno :     <jsp:getProperty name="emp" property="empno"/>      
   <br/>    Emp Name :     <jsp:getProperty name="emp" property="ename"/>  
   <br/>    Salary :     <jsp:getProperty name="emp" property="salary"/>      
             
            
            
            
        </h1>
    </body>
</html>
