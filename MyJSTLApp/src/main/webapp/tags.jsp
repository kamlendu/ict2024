<%-- 
    Document   : tags
    Created on : 04-Sep-2024, 11:45:45 AM
    Author     : root
--%>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="mytags" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            
            <c:set var="str" value="department of ict"/>
            
            Name of Department : ${fn:toUpperCase(str)}
            
            <br>`
            
            <mytags:curdate/>
            <br/>
            <mytags:upper>this is a flower</mytags:upper>
            <br/><!-- comment -->
            <mytags:ccase to="sada">msc ict</mytags:ccase>
            
            
            
        </h1>
    </body>
</html>
