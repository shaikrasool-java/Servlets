package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableTest {
	public static void main(String[] args) throws Exception{
		//register driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		// create Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in DB s/w
		int count=st.executeUpdate("create table temp(no number(4))");
		//process the Result
		if(count==0)
			System.out.println("Table not creted");
		else
			System.out.println("Table Created");
		//close jdbc objs
		st.close();
		con.close();
	}//main
}//class
