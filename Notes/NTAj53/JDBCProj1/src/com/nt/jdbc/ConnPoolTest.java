package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnPoolTest {

	public static void main(String[] args)throws Exception {
		//create DataSoruce obj
		OracleConnectionPoolDataSource ds= 
				 new OracleConnectionPoolDataSource();
		//set properties to create con objs in the jdbc con pool
		ds.setDriverType("thin");
		ds.setServerName("localhost");
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("scott");
		ds.setPassword("tiger");
		//get jdbc con obj from jdbc con pool
		Connection con=ds.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
		//close jdbc objs
		rs.close();
		st.close();
		con.close(); // releases the con obj back jdbc con pool
		
		

	}

}
