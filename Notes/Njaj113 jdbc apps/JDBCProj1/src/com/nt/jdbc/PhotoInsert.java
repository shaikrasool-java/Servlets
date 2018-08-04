package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoInsert {
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String name=null,photoPath=null;
		float salary=0.0f;
		File file=null;
		InputStream is=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
			System.out.println("Enter no:");
			no=sc.nextInt();
			
			System.out.println("Enter name:");
			name=sc.next();
			
			System.out.println("Enter Salary");
			salary=sc.nextFloat();
			
			System.out.println("Enter photo path");
			photoPath=sc.next();
			}//if
			//create InputSTream by locating file based on photoPath
			file=new  File(photoPath);
			is=new FileInputStream(file);
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		/*	//register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj113db1","root", "root");
			*/
			// create PreparedStatement obj
			if(con!=null)
				ps=con.prepareStatement("insert into empall values(?,?,?,?)");
		    //set values to query params
			if(ps!=null){
			   ps.setInt(1,no);
			   ps.setString(2,name);
			   ps.setFloat(3,salary);
			   ps.setBinaryStream(4,is,file.length());
			}
			//execute the SQL Query
			if(ps!=null)
			 result=ps.executeUpdate();
			//process the reuslt
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

