package com.nt.jdbc;
/* App to update the student details based on given student no
 * Version: 1.0
 * Author :Team-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			int no=0;
			String newName=null,newAddrs=null;
			if(sc!=null){		
			  System.out.println("Enter student no:");
			  no=sc.nextInt(); // gives 101
			  System.out.println("Enter student new name:");
			  newName=sc.next(); //gives king
			  System.out.println("Enter student new addrs");
			  newAddrs=sc.next(); //gives delhi
			}
			//convert input values as required for the SQL Query
			newName="'"+newName+"'"; //gives 'king'
			newAddrs="'"+newAddrs+"'"; //gives 'delhi'
			//register jdbc driver 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//prpeare SQL Query
			    // update student set sname='king',sadd='delhi' where sno=123
			  String query="update student set sname="+newName+",sadd="+newAddrs+" where sno="+no;
			System.out.println(query);
			//send and execute SQL Query in DB s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			//process the Result
			if(count==0)
				System.out.println("Record not found for updation");
			else
				System.out.println("Record found and updated");
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

