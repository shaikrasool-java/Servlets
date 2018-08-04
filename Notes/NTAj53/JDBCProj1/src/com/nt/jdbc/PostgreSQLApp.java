package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLApp{
	public static void main(String[] args)throws Exception {
		 //register jdbc driver
		Class.forName("org.postgresql.Driver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:postgresql:ntaj53db","postgres","tiger");
		//create Statement obj
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                             ResultSet.CONCUR_UPDATABLE);
		//create ResultSet obj
		ResultSet rs=st.executeQuery("Select * from product");
		//process the ResultSet
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}
}
