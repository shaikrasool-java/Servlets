package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest7{
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//register jdbc driver (type1)
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create Statement obj
			if(con!=null)
			  st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				rs=st.executeQuery("select count(*) from emp");
			//process the ResultSet
			int cnt=0;
			if(rs.next())
				cnt=rs.getInt(1);
			System.out.println("Records count"+cnt);
		}//try
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception  e){
			e.printStackTrace();
		}
		finally{
			//Close jdbc objs
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
		
	}//main
}//class