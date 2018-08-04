package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp1 {
	
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username:");
		String user=sc.nextLine();  //gives raja
		System.out.println("Enter Password:");
		String pass=sc.nextLine(); //gives rani
		
		//register jdbc driver s/w
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		// prepare SQL Query
		   String query="select count(*) from userlist where uname=? and pwd=?";
        //Create Jdbc PreparedStatement obj
		   PreparedStatement ps=con.prepareStatement(query);
		  //set inputs to query params
		   ps.setString(1,user);
		   ps.setString(2,pass);
		   //execute the Query
		   ResultSet rs=ps.executeQuery();
		 //process the ResultSet
		 int cnt=0;
		 if(rs.next())
			 cnt=rs.getInt(1);
		 
		 if(cnt==0)
			 System.out.println("InValid CRedentials");
		 else
			 System.out.println("Valid Credentials");
		 
		 //close jdbc objs
		 rs.close();
		 ps.close();
		 con.close();
	}//main
}//class

