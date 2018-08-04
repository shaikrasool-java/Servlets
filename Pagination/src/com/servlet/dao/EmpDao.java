package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.model.Emp;

public class EmpDao {
	
	public static Connection getConnection(){
		
		Connection con=null;
		
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("i am a connection object "+con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
			}
	
	public static List<Emp> getRecords(int start,int total){
		
		List<Emp> list=new ArrayList<Emp>();
		System.out.println("I am from Dao class getRecords");
		
		try { 
			System.out.println("enter into try block");
	
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			System.out.println("i am resultset"+rs);
			while(rs.next()){
				
				Emp e=new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setCountry(rs.getString(7));
				list.add(e);
				}
			System.out.println("List of records"+list);
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		}
	}
