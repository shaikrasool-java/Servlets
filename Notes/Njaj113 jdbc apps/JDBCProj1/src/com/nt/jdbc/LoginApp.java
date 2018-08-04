package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		 Scanner sc=null;
		 String user=null,pass=null;
		 Connection con=null;
		 ResultSet rs=null;
		 Statement st=null;
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
			//convert input values as requuired for the SQL query
			user="'"+user+"'"; //gives 'raja'
			pass="'"+pass+"'";//gives 'rani'
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//create Statement obj
			if(con!=null)
			 st=con.createStatement();
			//prepare SQL query
			   //select count(*) from userlist where uname='raja' and pwd='rani'
			  query="select count(*) from userlist where uname="+user+" and pwd="+pass;
			  System.out.println(query);
			  //execute The Query
			  if(st!=null)
			    rs=st.executeQuery(query);
			  //process the ResultSet
			  if(rs!=null){
				  if(rs.next())
				     count=rs.getInt(1);
				  System.out.println(count);
			  }
			  if(count==0)
				  System.out.println("InValid Credentials");
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
				if(st!=null)
					st.close();
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
