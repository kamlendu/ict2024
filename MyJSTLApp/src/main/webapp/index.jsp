<%-- 
    Document   : index
    Created on : 28-Aug-2024, 11:51:14 AM
    Author     : root
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            List<String> strs = new ArrayList<>();
            strs.add("first");
            strs.add("second");
            strs.add("third");
            strs.add("fourth");
            
            session.setAttribute("mystr", strs);
            
            request.setAttribute("uname", "Prakash");
            session.setAttribute("uname", "Rashmi");
            application.setAttribute("uname", "Rakesh");


            
            %>
        
        <h2>
            
            <br> ${requestScope.uname}
            <br> ${sessionScope.uname}
            <br> ${applicationScope.uname}
            
            <br/>
            
            
            <c:out value="Hello World of JSTL and EL"/>
            <br/> <c:out value=" The sum of 20 and 30 is ${20+30}"/>
            
            <c:set var="x" value="10"/>
            <c:set var="y" value="20"/>
     <br/> <c:out value=" The sum of ${x} and ${y} is ${x+y}"/>              
            
     <c:set var="x" value="${param.num1}"/>
     
     <c:set var="y" value="${param.num2}"/>
    
     <br/> <c:out value=" The sum of ${x} and ${y} is ${x+y}"/> 
     
      <c:set var="num" value="10"/>
     
      <c:if var="cond" test="${num > 10}">
             <br/> Num is greater than 10
       </c:if>
       <c:if var="cond" test="${num < 10}">
             <br/> Num is less than 10
       </c:if>
             
             <c:choose>
                 <c:when test="${num > 10}">
                    <br/> Choose : Num is greater than 10 
                 </c:when>
                    <c:when test="${num < 10}" >
                  <br/> Choose : Num is less than 10 
                    </c:when>
                    <c:otherwise>
                        <br/> Choose : Num is equal to  10 
                    </c:otherwise>
             </c:choose>     
             
                        <br/>
       
                        <c:forEach var="i" begin="1" end="10">
                         <br/>   The square of ${i} is ${i*i}
                        </c:forEach> 
                         
                         <c:forEach var="s" items="${mystr}">
                             <br> ${s}
                         </c:forEach>
                        
            
        </h2>
    </body>
</html>
