package com.nt.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PhotoRetrieve {
	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee no:");
		int no=sc.nextInt();
	/*	//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */

		//register jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj53db1","root","root"); 
		
		//create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("select * from empall where empno=?");
		//set query param value
		ps.setInt(1,no);
		//execute the Query
		ResultSet rs=ps.executeQuery();
		//process the ResultSet
		InputStream is=null;
		if(rs.next()){
			is=rs.getBinaryStream(4);
		}
		else{
			System.out.println("record not found");
		}
		//create OutputStream
		FileOutputStream os=new FileOutputStream("photo.jpg");
		
		//write buffer based logic
		int bytesRead=0;
		byte []buffer=new byte[4096];
		while((bytesRead=is.read(buffer))!=-1){
			os.write(buffer,0, bytesRead);
		}
		
		System.out.println("Photo is Retrieved Successfully");
		//close streams
		rs.close();
		ps.close();
		con.close();
		is.close();
		os.close();
		
	}//main
}//class

