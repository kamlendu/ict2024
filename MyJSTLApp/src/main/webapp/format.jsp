<%-- 
    Document   : format
    Created on : 02-Sep-2024, 10:46:12 AM
    Author     : root
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setAttribute("curdate", new java.util.Date());
        %>       
        <h3>
            <br/>
            <fmt:setLocale value="en_US"/>
            <fmt:setBundle var="mybundle" basename="sitedata"/>
            
            
            <fmt:message key="welcome" bundle="${mybundle}"/>
            
            <br/>
            
            <fmt:setLocale value="hi_IN"/>
            <fmt:setBundle var="mybundle" basename="sitedata"/>
            
            
            <fmt:message key="welcome" bundle="${mybundle}"/>
            
            <br/>
            
            
            <c:set var="now" value="${curdate}"/>
            <c:set var="num" value="23472.3498"/>

            <fmt:formatDate  type="both" value="${now}"/>
            <br/><fmt:formatDate  type="date" value="${now}"/>
            <br/><fmt:formatDate  type="time" value="${now}"/>
            <br/><fmt:formatDate pattern="dd/MM/yyyy"  type="date" value="${now}"/>
         
            
           <br/> <br/> <fmt:formatNumber  maxFractionDigits="2" value="${num}"/>
           <br/> <fmt:formatNumber maxIntegerDigits="3" value="${num}"/>
           <br/> <fmt:formatNumber currencySymbol="$" type="currency" value="${num}"/>

        </h3>
    </body>
</html>
