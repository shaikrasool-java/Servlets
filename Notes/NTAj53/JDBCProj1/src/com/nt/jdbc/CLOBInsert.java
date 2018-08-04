package com.nt.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CLOBInsert {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt();
		System.out.println("Enter student name:");
		String name=sc.next();
		System.out.println("Enter student address");
		String addrs=sc.next();
		System.out.println("Enter resume doc location");
		String resumeLoc=sc.next();
		
//		//register jdbc driver
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//Establish the connection
//		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//register jdbc driver
				Class.forName("com.mysql.jdbc.Driver");
				//Establish the connection
				Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj53db1","root","root"); 
				
		
       //create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("insert into studentall values(?,?,?,?)");
       //Locate Resume file
		  File file=new File(resumeLoc);
		  Reader reader=new FileReader(file);
		  long length=file.length();
		  
		//set values to Query params
		ps.setInt(1,no); ps.setString(2,name);
		ps.setString(3,addrs); ps.setCharacterStream(4,reader,(int)length);
		//execute SQL Query
		int result=ps.executeUpdate();
		//process the result
		if(result==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		//close streams
		ps.close();
		reader.close();
		con.close();
	}//main
}//class

