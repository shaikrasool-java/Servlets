package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {
	
	public static void main(String[] args)throws Exception {
		//read inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username:");
		String user=sc.nextLine();  //gives raja
		System.out.println("Enter Password:");
		String pass=sc.nextLine(); //gives rani
		
		//Convert  input values as requred for the SQL Query
		user="'"+user+"'";  //gives 'raja'
		pass="'"+pass+"'"; //gvies 'rani'
		
		//register jdbc driver s/w
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		//create Statement object
		Statement st=con.createStatement();
		//prepare SQL Query
		       //  select count(*) from userlist where uname='raja' and pwd='rani'
		 String query="select count(*) from userlist where uname="+user+" and pwd="+pass;
		 System.out.println(query);
		 
		 //send and execute SQL Query in DB s/w
		 ResultSet rs=st.executeQuery(query);
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
		 st.close();
		 con.close();
	}//main
}//class

