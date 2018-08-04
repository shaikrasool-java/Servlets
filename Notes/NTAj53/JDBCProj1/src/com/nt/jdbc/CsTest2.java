package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsTest2 {

	public static void main(String[] args) throws Exception{
		  //read inputs 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp no:");
		int no=sc.nextInt();
		//register jdbc driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare Query calling Pl/sql Procedure
		String query="{ call get_EmpDetails(?,?,?)}";
		//create CallableStatement obj
		CallableStatement cs=con.prepareCall(query);
		//register OUT params with jdbc types
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3,Types.INTEGER);
		// set values to IN params
		cs.setInt(1,no);
		// execute Pl/sql Procedure
		cs.execute();
		// Gather results from OUT Params
		System.out.println("Emp Name :"+cs.getString(2));
		System.out.println("Emp Salary:"+cs.getInt(3));
		//close jdbc objs
		cs.close();
		con.close();
	}//main
}//class

