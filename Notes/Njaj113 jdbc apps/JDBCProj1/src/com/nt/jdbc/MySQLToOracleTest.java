package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLToOracleTest {
  public static void main(String[] args) {
	  Connection oraCon=null;
	  Connection mysqlCon=null;
	  Statement st=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  int no=0;
	  String name=null,addrs=null;
	  
	  
	  try{
		  //register jdbc drivers
		  Class.forName("com.mysql.jdbc.Driver");
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //Establish the connections
		  oraCon=
				  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  mysqlCon=
				  DriverManager.getConnection("jdbc:mysql:///ntaj113db1","root","root");
		  //create Statement objs
		  if(mysqlCon!=null)
			  st=mysqlCon.createStatement();
		  if(oraCon!=null)
			  ps=oraCon.prepareStatement("insert into student values(?,?,?)");
		  // Exceute SQL Query and get ResultSet (mysql)
		  if(st!=null)
			  rs=st.executeQuery("select * from student");
		   // copy recors
		  if(rs!=null){
			  while(rs.next()){
				  // Get each record from ResultSet obj(mysql)
				  no=rs.getInt(1);
				  name=rs.getString(2);
				  addrs=rs.getString(3);
				  // insert each record into Oracle Db table
				  ps.setInt(1,no);
				  ps.setString(2,name);
				  ps.setString(3,addrs);
				  ps.executeUpdate();
			  }//while
			  System.out.println("Records are copied....");
		  }//if
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
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(oraCon!=null)
					oraCon.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(mysqlCon!=null)
					mysqlCon.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	  }//main
 }//class
