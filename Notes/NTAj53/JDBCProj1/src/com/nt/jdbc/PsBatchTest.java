package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class PsBatchTest {

	public static void main(String[] args) throws Exception{
		//register jdbc driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		//Create PreparedStatement obj
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
		 ps.setInt(1,2331);
		 ps.setString(2,"rajesh");
		 ps.setString(3,"hyd");
		 ps.addBatch();  //adds 1st set values to the Batch
		 ps.setInt(1,3331);
		 ps.setString(2,"mahesh");
		 ps.setString(3,"vizag");
		 ps.addBatch();  //adds 2nd set values to the Batch
		//execute the batch
		 int result[]=ps.executeBatch();
		 // display batch results
		 System.out.println("result:::"+Arrays.toString(result));
		 //close jdbc objs
		 ps.close();
		 con.close();
	}//main
}//class
