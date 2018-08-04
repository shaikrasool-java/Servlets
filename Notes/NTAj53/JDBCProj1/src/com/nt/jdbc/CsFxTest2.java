package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsFxTest2 {
	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student no:");
		int no=sc.nextInt();
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//prepare Query calling pl/sql function
		String query="{ ?=call Get_Student_For_Deletion(?,?)}";
		//create CallableStatement obj
		CallableStatement cs=con.prepareCall(query);
		//register OUT,return params with jdbc types
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.registerOutParameter(3,Types.INTEGER);
		//set value to IN param
		cs.setInt(2,no);
		//call pl/sql function
		cs.execute();
		//gather results from OUT,return params
		ResultSet rs=(ResultSet)cs.getObject(1);
		System.out.println("Record is");
		if(rs.next())
		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		//check whether record is deleted or not
		int count=cs.getInt(3);
		if(count==0)
			  System.out.println("Record not deleted");
		else
			  System.out.println("Record is deleted");
		 //close jdbc objs
		rs.close();
		cs.close();
		con.close();
	}//main
}//class

