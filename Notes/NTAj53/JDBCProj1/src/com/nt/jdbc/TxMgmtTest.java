package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {
	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 Scanner sc=null;
		 int srcNo=0,destNo=0,amt=0;
		 int result[];
		 boolean flag=true;
		 try{
			 //read inputs
			 sc=new Scanner(System.in);
			 if(sc!=null){
				 System.out.println("Enter Soruce Account no:");
				 srcNo=sc.nextInt();
				 System.out.println("Enter Dest Account no:");
				 destNo=sc.nextInt();
				 System.out.println("Enter amount to transfer:");
				 amt=sc.nextInt();
			 }
			 //register jdbc driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //Establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			 //create Statement obj
			 st=con.createStatement();
			 //Begin the Transaction
			 con.setAutoCommit(false);
			  //add queries to the batch  (Contine the Tx)
			  // withdraw operation
			 st.addBatch("update jdbc_account set balance=balance-"+amt+" where accno="+srcNo);
			  // deposite operation
			 st.addBatch("update jdbc_account set balance=balance+"+amt+" where accno="+destNo);
             // Execute the Batch
			 result=st.executeBatch();
			 //perform Transaction management
			 for(int i=0;i<result.length;++i){
				if(result[i]==0){
					flag=false;
					break;
				}//if
			 }//for
			 if(flag==true){
				 con.commit(); //Commit the Tx
				 System.out.println("Transaction is commited");
			 }
			 else{
				 con.rollback(); //Commit the Tx
				 System.out.println("Transaction is Rolledback");
			 }
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
			 //close jdbc objs
			  try{
				  if(st!=null)
					  st.close();
			  }//try
			  catch(Exception e){
				  e.printStackTrace();
			  }
			  try{
				  if(con!=null)
					  con.close();
			  }//try
			  catch(Exception e){
				  e.printStackTrace();
			  }
		 }//finally
	}//main
}//class

