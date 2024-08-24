<%-- 
    Document   : TryBean3
    Created on : 23-Aug-2024, 1:45:21 PM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/>
</jsp:useBean>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
     <%   
        if(emp.validate())
        {
     
         %>
        
    <br/>    Empno :     <jsp:getProperty name="emp" property="empno"/>      
   <br/>    Emp Name :     <jsp:getProperty name="emp" property="ename"/>  
   <br/>    Salary :     <jsp:getProperty name="emp" property="salary"/>      
  
   
     <%
         }
    else
            {
       %>
       <jsp:forward page="EmpForm.jsp"/>
       
       <%
           }
           %>
        
        <h1>Hello World!</h1>
    </body>
</html>
