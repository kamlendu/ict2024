/*
 * BookMaster.java
 *
 * Created on August 30, 2008, 1:19 PM
 */

/**
 *
 * @author root
 * @version
 */

//import ejb.BookBeanLocal;

import entity.BookMaster;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import ejb.BookBeanLocal;

@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {
  
 @EJB
  BookBeanLocal book;
    
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
      
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       //Loading EJB
        
            String bookname = request.getParameter("txtBookName");
            String synopsis = request.getParameter("txtSynopsis");
            String authorname = request.getParameter("txtAuthorName");
            String publishername = request.getParameter("txtPublisherName");
        
            
        if("D".equals(request.getParameter("hidMode"))) {
            try {
                 String ids=request.getParameter("hidSelDel");
              StringTokenizer st = new StringTokenizer(ids,",");
              while(st.hasMoreTokens()) { 
              book.removeBook(new Integer(st.nextToken()));
              }
                response.sendRedirect("/EnterpriseBookApp/BookServlet");
            } catch(Exception e) {
                out.println("Sorry failed to delete values from the database table. " + e.getMessage());
            }
        }
        
        if("U".equals(request.getParameter("hidMode"))) {
            try {
                
 book.updateBook(new Integer(request.getParameter("hidBookID")),bookname,authorname,publishername,synopsis);
                 response.sendRedirect("/EnterpriseBookApp/BookServlet");
            } catch(Exception e) {
                out.println("Sorry failed to update values to the database table. " + e.getMessage());
            }
        }
        
        if("I".equals(request.getParameter("hidMode")) ){
           
            try {
                if(bookname.length() > 0 && synopsis.length() > 0 && authorname.length() > 0 && publishername.length() > 0) {
                    book.addBook(bookname,authorname,publishername,synopsis);
                   
                    response.sendRedirect("/EnterpriseBookApp/BookServlet");
                } else {
                    out.println("BookMaster details cannot be left blank.");
                }
            } catch(Exception e) {
                out.println("Sorry failed to insert values into the Database table. " + e.getMessage());
            }
        }
        
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<SCRIPT LANGUAGE='JavaScript'>");
        out.println("function setMode() {");
        out.println("document.frmBook.txtBookName.value='';");
        out.println("document.frmBook.txtSynopsis.value='';");
        out.println("document.frmBook.txtAuthorName.value='';");
        out.println("document.frmBook.txtPublisherName.value='';");
        out.println("}");
        
        out.println("function setDelMode()");
        out.println("{");
        out.println("document.frmBook.hidMode.value='D';");
        out.println("formDeleteValues('hidSelDel');");
        out.println("}");
        
        out.println("function formDeleteValues(hidden)");
        out.println("{");
        out.println("var selValues = '';");
        out.println("for (i=0;i<document.forms[0].elements.length;i++)");
        out.println("{");
        out.println("if(document.forms[0].elements[i].type == \"checkbox\")");
        out.println("{");
        out.println("if (document.forms[0].elements[i].checked == true) {");
        out.println("selValues = selValues + document.forms[0].elements[i].value + \",\";");
        out.println("}");
        out.println("}");
        out.println("}");
        out.println("if (selValues.length < 1)");
        out.println("{");
        out.println("alert(\"Please choose records you wish to delete.\");");
        out.println("}");
        out.println("else");
        out.println("{");
        out.println("selValues = selValues.substring(0,selValues.length-1);");
        out.println("eval(\"document.forms[0].\"+hidden+\".value = '\" +selValues+\"';\");");
        out.println("document.forms[0].submit();");
        out.println("}");
        out.println("}");
        
        out.println("function setEditMode(BookID,BookName, Synopsis, AuthorName, PublisherName)");
        out.println("{");
        out.println("document.frmBook.hidBookID.value = BookID;");
        out.println("document.frmBook.txtBookName.value = BookName;");
        out.println("document.frmBook.txtSynopsis.value = Synopsis;");
        out.println("document.frmBook.txtAuthorName.value = AuthorName;");
        out.println("document.frmBook.txtPublisherName.value = PublisherName;");
        out.println("document.frmBook.hidMode.value='U';");
        out.println("}");
        
        out.println("</SCRIPT>");
        out.println("<TITLE>Book Master Form</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='pink'>");
        out.println("<FORM ACTION='/EnterpriseBookApp/BookServlet' METHOD='post' NAME='frmBook'>");
        out.println("<INPUT NAME='hidMode' TYPE='hidden' VALUE='I'>");
        out.println("<INPUT NAME='hidSelDel' TYPE='hidden'>");
        out.println("<INPUT NAME='hidBookID' TYPE='hidden'>");
        out.println("<TABLE ALIGN='center' BGCOLOR='pink' BORDER='0' CELLPADDING='0' CELLSPACING='0' NAME='tblouter' WIDTH='50%'>");
        out.println("<TR HEIGHT='200' VALIGN='top'>");
        out.println("<TD ALIGN='center' COLSPAN='10'>");
        out.println("<TABLE ALIGN='center' BGCOLOR='pink' BORDER='1' BORDERCOLOR='maroon' CELLPADDING='2' CELLSPACING='0' NAME='tblFirstChild' WIDTH='100%'>");
        out.println("<TR>");
        out.println("<TD ALIGN='left' COLSPAN='2' BGCOLOR='maroon'>");
        out.println("<FONT COLOR='pink'>Book Master</FONT>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD ALIGN='right' WIDTH='25%'>Book Name</TD>");
        out.println("<TD ALIGN='left'>");
        out.println("<INPUT MAXLENGTH='35' NAME='txtBookName' TYPE='text' SIZE='25'>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD ALIGN='right' WIDTH='25%'>Synopsis</TD>");
        out.println("<TD ALIGN='left'>");
        out.println("<INPUT MAXLENGTH='255' NAME='txtSynopsis' TYPE='text' SIZE='42'>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD ALIGN='right' WIDTH='25%'>Author Name</TD>");
        out.println("<TD ALIGN='left'>");
        out.println("<INPUT MAXLENGTH='255' NAME='txtAuthorName' TYPE='text' SIZE='42'>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD ALIGN='right' WIDTH='25%'>Publisher Name</TD>");
        out.println("<TD ALIGN='left'>");
        out.println("<INPUT MAXLENGTH='255' NAME='txtPublisherName' TYPE='text' SIZE='20'>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='cmdSubmit' TYPE='submit' VALUE='Save'>");
        out.println("<INPUT NAME='cmdCancel' onclick='setMode();' TYPE='button' VALUE='Cancel'>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        
        if(book != null) {
            try {
           // List<BookMaster> list = (List<BookMaster>) book.getAllBooks();
            List<BookMaster> list = book.getAllBooks();

            out.println("<TABLE ALIGN='center' BORDER='1' BORDERCOLOR='skyblue' CELLPADDING='0' CELLSPACING='0' WIDTH='50%' NAME='tblSecondChild'>");
                out.println("<TR BGCOLOR='black'>");
                out.println("<TD WIDTH='12%' ALIGN='center'><INPUT NAME='cmdDelete' TYPE='button' VALUE='Delete' onClick='setDelMode();'></TD>");
                out.println("<TD><FONT COLOR='#FFFFFF'>Book Name</FONT></TD>");
                out.println("<TD><FONT COLOR='#FFFFFF'>Synopsis</FONT></TD>");
                out.println("<TD><FONT COLOR='#FFFFFF'>Author Name</FONT></TD>");
                out.println("<TD><FONT COLOR='#FFFFFF'>Publisher Name</FONT></TD>");
                out.println("</TR>");
              // Iterator it=list.iterator();
               // if(it != null) {
                    
                    //while(it.hasNext()) {
                    for(BookMaster bm : list) {
                      //  entity.BookMaster bm= (entity.BookMaster)it.next();
                       // BookMaster bm= (BookMaster)it.next();

                        out.println("<TR>");
                        out.println("<TD><INPUT TYPE='checkbox' NAME='chk" +  bm.getBookID() +"' VALUE='"+bm.getBookID()+"'></TD>");
                        out.println("<TD STYLE=\"cursor:pointer\" onMouseDown=\"setEditMode('" + bm.getBookID() + "', '" + bm.getBookName() + "', '" + bm.getSynopsis() + "', '" + bm.getAuthorName() + "', '" + bm.getPublisherName() + "');\">" + bm.getBookName() + "</TD>");
                        out.println("<TD STYLE=\"cursor:pointer\" onMouseDown=\"setEditMode('" + bm.getBookID() + "', '" + bm.getBookName() + "', '" + bm.getSynopsis() + "', '" + bm.getAuthorName() + "', '" + bm.getPublisherName() + "');\">" +  bm.getSynopsis() + "</TD>");
                        out.println("<TD STYLE=\"cursor:pointer\" onMouseDown=\"setEditMode('" + bm.getBookID() + "', '" + bm.getBookName() + "', '" + bm.getSynopsis() + "', '" + bm.getAuthorName() + "', '" + bm.getPublisherName() + "');\">" + bm.getAuthorName() + "</TD>");
                        out.println("<TD STYLE=\"cursor:pointer\" onMouseDown=\"setEditMode('" + bm.getBookID() + "', '" + bm.getBookName() + "', '" + bm.getSynopsis() + "', '" + bm.getAuthorName() + "', '" + bm.getPublisherName() + "');\">" + bm.getPublisherName() + "</TD>");
                        out.println("</TR>");
                    }
              //  }
                out.println("</TABLE>");
                
            } catch(Exception e) {
                out.println("Sorry Failed to execute the query. " + e.getMessage());
                e.printStackTrace();
            }
        }
        out.println("</FORM>");
       out.println("<a href='logout.jsp'>Log out </a>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
    }




}
