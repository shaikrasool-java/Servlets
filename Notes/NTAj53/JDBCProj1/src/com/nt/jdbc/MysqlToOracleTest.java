package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlToOracleTest {
	public static void main(String[] args) throws Exception{
		//register jdbc drivers
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		//Establisht the connections
		Connection mysqlCon=
				DriverManager.getConnection("jdbc:mysql:///ntaj53db","root","root");
		Connection oraCon=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Jdbc Statement objs
		 Statement st=
				 mysqlCon.createStatement();
		 PreparedStatement ps=
				 oraCon.prepareStatement("insert into student values(?,?,?)");
		 // execute the SQL Query in mysql Db s/w to the records
		 ResultSet rs=st.executeQuery("select * from student");
		 
		 //Copy mysql DB table records to Oracle DB table
		 while(rs.next()){
			 // get each record from mysql DB table
			 int no=rs.getInt(1);
			 String name=rs.getString(2);
			 String addrs=rs.getString(3);
			 //insert above values as each record to Oracle Db table
			 ps.setInt(1,no);
			 ps.setString(2,name);
			 ps.setString(3,addrs);
			 ps.executeUpdate();
		 }//while
		 
		 System.out.println("mysql Db table records are copied oracle Db table");
		 
		 //close jdbc objs
		 rs.close();
		 st.close();
		 ps.close();
		 oraCon.close();
		 mysqlCon.close();
	}//main
}//class

