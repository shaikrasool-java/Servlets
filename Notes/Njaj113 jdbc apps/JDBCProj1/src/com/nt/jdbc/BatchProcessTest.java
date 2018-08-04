package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int result[]=null;
		int sum=0;
		
		try{
			//register driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//add queries to the batch
			if(st!=null){
				st.addBatch("insert into student values(1213,'ramesh','hyd')");
				st.addBatch("update student set sadd='new delhi' where sno>=500");
				st.addBatch("delete from student where sno=113");
				// execute the batch
				result=st.executeBatch();
			}
			//process te results
			if(result!=null){
				for(int i=0;i<result.length;++i){
					sum=sum+result[i];
				}//for
				System.out.println("No.of records that are effected"+sum);
			}//if
			
			
		}//try
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
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

