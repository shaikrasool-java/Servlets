package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int cnt=0;
		try{
		  //register driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement obj
			if(con!=null)
			 st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					                                   ResultSet.CONCUR_UPDATABLE);
			//excute the Query
			 if(st!=null)
				 rs=st.executeQuery("select sid,name,address from student");
			 //Read records
			 if(rs!=null){
				 while(rs.next()){
					 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				 }//while
				/* //update operation
				 rs.absolute(3);
				 rs.updateString(2, "express raja");
				 rs.updateRow();
				 System.out.println("3rd record updated");*/
				/* //To insert new record
				 rs.moveToInsertRow();
				 rs.updateInt(1,456);
				 rs.updateString(2,"nagesh");
				 rs.updateString(3, "vizag");
				 rs.insertRow();
				 System.out.println("Record inserted");
				 */
				 //To delete record
				 rs.absolute(2);
				 rs.deleteRow();
				 System.out.println("Record deleted");
				 
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
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
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
		}//finally
	}//main
}//class
	
