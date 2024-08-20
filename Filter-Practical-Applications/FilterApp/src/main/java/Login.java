import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Login extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
	/* Passing ServletConfig to parent */
		super.init(config);
	/* Initializing resources here */
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	/* Setting MIME type for HTTP header */
		response.setContentType("text/html");

	/* Getting handle to the output stream */
		PrintWriter out = response.getWriter();

		String username = "";
		String password = "";

	/* Finding the cookie named "CookieName" */
		Cookie[] cookies = request.getCookies();

		if(cookies != null)
		{
			for(int i=0; i < cookies.length; i++) 
			{
				Cookie thisCookie = cookies[i];

				if (thisCookie.getName().equals("ValidUser")) 
				{
					username = thisCookie.getValue();
				}
				else if(thisCookie.getName().equals("ValidPassword"))
				{
					password= thisCookie.getValue();
				}
			}
		}

		out.println("<HTML><HEAD><TITLE>Login Form</TITLE></HEAD>");
		out.println("<BODY><FORM  NAME='frmLogin'>");
		out.println("<TABLE><TR><TD ALIGN='center'><IMG SRC='/MyWebApplication/security.jpg' WIDTH='64' HEIGHT='64' BORDER='0'>");
		out.println("<BR>Welcome to Our Website!<BR>Use a valid username and password <BR>");
		out.println("to gain access to the Book Master Form</TD><TD BORDERCOLOR='#DEEFF9'>");
		out.println("<TABLE WIDTH='25%' BORDER='1' ALIGN='center' CELLPADDING='3' CELLSPACING='1' BORDERCOLOR='#000000'>");
		out.println("<TR BORDERCOLOR='#92CAEB' BGCOLOR='white'><TD COLSPAN='2'>Member Login</TD></TR>");
		out.println("<TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Username:</TD><TD>");
		out.println("<INPUT NAME='txtusername' TYPE='text' TABINDEX='1' VALUE='" + username + "' SIZE='15' MAXLENGTH='15'></TD>");
		out.println("</TR><TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Password:</TD><TD>");
		out.println("<INPUT NAME='txtpassword' TYPE='password' TABINDEX='2' VALUE='" + password + "' SIZE='15' MAXLENGTH='15'></TD></TR>");
		out.println("<TR BORDERCOLOR='#E6F3FB'><TD COLSPAN='2' ALIGN='right'>");
		out.println("<INPUT NAME='chkrem' TYPE='checkbox' VALUE='REMEMBER' TABINDEX='3'>REMEMBER ME</TD></TR>");
		out.println("<TR BORDERCOLOR='#E0EEF7'><TD COLSPAN='2' ALIGN='right'>");
		out.println("<INPUT NAME='submit' TYPE='submit' VALUE='Sign In' TABINDEX='4'></TD></TR>");
		out.println("</TABLE></TD></TR></TABLE>");
                 
                if(request.getAttribute("errormsg") !=null)
                out.println(request.getAttribute("errormsg"));
                
                
                out.println("</FORM></BODY></HTML>");

                ;
	/* Closing the output stream */
		out.close();
	}

/* Identifying the Servlet to the Web Server when required */
	public String getServletInfo()
	{
		return "Login Form By Kamlendu Pandey Version 1.0";
	}

	public void destroy()
	{
	/* The Servlet is being unloaded. Free resources used by the Servlet here. */
	}
}