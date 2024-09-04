<%-- 
    Document   : upper
    Created on : 04-Sep-2024, 11:49:54 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<jsp:doBody var="str"/>

<%-- any content can be specified here e.g.: --%>
    <%
        String content = (String)jspContext.getAttribute("str");
        
        out.println(content.toUpperCase());
        
        %>
    
