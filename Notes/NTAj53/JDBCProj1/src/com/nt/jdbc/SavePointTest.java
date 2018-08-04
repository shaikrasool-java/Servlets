package com.nt.jdbc;

//SavePointTest.java
import java.sql.*;
public class SavePointTest
{
	public static void main(String args[])throws Exception
	{
		//register jdbc driver and establish the connection
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");

		//create statment obj
		Statement st = con.createStatement();
     
		// Begin Tx 
	con.setAutoCommit(false);
		//query1 (outside the save point area)
		st.executeUpdate("insert into student values(721,'xyz1','hyd1')"); 
			// create Named Save Point("p1")
		    Savepoint sp=con.setSavepoint("p1");
				//query2(	inside save point area)
		      st.executeUpdate("update student set sadd='delhi8' where sno=456");
              //rollaback upto savepoint(p1)
   		con.rollback(sp);
	  // commit Tx
	con.commit(); //end of the Tx

	//query1 will be commited but query2 will be rolled back
	//becoz the query2 is there in savepoint area..(p1)
	}//main
}//class
//>javac SavePointTest.java
//>java SavePointTest