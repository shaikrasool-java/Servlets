package com.nt.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOBRetrieve {
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reader  reader=null;
		Writer  writer=null;
		int no=0;
		char[] buffer=null;
		int charsRead=0;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter Employee no:");
				no=sc.nextInt();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		/*	Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///ntaj113db1","root","root");*/
			//create PreparedStatement obj
			if(con!=null)
			  ps=con.prepareStatement("select * from studentAll where sno=?");
			//set param value
			if(ps!=null){
			ps.setInt(1,no);
			//execute the SQL Query
			rs=ps.executeQuery();
			}
			//process the ResultSet (read BLOB value)
			if(rs.next()){
				reader=rs.getCharacterStream(4);
			}//if
			//create OuputStream for Dest file
			writer=new FileWriter("E:\\downloads\\d_resume.txt");
			//write buffer based logic to copy file content
			 buffer=new char[2048];
			while((charsRead=reader.read(buffer))!=-1){
				writer.write(buffer,0,charsRead);
			}//while
			System.out.println("CLOB Retrieved");
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
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
			try{
				if(reader!=null)
					reader.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
			try{
				if(writer!=null)
					writer.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
		
	}

}
