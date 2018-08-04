package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type5Test {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//registr jdbc driver
			Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;ServiceName=xe","system","manager");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query
			if(st!=null)
				rs=st.executeQuery("select * from student");
			//process the Reuslt
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}//while
			}//if
			
		}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
		
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
		
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
			
		}//finally
	}
}
