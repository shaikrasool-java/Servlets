package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args) {
		 Scanner sc=null;
		 Connection con=null;
		 Statement st=null;
		 int no=0;
		 String name=null,addrs=null;
		 int result=0;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter student no:");
				no=sc.nextInt();  //gives 1001
				System.out.println("Enter name");
				name=sc.next();  //gives raja
				System.out.println("Enter address");
				addrs=sc.next(); //gives hyd
			}//if
			//Convert input values as required for the SQL Query
			name="'"+name+"'"; //gives 'raja'
			addrs="'"+addrs+"'"; //gives 'hyd'
			
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//prepare SQL Query
			   // insert into student values(1001,'raja','mumbai')
			String query="insert into student values("+no+","+name+","+addrs+")";
			System.out.println(query);
			
			//send and execute SQL Query in Db s/w
			if(st!=null)
				result=st.executeUpdate(query);
			//process the result
			if(result==0)
				System.out.println("Record insertion failed");
			else
				System.out.println("Record insertion succeded");
		   }//try
		catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
			System.out.println("Record insertion failed");
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
			System.out.println("Record insertion failed");
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
