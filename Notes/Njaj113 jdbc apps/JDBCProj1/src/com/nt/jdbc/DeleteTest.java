package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		int no=0;
		int result=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			System.out.println("Enter student no to delete");
			no=sc.nextInt();
			
			//register jdbc driver s/w
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				result=st.executeUpdate("delete from student where sno="+no);
			//process the result
			if(result==0)
				System.out.println("No records found for deletion");
			else
				System.out.println(result+"no.of records are found for deletion");
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

