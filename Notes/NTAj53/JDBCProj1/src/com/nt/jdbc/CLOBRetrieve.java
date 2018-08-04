package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CLOBRetrieve {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		// get CLOB value to ResultSet
		PreparedStatement ps=con.prepareStatement("select * from studentall where sno=?");
		//set param value
		ps.setInt(1, no);
		//execute the Query
		ResultSet rs=ps.executeQuery();
		//process the ResultSet
		Reader reader=null;
		if(rs.next()){
			reader=rs.getCharacterStream(4);
		}
		else{
			System.out.println("Record not found");
		}
		//create Writer STream pointing to Dest file
		Writer writer=new FileWriter("newResume.txt");
		//writer buffer based logic
		int charsRead=0;
		char buffer[]=new char[1024];
		while((charsRead=reader.read(buffer))!=-1){
			writer.write(buffer,0,charsRead);
		}
		System.out.println("Resume Retrieved Successfully");
		//close streams
		writer.close();
		reader.close();
		rs.close();
		ps.close();
		con.close();
	}//main
}//class
