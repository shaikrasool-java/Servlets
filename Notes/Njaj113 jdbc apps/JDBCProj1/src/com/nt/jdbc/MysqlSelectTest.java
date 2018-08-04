package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlSelectTest {

	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		try{
			//register jdbc driver
		    //Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("com.mysql.jdbc.Driver");
		    //establish the connection
		    // con=DriverManager.getConnection("jdbc:mysql:///ntaj113db","root","root");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj113db1",
	    	                                                                                   "root","root");	                                                                                   
		    //create Statement obj
		     if(con!=null)
		    	 st=con.createStatement();
		    //send and execite SQL Query in Db s/w
		     if(st!=null)
		    	 rs=st.executeQuery("select * from student");
		     //proess the ResultSet
		     if(rs!=null){
		    	 while(rs.next()){
		    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
		    	 }//while
		     }//if
		     System.out.println("con obj class name"+con.getClass());
		     System.out.println("st obj class name"+st.getClass());
		     System.out.println("rs obj class name"+rs.getClass());
		     
		     
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{

			try{
				if(rs!=null)
					rs.close();
			}
			catch(Exception se){
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

