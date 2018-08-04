package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelToOracleTest {

	public static void main(String[] args) {
		Connection oraCon=null;
		Connection xlsCon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int no=0;
		String sname=null,addrs=null;
		
		try{
			//register jdbc drivers
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connections
			oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			xlsCon=DriverManager.getConnection("jdbc:odbc:xlsdsn");
			//create Statment objs
			if(oraCon!=null)
				ps=oraCon.prepareStatement("insert into student values(?,?,?)");
			if(xlsCon!=null)
				st=xlsCon.createStatement();
			//execute the Select Query in Excel
			if(st!=null)
				rs=st.executeQuery("select * from [Sheet1$]");
			//process the ResultSet to copy to oracle DB table
			if(rs!=null && ps!=null){
				while(rs.next()){
					//get each record from ResultSet (Excel)
					no=rs.getInt(1);
					sname=rs.getString(2);
					addrs=rs.getString(3);
					//set each record values insert query param values
					ps.setInt(1, no);
					ps.setString(2,sname);
					ps.setString(3,addrs);
					//execute insert query
					ps.executeUpdate();
				}//while
				System.out.println("Records are copied");
			}//if
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
			catch(Exception se){
				se.printStackTrace();
			}
			try{
				if(xlsCon!=null)
					xlsCon.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class

