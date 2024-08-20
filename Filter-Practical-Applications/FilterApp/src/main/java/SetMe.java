import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.lang.*;
import java.util.*;

public class SetMe extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	/* Setting MIME type for HTTP header */
		response.setContentType("text/html");

	/* Getting handle to the output stream */
		PrintWriter out = response.getWriter();

		Connection con = null;
		Statement stmt;

		try 
		{
			String username = "root";
			String password = "ompandey";
			String url = "jdbc:mysql://localhost/test?useSSL=false";

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			con = DriverManager.getConnection(url,username,password);

			if(con != null)
			{
				out.println("<BR>Successfully connected to MySQL server using TCP/IP...<BR>");
				stmt = con.createStatement();
				String query = "SELECT * FROM login where user = '" + request.getParameter("txtusername").toString() + "' and password ='" + request.getParameter("txtpassword").toString() + "'";

			/* Execute the query using the ResultSet object */
				ResultSet rs = stmt.executeQuery(query);

				if(rs.next() == false) 
				{
					out.println("<BR>Sorry. Invalid Login. Please try again.");	
				}
				else
				{
				HttpSession session = request.getSession(true);
                                    session.setAttribute("user", rs.getString(1));
                                    session.setAttribute("pass", rs.getString(2));

                                    out.println("<BR>Successful Login. Welcome to the world of Servlets.");
					if(request.getParameter("chkrem") != null)
					{
						Cookie returnLoginUser = new Cookie("ValidUser", request.getParameter("txtusername").toString());
					/* Setting how much time in seconds should elapse before the cookie expires */
						returnLoginUser.setMaxAge(36000);
					/* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
						response.addCookie(returnLoginUser);

						Cookie returnLoginPassword = new Cookie("ValidPassword", request.getParameter("txtpassword").toString());
					/* Setting how much time in seconds should elapse before the cookie expires */
						returnLoginPassword.setMaxAge(36000);
					/* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
						response.addCookie(returnLoginPassword);
					}
					else
					{
						Cookie returnLoginUser = new Cookie("ValidUser", "");
					/* Setting how much time in seconds should elapse before the cookie expires */
						returnLoginUser.setMaxAge(0);
					/* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
						response.addCookie(returnLoginUser);

						Cookie returnLoginPassword = new Cookie("ValidPassword", "");
					/* Setting how much time in seconds should elapse before the cookie expires */
						returnLoginPassword.setMaxAge(0);
					/* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
						response.addCookie(returnLoginPassword);

						out.println("<BR>You did not choose to remember the login information. Hence you will need to enter login details the next time you visit us.");	
					}

				}
			}
	
		/* Closing the output stream */
			out.close();
		}	
		catch(Exception e) 
		{
			System.err.println("Exception: " + e.getMessage());
		} 
	}
}