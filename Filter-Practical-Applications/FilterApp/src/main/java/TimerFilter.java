import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import java.util.*;

public class TimerFilter implements Filter
{
    
    
	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException
	{
		this.config = config;
	}

	public void destroy()
	{
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		long before = System.currentTimeMillis();
              String user= (String)request.getParameter("username");

                System.out.println("before Timer Filter " + before);
              //  if(((HttpServletRequest)request).getSession().getAttribute("user")!=null){
               
                    // ((HttpServletResponse)response).sendRedirect("http://localhost:8080/FilterApp/Login");


                chain.doFilter(request, response);


 		long after = System.currentTimeMillis();

                        System.out.println("After Timer Filter " + after);

                String acTime = (after - before) + "milliseconds";

		String uri = "";
		if (request instanceof HttpServletRequest)

			uri = ((HttpServletRequest)request).getRequestURI();

		String dttime = (new java.util.Date()).toString();

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
				stmt = con.createStatement();
				String query = "INSERT INTO stat VALUES('" + uri + "', '" + dttime + "', '" + acTime + "')";

			/* Execute the query using the ResultSet object */
				stmt.executeUpdate(query);
			}
		}	
		catch(Exception e) 
		{
			System.err.println("Exception: " + e.getMessage());
		}
           // }
 //else{

        // ((HttpServletRequest)request).getRequestDispatcher("Login").forward(request, response);
         

 //}
	}
}
