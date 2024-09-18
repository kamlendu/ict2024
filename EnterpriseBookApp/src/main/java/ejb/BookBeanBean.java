/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.BookMaster;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
//import com.mysql.jdbc.Driver;


/**
 *
 * @author root
 */

@Stateless 

public class BookBeanBean implements BookBeanLocal {

    Connection con;
    Statement stmt;
    String query;
    ResultSet rs;

  @PostConstruct
   void connect()
    {
        try {
            
            // Load Driver in Memeory
            
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish Connection to Database
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","ompandey");
            
                     
        }
        
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Driver class not found");
        }
        catch (SQLException se)
        {
            System.out.println("Connection Could not be Established");
        }
        
        
    }
   
   
   @Override
   public List<BookMaster> getAllBooks()
    {
         //List a=null ;
     List    a = new ArrayList();
        try{
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
        query = "select * from BookMaster";
        
        rs = stmt.executeQuery(query);
        
        ResultSetMetaData rmeta = rs.getMetaData();
        
      
        while(rs.next())
        {
       
            BookMaster b = new BookMaster(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
             b.setBookID(rs.getInt(5));
            a.add(b);
        //    System.out.println("\n"+rs.getString(1) + "\t"+rs.getString(2)+ "\t"+rs.getString(3));
       
        }
        
       }
        catch(SQLException sq)
        {
            sq.printStackTrace();
        }
        return a;
    }
    
   @Override
    public void addBook(String bookName,String authorName,String publisherName, String synopsis)
    {
        
        String insert = "insert into BookMaster(BookName,AuthorName,PublisherName,Synopsis) values('"+bookName+"','"+authorName+"','"+publisherName+"','"+synopsis+"')";
        try{
            
            Statement instmt = con.createStatement();
            instmt.executeUpdate(insert);
            
        }
        catch(SQLException sqi)
        {
            sqi.printStackTrace();
        }
    }
    
    @Override
    public void updateBook(Integer BookID,String bookName,String authorName,String publisherName, String synopsis)
    {
        
       String updatequery = "update BookMaster set BookName='"+bookName+"',AuthorName='"+authorName+"',PublisherName='"+publisherName+"',Synopsis='"+synopsis+"' where BookID="+ BookID.intValue();
        try{
            
            Statement updt = con.createStatement();
            updt.executeUpdate(updatequery);
            
        }
        catch(SQLException sqi)
        {
            sqi.printStackTrace();
        }
    }
    
    @Override
    public void removeBook(Integer BookID)
    {
        
        String delete = "delete from BookMaster where BookID="+BookID.intValue();
        try{
            
            Statement instmt = con.createStatement();
            instmt.executeUpdate(delete);
            
        }
        catch(SQLException sqi)
        {
            sqi.printStackTrace();
        }
        
        
    }    
    

}