package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrame extends JFrame implements ActionListener {
  private JLabel lno,lname,ladd;
  private JTextField tno,tname,tadd;
  private JButton  bfirst,blast,bnext,bprevious;
  private ResultSet rs;
  
  public ScrollFrame() {
	  System.out.println("Constructor");
	  setTitle("Scroll Frame App");
	  setBackground(Color.green);
	  setSize(300,300);
	  setLayout(new FlowLayout());
	  //add comps
	  lno=new JLabel("Student no:");
	  add(lno);
	  tno=new JTextField(10);
	  add(tno);
	  
	  lname=new JLabel("Student name:");
	  add(lname);
	  tname=new JTextField(10);
	  add(tname);
	  
	  ladd=new JLabel("Student Addrs:");
	  add(ladd);
	  tadd=new JTextField(10);
	  add(tadd);
	  
	  bfirst=new JButton("first");
	  bfirst.addActionListener(this);
	  add(bfirst);
	  
	  bnext=new JButton("Next");
	  bnext.addActionListener(this);
	  add(bnext);
	  
	  bprevious=new JButton("Previous");
	  bprevious.addActionListener(this);
	  add(bprevious);
	  
	  blast=new JButton("Last");
	  blast.addActionListener(this);
	  add(blast);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	  makeConnection();
  }//constructor
  
  private void makeConnection(){
	  System.out.println("makeConnection()");
	   //create ScrollableResultSet obj
	   try{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
       	   PreparedStatement ps=con.prepareStatement("select * from student",
       			                                                                                      ResultSet.TYPE_SCROLL_SENSITIVE,
       			                                                                                      ResultSet.CONCUR_UPDATABLE);
       	   rs=ps.executeQuery();
	   }//try
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(ClassNotFoundException cnf){
		   cnf.printStackTrace();
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }//makeConnection()
  

	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
		System.out.println("actionPerformed(-)");
		boolean isMoved=false;
		if(ae.getSource()==bfirst){
			System.out.println("first button");
			rs.first();
			isMoved=true;
		}
		else if(ae.getSource()==bnext){
			System.out.println("next button");
			if(!rs.isLast()){
				rs.next();
				isMoved=true;
			}
		}
		else if(ae.getSource()==bprevious){
			System.out.println("previous Button");
			if(!rs.isFirst()){
				rs.previous();
				isMoved=true;
			}
		}
		else{
			System.out.println("last Button");
			rs.last();
			isMoved=true;
		}
		//set values toTextboxes
		if(isMoved==true){
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			tadd.setText(rs.getString(3));
		}//if
	}//try
   catch(SQLException se){
	   se.printStackTrace();
   }
  catch(Exception e){
	 e.printStackTrace();
   }
}//actionPerformed(-)
	
	public static void main(String[] args) {
		System.out.println("main(-)");
		  ScrollFrame frame=new ScrollFrame();
		
	}
	

}
