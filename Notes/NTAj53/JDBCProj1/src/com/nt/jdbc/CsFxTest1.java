package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CsFxTest1 {
	public static void main(String[] args)throws Exception {
		  //read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter empno");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare Query calling pl/sql function
		String query="{?=call Fx_Get_EmpDetails(?,?,?)}";
		//create CallableStatement obj
		CallableStatement cs=con.prepareCall(query);
		//register OUT,return params with JDBC types
		cs.registerOutParameter(1,Types.VARCHAR);  //return param
		cs.registerOutParameter(3,Types.VARCHAR); //OUT param
		cs.registerOutParameter(4,Types.INTEGER); //OUT param
		//set value to IN param
		cs.setInt(2,no);
		//call pl/sql function
		cs.execute();
		// Gather results return param,OUT param
		String desg=cs.getString(1); //return PARAM
		String name=cs.getString(3);// OUT param
		int salary=cs.getInt(4);//OUT param
		System.out.println(desg+"    "+name+"   "+salary);
		//close jdbc objs
		cs.close();
		con.close();
	}
}
