package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsert {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String name=null,dob=null,doj=null;
		SimpleDateFormat sdf=null;
		java.util.Date udob=null;
		java.sql.Date sqdob=null, sqdoj=null;
		long ms=0;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter no:");
				no=sc.nextInt();
				System.out.println("Enter name");
				name=sc.next();
				System.out.println("Enter DOB(dd-MM-yyyy)");
				dob=sc.next();
			   System.out.println("Enter DOJ(yyyy-MM-dd)");
			   doj=sc.next();
			}
			//convert String date values to java.sql.Date class objs
			  //FOR DOB
			      sdf=new SimpleDateFormat("dd-MM-yyyy");
			      if(sdf!=null)
			         udob=sdf.parse(dob); //gives java.util.Date obj
			      
			      if(udob!=null)
			        ms=udob.getTime();
			      
			      sqdob=new java.sql.Date(ms); // gives java.sql.Date class obj
             //FOR DOJ
			      sqdoj=java.sql.Date.valueOf(doj);
			      
			   /*  //register jdbc driver
			      Class.forName("oracle.jdbc.driver.OracleDriver");
			      //Establish the connection
			      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
			      
			      Class.forName("org.gjt.mm.mysql.Driver");
			      //Establish the connection
			      con=DriverManager.getConnection("jdbc:mysql:///ntaj113db1","root","root");
			      
			      //create PreparedStatement obj
			      if(con!=null)
			    	  ps=con.prepareStatement("insert into person_tab values(?,?,?,?)");
			      //set value Query params
			      if(ps!=null){
			    	ps.setInt(1,no);
			    	ps.setString(2,name);
			    	ps.setDate(3,sqdob);
			    	ps.setDate(4,sqdoj);
			      }
			      //execute the Query
			      if(ps!=null)
			    	  result=ps.executeUpdate();
			      
			      //process the result
			      if(result==0)
			    	  System.out.println("Record not inserted");
			      else
			    	  System.out.println("Record inserted");
			}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
			System.out.println("Record insertion failed");
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
			System.out.println("Record insertion failed");
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
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
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class
