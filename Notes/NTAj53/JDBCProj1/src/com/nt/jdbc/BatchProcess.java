package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcess {
	public static void main(String[] args) throws Exception{
		//register driver and establish the connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj
		Statement st=con.createStatement();
		//add Queries to batch
		st.addBatch("insert into student values(1002,'rakesh','mumbai')");
		  st.addBatch("update student set sadd='hyd13' where sno>=1000");
		  st.addBatch("delete from student  where sno=342");
		//send and execute batch queries in Db s/w
		  int result[]=st.executeBatch();   
		  //process the Result
		  int sum=0;
		   for(int i=0;i<result.length;++i){
		        sum=sum+result[i];
		     }
		 System.out.println("No.of records that are effected becoz batch processing"+sum);
		 //close jdbc objs
		 st.close();
		 con.close();
	}//main
}//class

