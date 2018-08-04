package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.net.aso.p;

public class PstSelectTest {

	public static void main(String[] args) throws Exception{
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter initial chars of employee name:");
		String initChars=sc.next().toUpperCase(); //gives AD
		
		
		//register JDBC Driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //Estalish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		 //prepare SQL Query
        	   String query="select empno,ename,job,sal from ? where ename like ?";
        //create PrepareStatement obj
        	   PreparedStatement ps=con.prepareStatement(query);
        	  //set Query IN parma values
        	   ps.setString(1,"emp");
        	   ps.setString(2,initChars+"%");
		 //send and excute SQL Query in Db s/w
		   ResultSet rs=ps.executeQuery();
		   
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
		   ps.close();
		   con.close();
	}//main
}//class

