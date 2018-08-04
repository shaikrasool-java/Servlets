package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PhotoInsert {
	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp no:");
		int no=sc.nextInt();
		System.out.println("Enter emp name:");
		String name=sc.next();
		System.out.println("Enter emp salary");
		int salary=sc.nextInt();
		System.out.println("Enter emp photo Location");
		String photoLocation=sc.next();

		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
		
//		//register jdbc driver
//		Class.forName("com.mysql.jdbc.Driver");
//		//Establish the connection
//		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj53db1","root","root"); 
//		
		//Create Statement obj
	PreparedStatement ps=con.prepareStatement("insert into empall values(?,?,?,?)");
	// Create InputStream reprsenting photo
	   File file=new File(photoLocation);
	   long length=file.length();
	   InputStream fis=new FileInputStream(file);
	  //set query param values
	   ps.setInt(1,no);
	   ps.setString(2,name);
	   ps.setInt(3,salary);
	   ps.setBinaryStream(4,fis,(int)length);
	   //execute the SQL Query
	   int result=ps.executeUpdate();
	   //process the result
	   if(result==0)
		   System.out.println("Record not inserted");
	   else
		   System.out.println("record inserted");
	   //close jdbc objs
	   ps.close();
	   con.close();
	   fis.close();
	}
}
