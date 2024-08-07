/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    Connection con;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    public BookServlet() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "ompandey");
            
            
        }
        catch(ClassNotFoundException cnf)
        {
            cnf.printStackTrace();
        }
        catch(SQLException sqe)
        {
            sqe.printStackTrace();
        }
        
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String bookname = request.getParameter("bname");
            String authorname = request.getParameter("authname");
            String pubname = request.getParameter("pname");
            String synopsis = request.getParameter("synopsis");
            
           // addBook(bookname, authorname, pubname, synopsis);
            
            out.println("<table border='1'>");
            
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from BookMaster");
         
                while(rs.next())
                {
                    out.println("<tr><td>Book Name : "+ rs.getString("BookName")+"</td><td>"+ rs.getString("AuthorName")+"</td><td>"+rs.getString("PublisherName")+"</td><td>"+rs.getString("Synopsis")+"</td><td><a=href=''>Update</a></td><td><a=href=''>Delete</a></td></tr>");
                }
                
                 out.println("</table>");
                
            } catch (SQLException ex) {
             
            ex.printStackTrace();
            }
            
            
            out.println("<h1>Servlet BookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    public void addBook(String bookname, String authorname, String pubname, String synopsis) 
    {
        
        try {
            String insql = "insert into BookMaster(BookName,AuthorName,PublisherName, Synopsis) values(?,?,?,?)";
            
            PreparedStatement psmt = con.prepareStatement(insql);
        
            psmt.setString(1, bookname);
            psmt.setString(2, authorname);
            psmt.setString(3, pubname);
            psmt.setString(4, synopsis);
            
            psmt.executeUpdate();
            
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
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
