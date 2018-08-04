package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsTest2 {

	public static void main(String[] args) {
		  Scanner sc=null;
		  Connection con=null;
		  int no=0;
		  String query=null;
		  CallableStatement cs=null;
		  
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter no:");
				no=sc.nextInt();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//prepare Query
			 query="{ call get_EmpDetails(?,?,?,?)}";
			//create CallableStatement obj
			 if(con!=null)
			   cs=con.prepareCall(query);
			 if(cs!=null){
			 //regiser OUT params with JDBC types
				 cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.VARCHAR);
				 cs.registerOutParameter(4,Types.INTEGER);
             // set value to IN param
				 cs.setInt(1, no);
			// call pl/sql procedure
				 cs.execute();
			//gather results from OUT params
				 System.out.println("Emp name"+cs.getString(2));
				 System.out.println("Emp JOB "+cs.getString(3));
				 System.out.println("Emp Salary"+cs.getInt(4));
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
		

	}

}
