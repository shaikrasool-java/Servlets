package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnPoolTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		OracleConnectionPoolDataSource ds=null;
		ResultSet rs=null;
		try{
			//Create DataSoruce obj representing empty jdbc con pool
			ds=new OracleConnectionPoolDataSource();
			if(ds!=null){
			//set jdbc properties to Datasoruce obj to create con objs in the con pool
			ds.setDriverType("thin");
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("manager");
			// get con obj from jdbc con pool through Datasource obj
			con=ds.getConnection();
			}
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query
			if(st!=null){
				rs=st.executeQuery("select * from student");
			}
			//process the ResultSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3));
				}//while
			}//if
		}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
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
			try{
				if(ds!=null)
					ds.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
	}//finally
		
  }//mian
}//class
