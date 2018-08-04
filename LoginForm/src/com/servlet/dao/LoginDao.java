package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public static boolean validate(String name,String password){
		boolean status=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("connection established");
			PreparedStatement ps=con.prepareStatement("select*from employee where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			System.out.println("i am resultset"+rs);
			status=rs.next();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
				
		return status;
		
		
	}
	
}
