<%-- 
    Document   : data.jsp
    Created on : 29-Aug-2024, 10:47:49 AM
    Author     : root
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            <sql:setDataSource dataSource="jdbc/mydata"/>      
            <%--
            <sql:update var="insert">
                insert into employee values(?,?,?)
                <sql:param value="35"/>
                <sql:param value="Rashmi"/>
                <sql:param value="7000"/>
                
            </sql:update>
            --%>
            
            
            <sql:query var="qry">
                select * from employee
            </sql:query>
              
                
                <table border="1">
                
                <c:forEach var="row" items="${qry.rowsByIndex}">
                    <tr><td>${row[0]}</td><td>${row[1]}</td><td>${row[2]}</td></tr>   
                </c:forEach>      
            
                </table>
            
            
            
            
        </h3>
    </body>
</html>
