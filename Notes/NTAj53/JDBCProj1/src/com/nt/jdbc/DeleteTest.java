package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {
  public static void main(String[] args)throws Exception {
	  //read inputs
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter student no");
	  int no=sc.nextInt();
	  //register jdbc driver
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  //Establish the connection
	  Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
	  //Create Statement obj
	  Statement st=con.createStatement();
	  //Send and execute SQL Query 
	  int cnt=st.executeUpdate("delete from student where sno="+no);
	  //Process the ResultSet
	  if(cnt==0)
		  System.out.println("Record not Found to delete");
	  else
		  System.out.println("Record Found and Deleted");
	  // close jdbc objs
	    st.close();
	    con.close();
   }//main
}//class
