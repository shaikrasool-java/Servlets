package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		try{
			sc=new Scanner(System.in);
			int cnt=0;
			if(sc!=null){
				System.out.println("Enter student count");
				cnt=sc.nextInt();
			}
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//prepare SQL Query
			String query="insert into student values(?,?,?)";
			//Create PreparedStatement having pre-compiled SQL Query
          ps=con.prepareStatement(query);

			//read inputs
			if(sc!=null && ps!=null){
				for(int i=1;i<=cnt;++i){
					System.out.println("Enter "+i+" student details");
					 System.out.println("Enter number:");
					 int no=sc.nextInt();
					 System.out.println("Enter name");
					 String name=sc.next();
					 System.out.println("Enter address");
					 String addrs=sc.next();
					 // set each student details to query params
					 ps.setInt(1,no);
					 ps.setString(2,name);
					 ps.setString(3,addrs);
					 //execute the  query
					 int result=ps.executeUpdate();
					  if(result!=0)
						  System.out.println(i +" student details are inserted");
					  else
						  System.out.println(i +" student details are not inserted");
				}//for
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

