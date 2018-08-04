package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsFxTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		int no=0;
		String query=null;
		CallableStatement cs=null;
		int salary=0;
		String desg=null,name=null;
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter emp no:");
				no=sc.nextInt();
			}//if
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//prepare Query
			query="{ ?=call GET_FX_EmpDetails(?,?,?)} ";
			//create Callable Statement obj
			if(con!=null){
				cs=con.prepareCall(query);
			}
			if(cs!=null){
			//register return param,out params with JDBC types
			cs.registerOutParameter(1,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.INTEGER);
			//set values to IN parameter
			cs.setInt(2,no);
			//call pl/sql function
			cs.execute();
			//gather results from Return , OUT Params
			desg=cs.getString(1);
			name=cs.getString(3);
			salary=cs.getInt(4);
			System.out.println("Emp Name:"+name);
			System.out.println("Emp Salary:"+salary);
			System.out.println("Emp Desg:"+desg);
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
