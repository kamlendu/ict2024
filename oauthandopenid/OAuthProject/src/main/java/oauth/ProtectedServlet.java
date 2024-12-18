package oauth;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fish.payara.security.openid.api.OpenIdContext;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author root
 */
//@Dependent
@WebServlet(name = "ProtectedServlet", urlPatterns = {"/ProtectedServlet"})
public class ProtectedServlet extends HttpServlet {
//@Inject
//    OAuth2AccessToken token;
     @Inject
    OpenIdContext context;
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
            out.println("<title>Servlet ProtectedServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Caller = "+context.getCallerName());
        //Here's the caller groups
       // out.println("Groups = "+context.getCallerGroups());
        //Here's the unique subject identifier within the issuer
       // out.println(context.getSubject());
        //Here's the access token
        out.println("<br/>Token = "+context.getAccessToken());
        //Here's the identity token
        out.println("<br/>Identity = "+context.getIdentityToken());
        //Here's the user claims
        out.println(context.getClaimsJson());
            out.println("<h1>Open Id Servlet ProtectedServlet at " + request.getContextPath() + "</h1>");
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
