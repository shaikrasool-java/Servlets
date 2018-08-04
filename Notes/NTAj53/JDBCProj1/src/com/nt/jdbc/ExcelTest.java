package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExcelTest {

	public static void main(String[] args)throws Exception {
		//register jdbc driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:xlsdsn");
	/*	//create Statmeent obj
		Statement st=con.createStatement();
		//send and execute SQL Query in Db s/w
		ResultSet rs=st.executeQuery("select * from [Sheet1$]");
		//process the ReusltSet
		while(rs.next()){
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}*/
		PreparedStatement ps=
				con.prepareStatement("insert into [Sheet1$] values(?,?,?)");
		ps.setInt(1,456);
		ps.setString(2,"mahesh");
		ps.setString(3,"vizag");
		int result=ps.executeUpdate();
		
		if(result==0)
			System.out.println("Record not inserted");
		else
			System.out.println("Record inserted");
		
		
		//close jdbc objs
		/*rs.close();
		st.close();
		*/con.close();
	}//main
}//class

