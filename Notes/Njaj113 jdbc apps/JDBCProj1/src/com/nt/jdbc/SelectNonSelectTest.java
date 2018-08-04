package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		boolean flag=false;
		ResultSet rs=null;
		int count=0;
		try{
			
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter SQL Query");
				query=sc.nextLine();
			}//if
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create STatement obj
			if(con!=null)
			  st=con.createStatement();
			//send and execute SQL Query
			flag=st.execute(query);
			if(flag==true){
				System.out.println("select Query is executed");
				rs=st.getResultSet();
				//proess the ResultSet
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}//while
			}//if
			else{
			   System.out.println("Non-Select Query is executed");
			   count=st.getUpdateCount();
			   System.out.println("No.of recrods that are effected"+count);
			}//else
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
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se ){
				se.printStackTrace();
			}
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
