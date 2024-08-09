/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "VisitorServlet", urlPatterns = {"/VisitorServlet"})
public class VisitorServlet extends HttpServlet {
    
    int visits;
    Cookie visitorCookie = null;

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
            out.println("<title>Servlet VisitorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Cookie cookies[] = request.getCookies();
            
            if (cookies != null) {
                
                for (Cookie c : cookies) {
                    if (c.getName().equals("visit")) {
                        visitorCookie = c;
                         visits = Integer.parseInt(visitorCookie.getValue()) + 1;
                        out.println("<h3> You have visited this page " + visits + " times</h3>");
                        
                        visitorCookie.setValue(String.valueOf(visits));
                      //  visitorCookie.setMaxAge(0);
                        response.addCookie(visitorCookie);
                        
                    }
                }
                
                if (visits == 0) {
                    visitorCookie = new Cookie("visit", "1");
                    visits = 1;
                    response.addCookie(visitorCookie);
                    out.println("<h3> You have visited this page " + visits + " time</h3>");
                    
                }
                
            } else {
                
                visitorCookie = new Cookie("visit", "1");
                visits = 1;
                out.println("<h3> You have visited this page " + visits + " time</h3>");
           // visitorCookie.setMaxAge(0);
                response.addCookie(visitorCookie);
                
            }
            
            
            out.println("<h1>Servlet VisitorServlet at " + request.getContextPath() + "</h1>");
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
