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
public class OptimizedDBApp {
    
    Connection con;

    public OptimizedDBApp() {
        
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
        
        OptimizedDBApp app = new OptimizedDBApp();
    // app.addEmployee(9,"Kalpesh", 9500.00);
      //app.addEmployee(10,"Vishal", 9500.00);
     //app.addEmployee(11,"Sapna", 9500.00);
    
     
   //app.removeEmployee(9);
        app.showAllEmployees();
        
         System.out.println("Gross Salary = " + app.getGrossSalary()); 
         System.out.println("Max Salary = " + app.getMaxSalary()); 
     
        
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
     PreparedStatement insert;
     try {
    
    String inquery = "insert into employee values(?,?,?)";
    
     insert = con.prepareStatement(inquery);
   
     insert.setInt(1,empno);
    insert.setString(2, empName);
    insert.setDouble(3, salary);
     
    insert.executeUpdate();
     
     }
     catch(SQLException sqe)
     {
        System.out.println("Could not insert record..."); 
     }
 }
    
   void removeEmployee(int empno)
 {
     PreparedStatement delstmt;
     try {
     
    String delquery = "delete from employee where empno = ?";
    
    delstmt= con.prepareStatement(delquery);
    delstmt.setInt(1, empno);
    delstmt.executeUpdate();
     
     }
     catch(SQLException sqe)
     {
        System.out.println("Could not delete record..."); 
     }
 } 
   
   double getGrossSalary()
   {
       
       double gross=0.0;
       
       try{
       CallableStatement csmt = con.prepareCall("{call gross_sal(?)}");
       csmt.registerOutParameter(1, java.sql.Types.DOUBLE);
       ResultSet rs = csmt.executeQuery();
       gross = csmt.getDouble(1);
      //  System.out.println("Gross Total Salary = "+ rs.getDouble(1)); 
     }
       
       catch(SQLException sqe)
       {
          sqe.printStackTrace();
       }
       
       
       
       return gross;
   }
   
   double getMaxSalary()
   {
       
       double maxsal=0.0;
       
       try{
       CallableStatement csmt = con.prepareCall("{?=call maxsal()}");
       csmt.registerOutParameter(1, java.sql.Types.DOUBLE);
       csmt.execute();
       maxsal = csmt.getDouble(1);
      //  System.out.println("Gross Total Salary = "+ rs.getDouble(1)); 
     }
       
       catch(SQLException sqe)
       {
          sqe.printStackTrace();
       }
       
       
       
       return maxsal;
   }
}
