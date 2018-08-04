package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest1 {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		String query=null;
		CallableStatement cs=null;
		int result=0;
		
		
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter no:");
				no=sc.nextInt();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//prepare SQL Query callin pl/sql procedure
			query="{call first_pro1(?,?)}";
			//create Callable Statement obj
			if(con!=null)
			  cs=con.prepareCall(query);

			if(cs!=null){
				//register OUT params with JDBC types
				cs.registerOutParameter(2,Types.INTEGER);
				//set values to IN params
				cs.setInt(1,no);
				//execute pl/sql procedure
				cs.execute();
				//gather result from OUT paam
				result=cs.getInt(2);
				System.out.println("SQUARE value"+result);
			}//if
		}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
			System.out.println("Record insertion failed");
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
			System.out.println("Record insertion failed");
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(cs!=null)
					cs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class
