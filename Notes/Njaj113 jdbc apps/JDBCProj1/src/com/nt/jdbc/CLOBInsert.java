package com.nt.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOBInsert {
	public static void main(String[] args) {
		int no=0;
		String name=null;
		String addrs=null;
		String resumePath=null;
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		Reader reader=null;
		File file=null;
		int result=0;
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter no:");
				no=sc.nextInt();
				System.out.println("Enter name");
				name=sc.next();
				System.out.println("Enter Address");
				addrs=sc.next();
				System.out.println("Enter resume Path");
				resumePath=sc.next();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj
			if(con!=null)
			 ps=con.prepareStatement("insert into studentAll values(?,?,?,?)");
			//create Reader obj hold resume (CLOB value)
			file=new File(resumePath);
			reader=new FileReader(file);
			//set values to query params
			if(ps!=null){
				ps.setInt(1,no); 
				ps.setString(2,name);
				ps.setString(3,addrs);
				ps.setCharacterStream(4,reader,(int)file.length());
			}
			//execute the Query
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
			try{
				if(reader!=null)
					reader.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
	
	}

}
