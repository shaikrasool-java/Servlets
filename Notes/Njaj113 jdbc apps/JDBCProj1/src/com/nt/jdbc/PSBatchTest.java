package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PSBatchTest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null; 
		int result[]=null;
		try{
			//regster jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj
			if(con!=null)
			  ps=con.prepareStatement("insert into student values(?,?,?)");

			if(ps!=null){
				//add multiple sets of param values to the batch
			   ps.setInt(1,1111); ps.setString(2,"Raja"); ps.setString(3,"hyd");
			   ps.addBatch(); //adds 1st set values to batch
			   
			   ps.setInt(1,2222); ps.setString(2,"ravi"); ps.setString(3,"delhi");
			   ps.addBatch(); //adds 2nd set values to batch
			   //execute batch
			   result=ps.executeBatch();
			}//if
			if(result!=null){
				System.out.println("Records  inserted");
			}
			else{
				System.out.println("Records not inserted");
			}
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
				if(ps!=null)
					ps.close();
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
