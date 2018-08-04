package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int srcNo=0,destNo=0,amt=0;
		Connection con=null;
		Statement st=null;
		int result[]=null;
		boolean flag=false;
      try{
    	  //read inputs
    	  sc=new Scanner(System.in);
    	  if(sc!=null){
    		  System.out.println("Enter source Account no:");
    		  srcNo=sc.nextInt();
    		  System.out.println("Enter Dest Account no:");
    		  destNo=sc.nextInt();
    		   System.out.println("Enter Amount to transfer:");
    		   amt=sc.nextInt();
    	  }//if
    	//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//Begin Transaction
			if(con!=null){
				con.setAutoCommit(false);
				//create statement obj
				st=con.createStatement();
			}

			if(st!=null){
				//add queries to the batch				
				//withdraw amount from source account
				st.addBatch("update jdbc_account set balance=balance-"+amt+" where acno="+srcNo);
				//deposite amount into dest account
				st.addBatch("update jdbc_account set balance=balance+"+amt+" where acno="+destNo);
				//execute batch
				result=st.executeBatch();
			}//if
			//Perform Tx mgmt (Commit or rollback)
			if(result!=null){
				for(int i=0;i<result.length;++i){
					if(result[i]==0){
						flag=true;
						break;
					}//if
				}//for
				
				if(flag==true){
					con.rollback();
					System.out.println("Tx rolledback -- money not transfered");
				}
				else{
					con.commit();
					System.out.println("Tx Committed -- money  transfered");
				}//else
			}//if
			
      }//try
      catch(SQLException se){  //to handle known Exception
			se.printStackTrace();
		
		}
		catch(ClassNotFoundException cnf){  //To handle known exception
		
			cnf.printStackTrace();
		}
		catch(Exception e){  // To handle unkonwn exception
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
