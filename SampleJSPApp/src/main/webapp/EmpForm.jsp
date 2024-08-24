<%-- 
    Document   : EmpForm
    Created on : 20-Jan-2023, 11:40:49 AM
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
    <center>
        <form action="TryBean3.jsp" method="POST">
            <table width="50%">  
                <tr><td>     Emp no</td> 
                    <td> <input type="text" name="empno" value="<%=emp.getEmpno() %>"></td><td style="color:red"><%=emp.getError("empno")%> </td></tr>
                <tr><td>     Name :</td> 
                    <td> <input type="text" name="ename" value="<%=emp.getEname()%>"></td><td style="color:red"> <%=emp.getError("ename")%> </td></tr>
                <tr><td> Salary :</td> 
                    <td> <input type="text" name="salary" value="<%=emp.getSalary()%>"></td><td style="color:red"> <%=emp.getError("salary")%> </td></tr>
                <tr><td></td> <td><input type="submit" name="submit" value="Submit"></td><td></td></tr>
            </table>  

        </form>
    </center>
</body>
</html>
