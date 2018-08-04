package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExcelToOracleTest {
	public static void main(String[] args) throws Exception {
		//register jdbc drivers
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connections
		Connection xlsCon=DriverManager.getConnection("jdbc:odbc:xlsdsn");
		Connection oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement objs
		Statement st=xlsCon.createStatement();
		PreparedStatement ps=oraCon.prepareStatement("insert into student values(?,?,?)");
		// get All records from Excel Sheet
		ResultSet rs=st.executeQuery("select * from [Sheet1$]");
		//process the ResultSet
		while(rs.next()){
			//get each record from ResultSEt (Excel sheet)
			int no=rs.getInt(1);
			String name=rs.getString(2);
			String addrs=rs.getString(3); 
		  //set each record values to theQuery PreparedStatement obj
			ps.setInt(1, no);
			ps.setString(2,name);
			ps.setString(3,addrs);
            ps.executeUpdate();  //inserts each record oracle db table
		}//while
		
		System.out.println("Records are copied to Oracle from Excelsheet");
		//close jdbc objs
		rs.close();
		st.close();
		ps.close();
		xlsCon.close();
		oraCon.close();
	}
}
