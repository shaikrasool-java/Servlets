package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.java.Emp;

public class EmpDao {
	

	public static Connection getConnection(){
//		System.out.println("enter into connetion");
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("class loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			System.out.println("connection established");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
public static int save(Emp e){
	 int status=0;
	 try {
		 Connection con=EmpDao.getConnection();
		 PreparedStatement ps=con.prepareStatement
				 ("insert into employee(id,name,email,password,desg,salary,country) values (?,?,?,?,?,?,?) ");
		 System.out.println("values taking form browser.....");
		ps.setInt(1, e.getId());
		System.out.println("id loaded...");
		 ps.setString(2,e.getName());
		 System.out.println("name loaded");
		 ps.setString(3, e.getEmail());
		 System.out.println("email loaded");
		 ps.setString(4, e.getPassword());
		 System.out.println("password loaded");
		 ps.setString(5, e.getDesg());
		 System.out.println("desg loaded...");
		ps.setInt(6, e.getSalary());
		System.out.println("salary loaded...");
		ps.setString(7, e.getCountry());
		System.out.println("country loaded..");
		
		System.out.println("data in prepared statement"+ps.toString());
		
		
		
		
		status=ps.executeUpdate();
		con.close();
	} catch (Exception e2) {
		System.out.println(e2.getMessage());
	}
	 return status;
}

public static List<Emp>getAllEmployees(){
	
	List<Emp> list=new ArrayList<Emp>();
	
	try {
		System.out.println("From getAllEmployees");
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("select*from employee");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(7));
			e.setSalary(rs.getInt(6));
			e.setDesg(rs.getString(5));
			list.add(e);
			
		}
		con.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	return list;
}
		
public static int delete(int i){
	
	int status=0;
	
	try {
		
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
		ps.setInt(1,i);
		status=ps.executeUpdate();
		
		con.close();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return status;
}


public static int update(Emp e){
	
	int status=0;
	
	try {
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement
				("update employee set name=?,password=?,email=?,desg=?,salary=?,country=? where id=?");
	
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(6, e.getCountry());
		ps.setInt(5, e.getSalary());
		ps.setString(4, e.getDesg());
		ps.setInt(7, e.getId());
		
		status=ps.executeUpdate();
		System.out.println("update status"+status);
		
		con.close();
		
		
		
	} catch (Exception e2) {
	System.out.println("Not updated"+e2.getMessage());
	}
	
	return status;
	
	}
		
	public static Emp getEmployeeById(int id){	
		
		Emp e=new Emp();
		
		try {
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select*from employee where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(7));
				e.setSalary(rs.getInt(6));
				e.setDesg(rs.getString(5));
				
			}
			
			con.close();
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return e;
		
	}
}

