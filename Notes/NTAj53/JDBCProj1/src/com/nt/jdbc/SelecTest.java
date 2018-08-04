package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelecTest {
	public static void main(String[] args)throws Exception {
		 //register jdbc driver
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj
		Statement st=con.createStatement();
		//create ResultSet obj
		ResultSet rs=st.executeQuery("Select sno,sname,sadd from student");
		//process the ResultSet
		while(rs.next()){
			
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		
	}

}
