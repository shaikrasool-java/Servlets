package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCapabilities {

	public static void main(String[] args) {
		Connection con=null;
		DatabaseMetaData dbmd=null;
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			//get Metadata
			dbmd=con.getMetaData();
			//The DB details are
			if(dbmd!=null){
			System.out.println("DB name"+dbmd.getDatabaseProductName());
			System.out.println("DB version"+dbmd.getDatabaseProductVersion());
			/*System.out.println("DB Major Version"+dbmd.getDatabaseMajorVersion());
			System.out.println("DB Minor Version"+dbmd.getDatabaseMinorVersion()); */
			System.out.println("JDBC  Major Version"+dbmd.getJDBCMajorVersion());
			System.out.println("JDBC  Minor Version"+dbmd.getJDBCMinorVersion());
			System.out.println("JDBC Driver  Major Version"+dbmd.getDriverMajorVersion());
			System.out.println("JDBC Driver  Minor Version"+dbmd.getDriverMinorVersion());
			System.out.println("All SQL keywords"+dbmd.getSQLKeywords());
			System.out.println("All numeric functions"+dbmd.getNumericFunctions());
			System.out.println("All System Functions"+dbmd.getSystemFunctions());
			System.out.println("All String functions"+dbmd.getStringFunctions());
			System.out.println("Max Table name lenggh"+dbmd.getMaxTableNameLength());
			System.out.println("Max column name lenggh"+dbmd.getMaxColumnNameLength());
			System.out.println("Max Row Size"+dbmd.getMaxRowSize());
			System.out.println("Max cols in Select Query"+dbmd.getMaxColumnsInSelect());
			System.out.println("Max cols in dB table"+dbmd.getMaxColumnsInTable());
			System.out.println("Max Connections to DB"+dbmd.getMaxConnections());
			}///if
		}///try
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
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class
