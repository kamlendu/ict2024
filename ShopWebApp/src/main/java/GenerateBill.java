import ejb.ShoppingBeanRemote;
import javax.naming.InitialContext;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "GenerateBill", urlPatterns = {"/GenerateBill"})
public class GenerateBill extends HttpServlet {
//@EJB(mappedName="ejb/MyCart1")
//ShoppingBeanRemote cart;

InitialContext ic;

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
              /* Setting MIME type for HTTP header */
        response.setContentType("text/html");
        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();
 ShoppingBeanRemote cart = (ShoppingBeanRemote)request.getSession(true).getAttribute("finalcart");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Linux Books</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='pink'>");

        out.println("<H1 ALIGN='center'>Bill</H1>");
        out.println("<H2 ALIGN='center'>www.bookstore.com</H2>");
        out.println("<H5 ALIGN='right'><B>Date:</B> " + (new Date()) + "</H5><HR><BR>");

        out.println("<TABLE BORDER='0' ALIGN='center' BORDERCOLOR='maroon' WIDTH='90%'>");
        out.println("<TR>");
        out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Book</B></FONT></TD>");
        out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Price</B></FONT></TD>");
          out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Quantity</B></FONT></TD>");
        out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Total</B></FONT></TD>");

        out.println("</TR>");

        Iterator products = cart.getContentsOfCart().iterator();

        for (int i = 0; products.hasNext(); i++) {
          Hashtable  product = (Hashtable) products.next();
            out.println("<TR>");
            out.println("<TD ALIGN='left' STYLE='Border:1px dashed #990033'>");
            out.println(product.get("name"));
            out.println("</TD>");

            out.println("<TD ALIGN='center' STYLE='Border:1px dashed #990033'>");
            out.println(product.get("price"));
            out.println("</TD>");
            out.println("<TD ALIGN='center' STYLE='Border:1px dashed #990033'>");
            out.println(product.get("quantity"));
            out.println("</TD>");
            out.println("<TD ALIGN='center' STYLE='Border:1px dashed #990033'>");
            out.println(product.get("total"));
            out.println("</TD>");
            out.println("</TR>");
            
        }
        out.println("<TR>");
        out.println("<TD ALIGN='right' STYLE='Border:3px dashed #990033'><B>Total: </B></TD>");
         out.println("<TD ALIGN='right' STYLE='Border:3px dashed #990033'><B></B></TD>");
         out.println("<TD ALIGN='right' STYLE='Border:3px dashed #990033'><B></B></TD>");
        out.println("<TD ALIGN='center' STYLE='Border:3px dashed #990033'>" + cart.getGrandTotal() + "</TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</BODY></HTML>");
        out.close();
    }
}