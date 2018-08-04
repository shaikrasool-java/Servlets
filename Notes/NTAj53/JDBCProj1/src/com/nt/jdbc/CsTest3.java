package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsTest3 {
	public static void main(String[] args) throws Exception{
		//read  inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name:");
		String user=sc.nextLine(); // gives raja
		System.out.println("Enter password:");
		String pwd=sc.nextLine(); //gives rani
		//register jdbc driver and establish the connection
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //Establish the connection
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
		 //prepare Query calling pl/sql procedure
		  String query="{ call p_authenticationPro(?,?,?)}";
		   // create Callable Statement obj
		   CallableStatement cs=con.prepareCall(query);
		   //register OUT params with JDBC types
		   cs.registerOutParameter(3,Types.VARCHAR);
		   //set values to IN params
		   cs.setString(1,user);
		   cs.setString(2,pwd);
		   // call pl/sql procedure
		   cs.execute();
		   //read values from OUT param
		   String result=cs.getString(3);
		   System.out.println("Result :"+result);
		   //close jdbc objs
		   cs.close();
		   con.close();
	}//main
}//class

