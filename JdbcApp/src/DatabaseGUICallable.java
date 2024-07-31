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


class DatabaseGUICallable extends Frame implements ActionListener
{

	// Declaration of GUI Components
	
	Label leno,lename,lsal,lgrosssal,lmaxsal;
	TextField teno,tename,tsal;
	Button badd,bsave,bdel,bprev,bnext,bfirst,blast, bcancel;

	// Declaration of Database Components

	Connection con;	
	ResultSet rs; Statement st, insert, delete;

	// Constructor
	public DatabaseGUICallable()
	{
	setLayout(new FlowLayout());
	leno=new Label("Emp No");
	lename=new Label("Ename");
	lsal=new Label("salary");
	lgrosssal=new Label();
	lmaxsal=new Label();
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
	add(lgrosssal); add(lmaxsal);

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
		
             						
		con= DriverManager.getConnection("jdbc:mysql://localhost/test?useSSL=false","root","ompandey");

		 //Connection con= DriverManager.getConnection("jdbc:odbc:testdsn","root","");		

	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		refresh();
                refreshStats();
		

}
catch(Exception exp){ 
//exp.printStackTrace();
}
	

}

private void refresh()
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

private void populateFields()
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
		
	new DatabaseGUICallable();

	
	}

private void refreshStats() throws SQLException
{
CallableStatement cstmt = con.prepareCall("{call gross_sal(?)}");

cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);

ResultSet rs1 = cstmt.executeQuery();
// . . . retrieve result set values with rs.getter methods
double x = cstmt.getDouble(1);
lgrosssal.setText("Gross Sal: "+ Double.toString(x));
rs1.close();

CallableStatement cstmt1 = con.prepareCall(
                                     "{?=call maxsal()}");
cstmt1.registerOutParameter(1, java.sql.Types.DOUBLE);
cstmt1.execute();

double msal= cstmt1.getDouble(1);
lmaxsal.setText("Max Sal: "+ Double.toString(msal));

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
		refreshStats();
	}
	
	else if(b==bsave)
	{
		insert =  con.createStatement();
		String inquery="insert into employee values ("+teno.getText()+",'"+tename.getText()+"',"+ tsal.getText()+")";
		insert.executeUpdate(inquery); 
		refresh();
		refreshStats();
	}
	
	else if(b==bdel)
	{
		delete =  con.createStatement();
		String delquery="delete from employee where empno= "+teno.getText()+"";
		delete.executeUpdate(delquery);
		refresh();
		refreshStats();
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

catch(Exception eany) {System.out.println(eany.toString());}


	} //listener method ends

}