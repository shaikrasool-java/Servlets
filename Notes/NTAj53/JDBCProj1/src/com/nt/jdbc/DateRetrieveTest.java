package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DateRetrieveTest {
	public static void main(String[] args) throws Exception{
	/*	//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establisht the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); */
		// register jdbc driver
		 Class.forName("com.mysql.jdbc.Driver");
		//Establisht the connection
		Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj53db1","root","root");

		//create Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in Db s/w
		ResultSet rs=st.executeQuery("select * from person_tab");
		//Process the ReusltSet
		while(rs.next()){
			int no=rs.getInt(1);
			String name=rs.getString(2);
			java.sql.Date sqdob=rs.getDate(3);
			java.sql.Date sqdoj=rs.getDate(4);
			//Convert java.sql.Date class objs to java.util.Date class obj
			java.util.Date udob=(java.util.Date)sqdob;
			java.util.Date udoj=(java.util.Date)sqdoj;
			//Convert java.util.Date class objs to String date values
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd");
			String dob=sdf.format(udob);
			String doj=sdf.format(udoj);
			System.out.println(no+"  "+name+"  "+dob+"  "+doj);
		}//while
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}
}
