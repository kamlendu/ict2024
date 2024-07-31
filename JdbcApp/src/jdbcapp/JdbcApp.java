/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcapp;

import java.sql.*;
/**
 *
 * @author root
 */
public class JdbcApp {
    
    Connection con;

    public JdbcApp() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root","ompandey");
            System.out.println("Connection Established...");
       
        }
        catch(ClassNotFoundException clnf)
        {
            System.out.println("Driver class Not Found...");
        }
        catch(SQLException sqle)
        {
            System.out.println("Connection Failed to Establish...");
       
        }
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JdbcApp app = new JdbcApp();
     //  app.addEmployee(9,"Kalpesh", 9500.00);
      //  app.removeEmployee(9);
        app.showAllEmployees();
        
    }
    
    private void showAllEmployees()
    {
        try {
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from employee");
        
        ResultSetMetaData rmeta = rs.getMetaData();
        
        for(int i=1; i<=rmeta.getColumnCount();i++)
        {
            System.out.print(rmeta.getColumnName(i)+ "\t");
        }
        System.out.println();
        while(rs.next())
        {
             for(int i=1; i<=rmeta.getColumnCount();i++)
        {
            System.out.print(rs.getString(i)+ "\t");
        }
            System.out.println();
         
        }
        rs.close();
        }
        catch(SQLException se)
        {
             System.out.println("SQL Error...");
        }
        
    }
    
 void addEmployee(int empno, String empName, double salary)
 {
     Statement insert;
     try {
     insert = con.createStatement();
    String inquery = "insert into employee values("+empno+",'"+empName+"',"+salary+")";
     insert.executeUpdate(inquery);
     
     }
     catch(SQLException sqe)
     {
        System.out.println("Could not insert record..."); 
     }
 }
    
   void removeEmployee(int empno)
 {
     Statement delstmt;
     try {
     delstmt = con.createStatement();
    String delquery = "delete from employee where empno = "+empno;
     delstmt.executeUpdate(delquery);
     
     }
     catch(SQLException sqe)
     {
        System.out.println("Could not delete record..."); 
     }
 } 
}
