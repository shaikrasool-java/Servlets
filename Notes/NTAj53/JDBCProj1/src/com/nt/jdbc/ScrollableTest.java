package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScrollableTest {
	public static void main(String[] args) throws Exception{
        //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create PreparedStatement obj having type,mode
		PreparedStatement ps=con.prepareStatement("select * from student",
				                                                                                   1005,
				                                                                                   1008);
		//create JDBC ResultSet obj
		ResultSet rs=ps.executeQuery("select * from student");
		//process the ResulSet
		System.out.println("Records --> (top--bottom)");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		System.out.println("Records --> (bottom---top)");
		rs.afterLast();
		while(rs.previous()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		//first record
		rs.first();
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//Last record
		rs.last();
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	
		rs.absolute(4);
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	
		rs.absolute(-6);
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		rs.relative(-2);
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		rs.relative(5);
		System.out.println(rs.getRow()+"--->"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		
		//close jdbc objs
	    rs.close();
	    ps.close();
	    con.close();
	}//main
}//class

