/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.PublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "RestPublishServlet", urlPatterns = {"/RestPublishServlet"})
public class RestPublishServlet extends HttpServlet {
    
PublishClient pbl;
Response rs;
Collection<Customer> custs;
GenericType<Collection<Customer>> gcusts;
Collection<Address> addresses;
GenericType<Collection<Address>> gaddresses;
Collection<Subscription> subs;
GenericType<Collection<Subscription>> gsubs;


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
            out.println("<title>Servlet RestPublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
               out.println("<h3>");
               
               pbl = new PublishClient();
               
               custs = new ArrayList<>();
               gcusts = new GenericType<Collection<Customer>>(){};
               addresses = new ArrayList<>();
               gaddresses = new GenericType<Collection<Address>>(){};
               subs = new ArrayList<>();
               gsubs = new GenericType<Collection<Subscription>>(){};
            //pbl.addCustomer("Arvind", "Shah");
           // pbl.addAddressToCustomer("D-321", "Surat", "Gujarat", "395007", "10");
           // pbl.addAddressToCustomer("E-1", "Vadodara", "Gujarat", "380001", "10");
           
           
           Collection<Integer> sids = new ArrayList<Integer>();
           sids.add(1); sids.add(2); sids.add(3);
           
           //pbl.addSubscriptionsToCustomer(sids, "10");
          // pbl.removeSubscriptionsToCustomer(sids, "10");
           
         
          //pbl.removeAddressFromCustomer("10", "6");
          //pbl.removeAddressFromCustomer("10", "7");
         
         pbl.removeCustomer("10");
            
            rs = pbl.getAllCustomers(Response.class);
        
             custs = rs.readEntity(gcusts);
            
            for(Customer c : custs)
            {
                
            out.println("<br/> Cust id :"+ c.getCustomerID()+ " Name : "+ c.getFirstName()+ " "+ c.getLastName());
             
            rs = pbl.getAddressesOfCustomer(Response.class, String.valueOf(c.getCustomerID()));
            addresses = rs.readEntity(gaddresses);
            
            for(Address a : addresses)
            {
               out.println("<br/> AddressId : "+ a.getAddressId()+ " Street : "+ a.getStreet()+ " City : "+ a.getCity()+ " State :"+ a.getState());
            }
            
            rs = pbl.getSubscriptionOfCustomer(Response.class,String.valueOf(c.getCustomerID()));
            subs = rs.readEntity(gsubs);
            
            for(Subscription s : subs)
            {
                out.println("<br/> Subid : "+ s.getSubscriptionId()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
            }
            out.println("<hr/>");
            
            }
            out.println("</h3>");
            
            
            
            out.println("<h1>Servlet RestPublishServlet at " + request.getContextPath() + "</h1>");
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
