package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginApp1 {

	public static void main(String[] args) {
		 Scanner sc=null;
		 String user=null,pass=null;
		 Connection con=null;
		 ResultSet rs=null;
		 PreparedStatement ps=null;
		 String query=null;
		 int count=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter username:");
				user=sc.nextLine(); //gives raja
				System.out.println("Enter password:");
				pass=sc.nextLine(); // gives rani
			}
				//register jdbc driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Establish the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				//prepare SQL Query
				query="select count(*) from userlist where uname=? and pwd=?";
				if(con!=null)
				   ps=con.prepareStatement(query);
				//set param values 
				if(ps!=null){
				ps.setString(1,user);
				ps.setString(2,pass);
				}
				
				//send and execute the SQL Query
				if(ps!=null)
				  rs=ps.executeQuery();
				if(rs!=null){
				  if(rs.next()){
					count=rs.getInt(1);
				 }
				}
				if(count==0)
					 System.out.println("Invalid Credentials");
				else
					System.out.println("Valid Credentials");
			
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
		}//finally
		
		}//main
	}//class
