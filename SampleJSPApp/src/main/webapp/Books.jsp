<%-- 
    Document   : Books
    Created on : 22-Aug-2024, 10:45:18 AM
    Author     : root
--%>

<%@page contentType="text/html" import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! 
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;
        String bname;
        String pname;
        String aname;
        String synopsis;
        
        %>
        <h2>
            <%
                try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","ompandey");

                }
                catch(ClassNotFoundException ce)
                {
                ce.printStackTrace();
                }
                catch(SQLException se)
                {
                se.printStackTrace();
                }
            %>
               
            <br/> Book Name      : <%=request.getParameter("bname")%>
            <br/> Author Name    : <%=request.getParameter("authname")%>
            <br/> Publisher Name : <%=request.getParameter("pname")%>
            <br/> Synopsis       : <%=request.getParameter("synopsis")%>
        
            <%
                bname = request.getParameter("bname");
                aname = request.getParameter("authname");
                pname = request.getParameter("pname");
                synopsis = request.getParameter("synopsis");
             try{   
                String ins = "insert into BookMaster(BookName, AuthorName, PublisherName,Synopsis) values(?,?,?,?)";
                stmt = con.prepareStatement(ins);
                stmt.setString(1, bname);
                stmt.setString(2, aname);
                stmt.setString(3, pname);
                stmt.setString(4, synopsis);
                
                stmt.executeUpdate();
                }
                catch(SQLException xe)
                {
                xe.printStackTrace();
                }
                
                %>
            
            
        </h2>
    </body>
</html>
