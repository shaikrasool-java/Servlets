package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*  App to insert record into student Db table by collecting 
     values from the enduser  
 */
public class InsertTest {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			String name=null;
			String addrs=null;
			if(sc!=null){
			  System.out.println("Enter student no:");
			  no=sc.nextInt();
			  System.out.println("Enter student name:");
			  name=sc.next(); // gives raja
			  System.out.println("Enter student address");
			  addrs=sc.next(); // gives hyd
			}
			//Convert input values as required for the  SQL Query
			name="'"+name+"'"; //gives 'raja'
			addrs="'"+addrs+"'"; //gives 'hyd'
			//register jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//prepare SQL Query 
			      //insert into student values(123,'raja','hyd')
			String query="insert into student values("+no+","+name+","+addrs+")";
			System.out.println(query);
			//send and execute SQL Query in Db s/w
			 int count=0;
			 if(st!=null){
				 count=st.executeUpdate(query);
			 }
			  if(count==0)
				   System.out.println("Record not inserted");
			  else 
				  System.out.println("Record inserted");
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
			//close strams/objs
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
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
     }//main
	}//class
