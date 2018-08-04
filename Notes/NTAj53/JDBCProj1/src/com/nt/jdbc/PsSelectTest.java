package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PsSelectTest {
	public static void main(String[] args)throws Exception {
		
		//registr Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		//Execute select Query
		PreparedStatement ps=con.prepareStatement("select * from student where ?>=?");
		ps.setString(1,"sno");
		ps.setInt(2,100);
		ResultSet rs=ps.executeQuery();
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}//while
		
		//close jdbc objs
		rs.close();
		ps.close();
		con.close();
	}
	

}
