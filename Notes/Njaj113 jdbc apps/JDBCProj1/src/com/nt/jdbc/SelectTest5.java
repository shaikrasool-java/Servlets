package com.nt.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* App to get Emp Details based on given desinations
 * version: 1.0 
 * author : Team-J
 * Date : 2016/03/14
 */

public class SelectTest5 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String desg1=null,desg2=null,desg3=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
		
			if(sc!=null){
			   System.out.println("Enter Desg1");
			   desg1=sc.next().toUpperCase(); //gives CLERK
			   
			   System.out.println("Enter Desg2");
			   desg2=sc.next().toUpperCase(); //gives MANAGER
			   
			   System.out.println("Enter Desg3");
			   desg3=sc.next().toUpperCase(); //gives SALESMAN
			}
			//Frame condition    ('CLERK','MANAGER','SALESMAN')
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')"; //gives ('CLERK','MANAGER','SALESMAN')
			
			//register jdbc driver s/w
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver1");
			
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			
			//frame the SQL Query
			//select empno,ename,job,sal from emp where   job in('CLERK','MANAGER','SALESMAN') order by job
			String query="select empno,ename,job,sal from emp where   job in"+cond+ " order by job";
			System.out.println(query);
			
			//send and execute SQL Query in DB s/w
			if(st!=null)
				rs=st.executeQuery(query);
			//process the ResultSet
			if(rs!=null){
				
				while(rs.next()){
					flag=true;
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
				}//while
				if(flag==false)
					System.out.println("No Records found ");
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
			try{
			  if(sc!=null)
				  sc.close();
			 }
			catch(Exception se){
				se.printStackTrace();
			}
			
		}//finally
	}//main
}//class

