/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"}, initParams = {
    @WebInitParam(name = "city", value = "Surat"),
    @WebInitParam(name = "district", value = "Bharuch")})
public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
        String city =     this.getInitParameter("city");
        String district =     this.getInitParameter("district");
       //  String city =   request.getServletContext().getInitParameter("city");
       
//       String names[] = request.getParameterValues("ename");
//       
//       for(String s : names)
//       {
//           out.println("<br/>"+s);
//       }
       
       
out.println("<br/>Query String :"+request.getQueryString());
out.println("<br/>Request :"+request.getRemoteAddr());
out.println("<br/>Local Port :"+request.getLocalPort());
out.println("<br/>Locale :"+request.getLocale());
out.println("<br/>SessionId :"+request.getSession().getId());

       
       
//        String firstName = request.getParameter("fname");
//        String lastName = request.getParameter("lname");
//            
//            
//            out.println("<h1>Full Name : "+ firstName +" "+ lastName+ "</h1>");
            
           
       
       
       
       out.println("<h1>City :"+ city+"</h1>");
             out.println("<h1>District :"+ district+"</h1>");
            
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
