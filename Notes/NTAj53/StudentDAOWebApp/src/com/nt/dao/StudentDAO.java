package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String  STUDENT_INSERT_QUERY="INSERT INTO DAO_STUDENT VALUES(?,?,?,?,?)";
	
	private Connection makeConnection(){
			DataSource ds=null;
			InitialContext ic=null;
			Connection con=null;
			try{
			//Get DataSource obj ref from jndi registry
			 ic=new InitialContext();
			 ds=(DataSource)ic.lookup("DsJndi");
			 // get con obj from jdbc con pool
			 con=ds.getConnection();
			 return con;
			}//try
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}//makeConnection()
	
	public  int  insert (StudentBO bo){
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try{
			// get Con obj from jdbc con pool
			con=makeConnection();
			//create PrpearedStatement obj
			ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			//set values to Query params
			ps.setInt(1,bo.getSno());
			ps.setString(2,bo.getSname());
			ps.setInt(3,bo.getTotal());
			ps.setFloat(4,bo.getAvg());
			ps.setString(5, bo.getResult());
			//execute the Query
			result=ps.executeUpdate();
			
		}//try
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close objs
			try{
			if(ps!=null)
				ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null){
					con.close();
				}//if
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
		return result;
	}//methid
}//class
