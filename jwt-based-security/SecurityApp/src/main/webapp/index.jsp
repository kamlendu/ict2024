<%-- 
    Document   : index
    Created on : 16 Oct, 2021, 12:44:25 PM
    Author     : root
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
    </head>
    <body>

      

        <form method="POST">
            <table>
                <tr>
                    <td colspan="2">Login:</td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"/></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>

        <br>
        <% if(request.getAttribute("error")!=null) {%>
        <div style="color:red"> ** <%=request.getAttribute("error")%></div>
        <% } %>
    </body>
</html>