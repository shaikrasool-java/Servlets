package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsCursorTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String initChars=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter initial chars of Emp name");
				initChars=sc.next().toUpperCase()+"%";
			}
			//register jdbc driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create CallableStatement obj
			if(con!=null)
				cs=con.prepareCall("{call fetch_AllEmpDetails(?,?)}");
			if(cs!=null){
				//register OUT params with JDBC type
				cs.registerOutParameter(2,OracleTypes.CURSOR);
				//set IN param value
				cs.setString(1,initChars);
				//execute pl/sql procedure
				cs.execute();
				//gather result from OUT param
				rs=(ResultSet)cs.getObject(2);
			}//if
			//proess the ResultSet
			if(rs!=null){
				
				while(rs.next()){
					flag=true;
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
				}//while
				if(flag==false)
					System.out.println("No Records found");
			}//if
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
		

	}

}
