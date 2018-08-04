package com.nt.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.nt.jdbc.AllStmtsTest.MyWindowAdapter;

public class ScrollFrame extends JFrame  implements ActionListener{
	private JLabel lno,lname,laddrs;
	private JTextField tno,tname,taddrs;
	private JButton bfirst,blast,bnext,bprevious;
	private  Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	//constructor
	public ScrollFrame(){
		System.out.println("Constructor");
		setTitle("ScrollFrame Navigation App");
		setSize(300,300);
		setLayout(new FlowLayout());
		//add comps
		lno=new JLabel("student no");
		add(lno);
		tno=new JTextField(10);
		add(tno);
		
		lname=new JLabel("student name");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		laddrs=new JLabel("student address");
		add(laddrs);
		taddrs=new JTextField(10);
		add(taddrs);
		
		bfirst=new JButton("first");
		bfirst.addActionListener(this);
		add(bfirst);
		
		blast=new JButton("last");
		blast.addActionListener(this);
		add(blast);
		
		bnext=new JButton("next");
		bnext.addActionListener(this);
		add(bnext);
		
		bprevious=new JButton("previous");
		bprevious.addActionListener(this);
		add(bprevious);
		
		setVisible(true);
		makeConnection();
		addWindowListener(new MyWindowAdapter());
	}//constructor
	
	private void makeConnection(){
		System.out.println("makeConnection()");
		try{
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//create pepared Statment obj
			if(con!=null)
				ps=con.prepareStatement("select * from student",
				                                     ResultSet.TYPE_SCROLL_SENSITIVE,
				                                     ResultSet.CONCUR_READ_ONLY);
				//create Scrollable ResultSet obj
			 if(ps!=null)
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
		System.out.println(ae.getActionCommand());
		System.out.println("actionPerformed(-)");
		boolean flag=false;
		try{
		if(ae.getSource()==bfirst){
			System.out.println("first button");
			rs.first();
			flag=true;
		}
		else if(ae.getSource()==blast){
			System.out.println("last button");
			rs.last();
			flag=true;
		}
		else if(ae.getSource()==bnext){
			System.out.println("next button");
			if(!rs.isLast()){
				rs.next();
				flag=true;
			}//if
		}//else
		else{
			System.out.println("previous button");
			if(!rs.isFirst()){
				rs.previous();
				flag=true;
			}//if
		}//else
		
		//set record values to text boxes
		if(flag==true){
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			taddrs.setText(rs.getString(3));
		}//if
	 }//try
    catch(SQLException e){
    	e.printStackTrace();
    }
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public class MyWindowAdapter extends WindowAdapter{
		
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowclosing(-)");
			//close jdbc objs
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			System.exit(0);
		}//windowclosing(-)
	}//inner class
	public static void main(String[] args) {
		System.out.println("main(-)  method");
		 ScrollFrame frame=new ScrollFrame();
	}

}
