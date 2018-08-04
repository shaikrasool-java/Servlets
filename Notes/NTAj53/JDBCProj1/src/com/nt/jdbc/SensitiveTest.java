package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SensitiveTest {
	public static void main(String[] args)throws Exception {
		 //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                             ResultSet.CONCUR_UPDATABLE);
		//create ResultSet obj
		ResultSet rs=st.executeQuery("Select sno,sname,sadd from student");
		//process the ResultSet
		int cnt=0;
		while(rs.next()){
			
			if(cnt==0)
				Thread.sleep(20000);
			rs.refreshRow();
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			cnt++;
		}
		
	}

}
