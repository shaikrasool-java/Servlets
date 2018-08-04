package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DateRetrieve {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int no=0;
		String name=null;
		java.sql.Date sqdob=null,sqdoj=null;
		java.util.Date udob=null,udoj=null;
		SimpleDateFormat sdf=null;
		String dob=null,doj=null;
		
		
		try{
		/* //register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
			
			 //register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj113db1","root","root");
			
			//create Parepared Statement obj
			if(con!=null)
			   ps=con.prepareStatement("select * from person_tab");
			// execute the Query
			if(ps!=null)
			   rs=ps.executeQuery();
			//process the ResultSet
			while(rs.next()){
				no=rs.getInt(1);
				name=rs.getString(2);
				sqdob=rs.getDate(3);
				sqdoj=rs.getDate(4);
				//Convert java.sql.Date class objs to java.util.Date class objs
				 udob=(java.util.Date)sqdob;
				udoj=(java.util.Date)sqdoj;
				//Convert java.util.Date class obj to String date
				sdf=new SimpleDateFormat("yyyy-MMM-dd");
				dob=sdf.format(udob);
				doj=sdf.format(udoj);
				System.out.println(no+"   "+name+"   "+dob+"   "+doj);
			}//while
			
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

