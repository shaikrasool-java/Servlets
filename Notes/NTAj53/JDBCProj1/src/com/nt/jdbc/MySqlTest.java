package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlTest {
	public static void main(String[] args)throws Exception {
		 //register driver
		   //Class.forName("org.gjt.mm.mysql.Driver");
		    Class.forName("com.mysql.jdbc.Driver");
		  //establish the connection
		  //Connection con=
		      //      DriverManager.getConnection("jdbc:mysql:///ntaj53db","root","root");
		    Connection con=
				            DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj53db1","root","root");
		    
		 //create Statement obj
		  Statement st=con.createStatement();
		  //Send and execute SQL Query in Db s/w
		  ResultSet rs=st.executeQuery("select * from product");
		  //process the ResultSet
		  while(rs.next()){
			  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
		  }
		  //close jdbc objs
		  rs.close();
		  st.close();
		  con.close();
	}//main
}//class

