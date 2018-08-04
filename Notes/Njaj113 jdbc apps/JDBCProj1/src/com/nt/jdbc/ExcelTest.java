package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelTest {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:odbc:xlsdsn");
		/*	//create Statement obj
			if(con!=null)
		    	st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				rs=st.executeQuery("select * from [Sheet1$]");
			//process the ReusltSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}//while
			}//if */
			//for Insert operation
			PreparedStatement ps=con.prepareStatement("insert into [Sheet1$] values(?,?,?)");
			ps.setInt(1,1002); ps.setString(2,"ravi1"); ps.setString(3,"hyd1");
			int result=ps.executeUpdate();
			System.out.println(result+" no.of records are inserted");
			
		}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
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
		
	}//main
}//class
