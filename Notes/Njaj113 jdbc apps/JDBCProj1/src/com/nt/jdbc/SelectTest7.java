package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest7 {
	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		 int count=0;
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create STaement obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query in DB s/w
			if(st!=null)
				rs=st.executeQuery("select count(*) from emp");
			//process the ResultSet
			if(rs!=null){
				if(rs.next()){
					count=rs.getInt("count(*)");
				}//if
			}//if
			
			System.out.println("Records count"+count);
		}//try
		catch(SQLException se){  //known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){ //known Exception
			cnf.printStackTrace();
		}
		catch(Exception e){  // unknown Exception
			e.printStackTrace();
		}
		finally{
			//close objs
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
