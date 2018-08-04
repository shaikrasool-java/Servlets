package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsFxTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		String query=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		int result=0;
		int no=0;
	    try{
	    	sc=new Scanner(System.in);
	    	if(sc!=null){
	    		System.out.println("Enter student no");
	    		no=sc.nextInt();
	    	}//if
	    	//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager"); 
	    	//prepare SQL Query
			query="{ ?=call Get_FX_STUDENT_FOR_DELETION(?,?)}";
			//create Callable statement obj
			if(con!=null)
				cs=con.prepareCall(query);
			if(cs!=null){
				 //register OUT params with JDBC types
				cs.registerOutParameter(1,OracleTypes.CURSOR);
				cs.registerOutParameter(3,Types.INTEGER);
				//set values to IN params
				cs.setInt(2,no);
				//call pl/sql function
				cs.execute();
				//gather results
			    rs=(ResultSet)cs.getObject(1);
			    //process the resultset
			    if(rs!=null){
			    	if(rs.next()){
			    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			    	}//if
			    }//if
			    result=cs.getInt(3);
			    if(result==0)
			    	System.out.println("Record not deleted");
			    else
			    	System.out.println("Record deleted");
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
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}

				try{
					if(cs!=null)
						cs.close();
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
