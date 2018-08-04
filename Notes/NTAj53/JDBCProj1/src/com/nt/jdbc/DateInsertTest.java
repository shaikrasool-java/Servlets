package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertTest {

	public static void main(String[] args)throws Exception {
		// read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter person no:");
		int no=sc.nextInt();
		System.out.println("Enter person name:");
		String name=sc.next();
		System.out.println("Enter DOB (dd-MM-yyyy)");
		String dob=sc.next();
		System.out.println("Enter DOJ (yyyy-MM-dd)");
		String doj=sc.next();
		//Convert date values to java.sql.Date class obj
		   // DOB
		      //to java.util.Date class obj
		  SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		  java.util.Date udob=sdf1.parse(dob);
		     // to java.sql.Date class obj
		    long ms=udob.getTime();
		    java.sql.Date sqdob=new java.sql.Date(ms);
		  //DOJ
		     //to java.sql.Date class obj
		    java.sql.Date sqdoj=java.sql.Date.valueOf(doj);
		
	/*	//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */
		    
		 	//register jdbc driver
			Class.forName("org.gjt.mm.mysql.Driver");
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj53db1","root","root");
		    
		//Create jdbc PreparedStatment obj
		PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?)");
		//set values to Query params
		ps.setInt(1,no);
		ps.setString(2,name);
		ps.setDate(3,sqdob);
		ps.setDate(4,sqdoj);
		//execute the SQL Query
		int result=ps.executeUpdate();
		//process the Result
		if(result==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		//close jdbc objs
		ps.close();
		con.close();
	}//main
}//class

