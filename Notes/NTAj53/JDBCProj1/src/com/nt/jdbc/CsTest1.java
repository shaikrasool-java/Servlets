package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsTest1 {
	public static void main(String[] args)throws Exception {
		 //read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no:");
		int no=sc.nextInt();
		  //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare Query calling pl/sql procedure
		String query="{call first_pro1(?,?)}";
		//create CallableStatement obj
		CallableStatement cs=con.prepareCall(query);
		//register OUT param with jdbc data type
		cs.registerOutParameter(2,Types.INTEGER);
		//set value to IN param
		cs.setInt(1,no);
		//call pl/sql proecure
		cs.execute();
		//gather result from OUT param
		int result=cs.getInt(2);
		//Display result
		System.out.println("SQuare "+result);
		//close jdbc objs
		cs.close();
		con.close();
	}//main
}//class

