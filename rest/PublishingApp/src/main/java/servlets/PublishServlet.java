/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "PublishServlet", urlPatterns = {"/PublishServlet"})
public class PublishServlet extends HttpServlet {
    
    @EJB PublishBeanLocal pbl;

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
            out.println("<title>Servlet PublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>");
            
            //pbl.addCustomer("Arvind", "Shah");
           // pbl.addAddressToCustomer("D-321", "Surat", "Gujarat", "395007", 10);
           // pbl.addAddressToCustomer("E-1", "Vadodara", "Gujarat", "380001", 10);
           
           
           Collection<Integer> sids = new ArrayList<Integer>();
           sids.add(1); sids.add(2); sids.add(3);
           
           //pbl.addSubscriptionsToCustomer(10, sids);
          // pbl.removeSubscriptionsToCustomer(10, sids);
            
         // pbl.removeAddressFromCustomer(10, 6);
         // pbl.removeAddressFromCustomer(10, 7);
         
         pbl.removeCustomer(10);
            
            Collection<Customer> custs = pbl.getAllCustomers();
            
            for(Customer c : custs)
            {
                
            out.println("<br/> Cust id :"+ c.getCustomerID()+ " Name : "+ c.getFirstName()+ " "+ c.getLastName());
            Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
            
            for(Address a : addresses)
            {
               out.println("<br/> AddressId : "+ a.getAddressId()+ " Street : "+ a.getStreet()+ " City : "+ a.getCity()+ " State :"+ a.getState());
            }
            Collection<Subscription> subs = pbl.getSubscriptionOfCustomer(c.getCustomerID());
            
            for(Subscription s : subs)
            {
                out.println("<br/> Subid : "+ s.getSubscriptionId()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
            }
            out.println("<hr/>");
            
            }
            out.println("</h3>");
            out.println("<h1>Servlet PublishServlet at " + request.getContextPath() + "</h1>");
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
