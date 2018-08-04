package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DBServlet extends HttpServlet {

	Connection con;
	PreparedStatement ps;
	
	
	public void init(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered drive....");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 System.out.println("creating connection");
			 ps=con.prepareStatement("select id,name,desg,salary,country from employee where id=?");
			 System.out.println("sql query....executing");
		
		}
		catch(Exception e){

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	try{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("id"));
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
	if(rs.next()){
		out.println("<br>Employee id: "+rs.getInt(1));
		out.println("<br>Employee Name: "+rs.getString(2));
		out.println("<br>Employee desg: "+rs.getString(3));
		out.println("<br>Employee salary: "+rs.getInt(4));
		out.println("<br>Employee country: "+rs.getString(5)+"</br>");
		out.println("<a href='index.html'>back2home</a>");
	}
		
	else{
		out.println("<h1 style='color:red'>No employee record in our database with this is id="+id+"</h1>");
		out.println("<a href='index.html'>back2home</a>");
	
	}
	
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			doGet(request, response);
	}
		public void destroy(){
		try {
			if(ps!=null)
				ps.cancel();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(con!=null)
				con.close();
			
		} catch (Exception e) {
		
		e.printStackTrace();
		
		}
	}
	
	
}
