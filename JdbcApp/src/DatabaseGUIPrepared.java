/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


class DatabaseGUIPrepared extends Frame implements ActionListener
{

	// Declaration of GUI Components
	
	Label leno,lename,lsal;
	TextField teno,tename,tsal;
	Button badd,bsave,bdel,bprev,bnext,bfirst,blast, bcancel;

	// Declaration of Database Components

	Connection con;	
	ResultSet rs; Statement st;
	PreparedStatement insert, delete;

	// Constructor
	public DatabaseGUIPrepared()
	{
	setLayout(new FlowLayout());
	leno=new Label("Emp No");
	lename=new Label("Ename");
	lsal=new Label("salary");
	teno=new TextField(30);
	tename=new TextField(30);
	tsal=new TextField(30);
	badd=new Button("Add");
	bsave=new Button("Save");
	bdel=new Button("Delete");
	bprev=new Button("Previous");
	bnext=new Button("Next");
	bfirst=new Button("First");
	blast=new Button("Last");
	bcancel=new Button("Cancel");
	badd.addActionListener(this);
	bsave.addActionListener(this);
	bdel.addActionListener(this);
	bfirst.addActionListener(this);
	blast.addActionListener(this);
	bprev.addActionListener(this);
	bnext.addActionListener(this);
	bcancel.addActionListener(this);

	setSize(350,200);
	add(leno);    add(teno);
	add(lename);  add(tename);
	add(lsal);    add(tsal);
	add(badd);	add(bsave);   add(bdel);    add(bcancel);
	add(bfirst);	add(bprev);	add(bnext);	add(blast);
	
	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
	setVisible(true); 
	
	initializeDB();
	}



public void initializeDB()
	{
try{
	Class.forName("com.mysql.jdbc.Driver"); 
		
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
             		

				
		con= DriverManager.getConnection("jdbc:mysql://localhost/test","root","ompandey");

		 //Connection con= DriverManager.getConnection("jdbc:odbc:testdsn","root","");		

	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		refresh();
		

}
catch(Exception exp){ }
	

}

void refresh()
{
	try {
		rs = st.executeQuery("Select * from employee");
		rs.next();
		teno.setText(rs.getString(1));
		tename.setText(rs.getString(2));
		tsal.setText(rs.getString(3));

	}
	catch(Exception exp1) { }

}

void populateFields()
{
	try {
		teno.setText(rs.getString(1));
		tename.setText(rs.getString(2));
		tsal.setText(rs.getString(3));
	}
	catch(Exception ep) { }
}
	
// Main Method
	public static void main(String[] args) 
	{
		
	new DatabaseGUIPrepared();

	
	}

	public void actionPerformed(ActionEvent e)
	{
	Button b = (Button)e.getSource();
	try{
	if(b==badd) 
	{
	teno.setText("");  tename.setText("");   tsal.setText("");
	}
	else if(b==bcancel)
	{
		refresh();
	}
	
	else if(b==bsave)
	{
		
 String inquery="insert into employee values (?,?,?)";
		insert =  con.prepareStatement(inquery);
		insert.setInt(1,Integer.parseInt(teno.getText()));
		insert.setString(2,tename.getText());
		insert.setDouble(3,Double.parseDouble(tsal.getText()));
		insert.executeUpdate(); 
		refresh();
	}
	
	else if(b==bdel)
	{
		
		String delquery="delete from employee where empno= ?";

delete =  con.prepareStatement(delquery);		

delete.setInt(1,Integer.parseInt(teno.getText()));		
		delete.executeUpdate();
		refresh();
	}
	else if(b==bfirst)
	{
		rs.first();
		populateFields();
	}
	
	else if(b==blast)
	{
		rs.last();
		populateFields();
	}

	else if(b==bprev)
	{
		rs.previous();
		populateFields();
	}
	else if(b==bnext)
	{
		rs.next();
		populateFields();
	}


	
	}

catch(Exception eany) {}


	} //listener method ends

}
