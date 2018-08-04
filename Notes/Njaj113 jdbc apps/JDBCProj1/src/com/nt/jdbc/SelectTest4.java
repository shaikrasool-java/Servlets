package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {

	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter initial chars of employee name:");
		String initChars=sc.next().toUpperCase(); //gives AD
		//Convert input values are reuired for the SQL Query
		initChars="'"+initChars+"%'"; //gives 'AD%'
		
		//register JDBC Driver
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  //Estalish the connection
		Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		  //Create Statement obj
		  Statement st=con.createStatement();
		 //prepare SQL Query
                // select empno,ename,job,sal from emp where ename like 'AD%'
		   String query="select empno,ename,job,sal from emp where ename like "+initChars;
		   System.out.println(query);
		 //send and excute SQL Query in Db s/w
		   ResultSet rs=st.executeQuery(query);
		   //process the ResultSet
		   boolean flag=false;
		   while(rs.next()){
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			    flag=true;
		   }//while
		   
		   if(flag==false)
			 System.out.println();
		   
		   //close jdbc objs
		   rs.close();
		   st.close();
		   con.close();
	}//main
}//class

