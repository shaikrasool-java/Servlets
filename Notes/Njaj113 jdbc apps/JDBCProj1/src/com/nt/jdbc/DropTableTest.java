package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int result=0;
		try{
			//register jdbc driver s/w
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				result=st.executeUpdate("drop table temp");
			//process the result
			if(result==0)
				System.out.println("Table not dropped");
			else
				System.out.println("Table dropped");
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
		}//finally
  }//main
}//class

