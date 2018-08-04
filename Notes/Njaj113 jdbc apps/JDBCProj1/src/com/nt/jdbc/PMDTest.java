package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PMDTest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ParameterMetaData pmd=null;
		int count=0;
		try{
			//register driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			//create PreparedStatement obj
			if(con!=null)
				ps=con.prepareStatement("insert into student values(?,?,?)");
			//create ParameterMetaData obj
			if(ps!=null)
				pmd=ps.getParameterMetaData();
			//Display various details about the params
			if(pmd!=null){
			 count=pmd.getParameterCount();
			  for(int i=1;i<=count;++i){
				  System.out.println("Parameter number"+i);
				  System.out.println("parameter mode"+pmd.getParameterMode(i));
				  System.out.println("parameter type name"+pmd.getParameterTypeName(i));
				  System.out.println("Parameter is signed"+pmd.isSigned(i));
				  System.out.println("Parameter is nullable"+pmd.isNullable(i));
				  System.out.println("Parameter scale area "+pmd.getScale(i));
				  System.out.println("Parameter precision area "+pmd.getPrecision(i));
			  }//for
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
		}//finally
	}//main
}//class
