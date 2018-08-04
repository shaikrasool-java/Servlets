package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class FlexibleTest {
	public static void main(String[] args)throws Exception {
		 //locate the propeties file
		InputStream is=new FileInputStream("src/com/nt/commons/DBDetails.properties");
		//Load properties file content into java.util.Properties class obj
		Properties props=new Properties();
		props.load(is);
		//get JDBC properties
		String driver=props.getProperty("jdbc.driver");
		String url=props.getProperty("jdbc.url");
		String user=props.getProperty("jdbc.user");
		String pwd=props.getProperty("jdbc.pwd");
		//write jdbc code
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
		}
	//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}//main
}//class

