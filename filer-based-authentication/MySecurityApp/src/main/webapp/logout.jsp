<%-- 
    Document   : logout
    Created on : 28 Oct, 2010, 11:52:04 PM
    Author     : root
--%>


<%@page contentType="text/html"   pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
       request.logout();
       session.invalidate();
      // KeepRecord.reset();
//        
    // request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
       response.sendRedirect("index.jsp");
        %>
    </body>
</html>
