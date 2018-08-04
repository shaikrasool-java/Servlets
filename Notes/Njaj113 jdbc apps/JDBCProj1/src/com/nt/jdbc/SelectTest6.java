package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* App to get Highest salary employee details 
 *  version : 1.0
 *  author :Team-j
 *  Date : 2016/03/14
 */

public class SelectTest6 {

	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		 boolean flag=false;
		
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			 con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
           //create STaement 			 
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				rs=st.executeQuery("select empno,ename,sal,job from emp where sal=(select max(sal) from emp)");
			//process the ResultSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3)+"  "+rs.getString(4));
					flag=true;
				}//while
			}//if
			if(!flag){
				System.out.println("Records not found");
			}//if
		}//try
		catch(SQLException se){  //known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){ //known Exception
			cnf.printStackTrace();
		}
		catch(Exception e){  // unknown Exception
			e.printStackTrace();
		}
		finally{
			//close objs
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
