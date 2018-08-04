package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TxtTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:txtdsn");
		/*	//create Stattment obj
			if(con!=null)
			   st=con.createStatement();
			//send and execute SQL Query
			if(st!=null){
				rs=st.executeQuery("select * from file1.csv");
			}
			//process the ReultSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
				}//while
			}//if */
			PreparedStatement ps=con.prepareStatement("insert into file1.csv values(?,?,?)");
			ps.setInt(1,1001); ps.setString(2,"mahesh"); ps.setString(3, "vizag");
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
