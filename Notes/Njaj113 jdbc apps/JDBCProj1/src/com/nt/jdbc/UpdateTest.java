package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		int no=0;
		String newName=null,newAddrs=null;
		String query=null;
		int result=0;
		
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter existing student no to update");
				no=sc.nextInt();  //gives 101
				System.out.println("Enter new name for student");
				newName=sc.next(); //gives newraja
				System.out.println("Enter new address for student");
				newAddrs=sc.next();  //gives naviMumbai
			}
			//convert input values as required for the SQL Query
			newName="'"+newName+"'"; //gives 'newraja'
			newAddrs="'"+newAddrs+"'"; //gives 'naviMumbai'
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create STatement obj
			if(con!=null)
			  st=con.createStatement();
			//prepare SQL Query
			   // update student set sname='newRaja',sadd='naviMumbai'  where sno=101
			query="update student set sname="+newName+",sadd="+newAddrs+ "  where sno="+no;
			
			//send and execute SQL Query in DB s/w
			if(st!=null)
			  result=st.executeUpdate(query);
			//process the result
			if(result==0)
				  System.out.println("Record not found to update");
			else
				System.out.println("Record Found to update");
		}//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
		  e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(st!=null)
					st.close();
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
