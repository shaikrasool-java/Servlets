package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataApp {
	public static void main(String[] args)throws Exception {
		 //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj
		Statement st=con.createStatement();
		//create ResultSet obj
		ResultSet rs=st.executeQuery("Select sno,sname from student");
		// get ResultSetMetaData obj
		ResultSetMetaData rsmd=rs.getMetaData();
		int colCnt=rsmd.getColumnCount();
		for(int i=1;i<=rsmd.getColumnCount();++i){
			System.out.print(rsmd.getColumnLabel(i)+"   ");
		}
		System.out.println();
		for(int i=1;i<=rsmd.getColumnCount();++i){
			System.out.print(rsmd.getColumnTypeName(i)+"   ");
		}
	   System.out.println();
		//process the ResultSet
		while(rs.next()){
			 for(int i=1;i<=colCnt;++i){
				 System.out.print(rs.getString(i)+"  ");
			 }
			 System.out.println();
		}
		
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
		
	}

}
