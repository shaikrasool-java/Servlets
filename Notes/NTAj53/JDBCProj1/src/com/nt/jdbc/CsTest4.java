package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.driver.OracleTypes;

public class CsTest4 {
	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter initial chars");
		String initChars=sc.next().toUpperCase().concat("%");  //gives S%
		//register drvier and establish the connection
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		 // prepare SQL Query
		 String query="{call fetch_AllEmpDetails(?,?)}";
		 //create CallableStatement obj
		 CallableStatement cs=con.prepareCall(query);
		 //register OUT params with JDBC types
		 cs.registerOutParameter(2,OracleTypes.CURSOR);
		 //set  values to IN params
		 cs.setString(1,initChars);
		 //call pl/sql proceure
		 cs.execute();
		 //gather results from OUT param (CURSOR)
		 ResultSet rs=(ResultSet)cs.getObject(2);
		 //process theResultSet
		 while(rs.next()){
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
		 }
		 //close jdbc objs
		 rs.close();
		 cs.close();
		 con.close();
	}//main
}//class

