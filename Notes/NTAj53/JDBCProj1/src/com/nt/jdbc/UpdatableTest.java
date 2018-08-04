package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableTest {
	public static void main(String[] args) throws Exception{
        //register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		//create Statement obj having type,mode
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                              ResultSet.CONCUR_UPDATABLE);
		//create Updatable ResultSet
		ResultSet rs=st.executeQuery("select sno,sname,sadd from student" );
		//read the records
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
/*		//insert operation
		rs.moveToInsertRow();
		rs.updateInt(1, 5688);
		rs.updateString(2,"rajesh");
		rs.updateString(3, "hyd");
		rs.insertRow();
*/
	/*	//update operation
		rs.absolute(4);
		rs.updateString(3,"new hyd");
		rs.updateRow();*/
		
		//delete operation
		rs.absolute(2);
		rs.deleteRow();
		
		//create JDBC ResultSet obj
				//close jdbc objs
	    
	    con.close();
	}//main
}//class

