package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FlexibleTest {
	public static void main(String[] args) {
		 InputStream is=null;
		 Properties props=null;
		 String driver=null,url=null,dbuser=null,dbpwd=null;
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		try{
		//locate properties file
			is=new FileInputStream("src/com/nt/commons/DBDetails.properties");
		//Load properies file data into java.util.Properites class obj
			props=new Properties();
			props.load(is);
		// read jdbc properties from properties file
			driver=props.getProperty("jdbc.driver");
			url=props.getProperty("jdbc.url");
			dbuser=props.getProperty("jdbc.user");
			dbpwd=props.getProperty("jdbc.pwd");
		//register jdbc driver
			 Class.forName(driver);
			//estalish the connection
			 con=DriverManager.getConnection(url, dbuser,dbpwd);
			 //create Statement 
			 if(con!=null)
				 st=con.createStatement();
			 //send and execute SQL Query in Db s/w
			 if(st!=null)
				 rs=st.executeQuery("select * from student");
			 if(rs!=null){
				 while(rs.next()){
					 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				 }//while
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
			catch(Exception se){
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
		}//finally
		
	}//main
}//class
