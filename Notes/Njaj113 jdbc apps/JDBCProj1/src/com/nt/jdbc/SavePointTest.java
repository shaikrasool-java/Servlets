package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Savepoint  sp=null;
	  try{
		  //registr jdbc driver
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create Statement obj
		  if(con!=null){
		  st=con.createStatement();
		  //begin Tx
		  con.setAutoCommit(false);
		  }
		  if(st!=null){
		  //execute query1
		    st.executeUpdate("insert into student values(678,'ramesh','hyd')");
		    //create savepoint(named)
		     sp=con.setSavepoint("mysp");
		       //execute query2
		       st.executeUpdate("update student set sadd='vizag' where sno=2222");
		     //rollback upto save point 
		       con.rollback(sp);
		     con.commit();
		  }//if
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
