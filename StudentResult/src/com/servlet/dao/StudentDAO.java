package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.bo.StudentBO;

public class StudentDAO {

	private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
	
	public int insert(StudentBO bo){
		
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try{
			//create initial context.............
			
			ic=new InitialContext();
			
			// get data source object through lookup operation........
			
			ds=(DataSource)ic.lookup("java:/comp/env/mypool");
			
			//get connection from jdbc connection pool
			
			con=ds.getConnection();
			
			// create prepared statement object
			
			ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			
			// set values into query params....
			
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			
			result=ps.executeUpdate();
		
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
				
		finally{
			try{
				if(ps!=null)
					ps.close();
			}
			catch (SQLException sql) {

				System.out.println(sql.getMessage());
			}
			
			
			try{
				if(con!=null)
					con.close();
			}
			catch (SQLException e1) {
				System.out.println(e1.getMessage());
				
				
			}
			return result;
		}
		
	}
	
	
}
