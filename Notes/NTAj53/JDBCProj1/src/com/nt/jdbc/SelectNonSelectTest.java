package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter SQL Query(select/non-select)");
		String query=sc.nextLine(); 
		//register jdbc driver  s/w
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Establish  the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		// Create Statement obj
		Statement st=con.createStatement();
		//send and execute SQL Query in DB s/w
		boolean flag=st.execute(query);
		//get the Result and process the Result 
		if(flag==true){
			System.out.println("select Query is executed");
			ResultSet rs=st.getResultSet();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			//close ResultSet
			rs.close();
		}
		else{
			System.out.println("Non-select Query is executed");
			int cnt=st.getUpdateCount();
			System.out.println(cnt+" no.of records are effected");
		}
		
		//close jdbc objs
		st.close();
		con.close();
	}//main
}//class

