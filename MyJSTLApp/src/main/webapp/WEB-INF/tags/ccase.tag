<%-- 
    Document   : ccase
    Created on : 04-Sep-2024, 11:58:22 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="to"%>
<jsp:doBody var="str"/>

<%-- any content can be specified here e.g.: --%>
<h2>
   <% 
     String content = (String)jspContext.getAttribute("str");
     String tocase = (String)jspContext.getAttribute("to");
    
     if(tocase.equals("upper"))
     {
      out.println(content.toUpperCase());
     }
     else if (tocase.equals("lower"))
     {
      out.println(content.toLowerCase());
    }
    else
    {
    out.println("Error -- Incorrect use of tag..");
   }

    %>
</h2>