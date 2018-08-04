package com.nt.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AllStmtsTest extends JFrame implements ActionListener {
	private JLabel lno,lname,lresult,lm1,lm2,lm3;
	private JTextField tname,tresult,tm1,tm2,tm3;
	private JComboBox tno;
	private JButton bdetails,bresult;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs1,rs2;
	
	public AllStmtsTest(){
		System.out.println("Constructor");
		setTitle("JDBC Mini Project");
		setSize(300,400);
		setLayout(new FlowLayout());
		//add comps
		lno=new JLabel("Sno");
		add(lno);
		tno=new JComboBox();
		add(tno);
		bdetails=new JButton("details");
		bdetails.addActionListener(this);
		add(bdetails);
		
		lname=new JLabel("sname");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		tname.setEditable(false);
		lm1=new JLabel("Marsk1");
		add(lm1);
		tm1=new JTextField(10);
		add(tm1);
		tm1.setEditable(false);
		lm2=new JLabel("Marsk2");
		add(lm2);
		tm2=new JTextField(10);
		add(tm2);
		tm2.setEditable(false);
		lm3=new JLabel("Marsk3");
		add(lm3);
		tm3=new JTextField(10);
		tm3.setEditable(false);
		add(tm3);
		
		bresult=new JButton("result");
		bresult.addActionListener(this);
		add(bresult);
		
		lresult=new JLabel("Result");
		add(lresult);
		tresult=new JTextField(10);
		add(tresult);
		tresult.setEditable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		myInit();
	}//constructor
	
	private void myInit(){
		System.out.println("myInit()");
		try{
			//register jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//create Statement obj
			st=con.createStatement();
			//write logic to get snos to combobox (Load on startup)
			rs1=st.executeQuery("select sno from All_student");
			while(rs1.next()){
				tno.addItem(rs1.getString(1));
			}//while
			rs1.close();
			st.close();
			//create PreparedStatement obj
			ps=con.prepareStatement("select * from All_student where sno=?");
			cs=con.prepareCall("{call FIND_PASS_FAIL(?,?,?,?)}");
			cs.registerOutParameter(4,Types.VARCHAR);
		
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
		
	}//myInit()

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("actionPerformed:"+ae.getActionCommand());
		if(ae.getSource()==bdetails){
			System.out.println("Details button is clicked");
			try{
				//get Selected item for ComboBox
				int no=Integer.parseInt((String)tno.getSelectedItem());
				//set value to query param (PreparedStatement)
				ps.setInt(1,no);
				//execute the Query
				rs2=ps.executeQuery();
				//set the record values of ResultSet to text boxes
				if(rs2.next()){
					tname.setText(rs2.getString(2));
					tm1.setText(rs2.getString(3));
					tm2.setText(rs2.getString(4));
					tm3.setText(rs2.getString(5));
				}//if
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//if
		else{
			System.out.println("Result Button in clicked");
			try{
				//read text box values and set them IN param values
				int m1=Integer.parseInt(tm1.getText());
				int m2=Integer.parseInt(tm2.getText());
				int m3=Integer.parseInt(tm3.getText());
				cs.setInt(1,m1); cs.setInt(2,m2); cs.setInt(3,m3);
				//call pl/sql procedure
				cs.execute();
				//Gather result from OUT param
				String result=cs.getString(4);
				//set result to text box
				tresult.setText(result);
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//else
	}//actionPerformed(-)
	
	public static void main(String[] args) {
		System.out.println("main(-) method");
		  AllStmtsTest  test=new AllStmtsTest();
	}

}
