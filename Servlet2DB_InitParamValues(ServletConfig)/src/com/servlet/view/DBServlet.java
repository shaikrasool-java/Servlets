package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DBServlet extends HttpServlet {
	
	Connection con;
	PreparedStatement ps;
	
	public void init(){
		
		try{
			
			ServletConfig sc=getServletConfig();
			
			
			// read init param values
			
			String s1=sc.getInitParameter("driver");
			String s2=sc.getInitParameter("url");
			String s3=sc.getInitParameter("user");
			String s4=sc.getInitParameter("password");
			
			//create jdbc  connection obj
		Class.forName(s1);
		con=DriverManager.getConnection(s2,s3,s4);
		ps=con.prepareStatement("select id,name,email,desg,salary,country from employee where id=?");
			
		}
		catch (Exception e) {
			System.out.println("Geeting exeption");
			System.out.println(e.getMessage());
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
			
		
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			out.println("<h1 style='color:green'>Employee details with this id="+id+"</h1>");
			out.println("<br>Employee id="+rs.getInt(1));
			out.println("<br>Employee name="+rs.getString(2));
			out.println("<br>Employee Email="+rs.getString(3));
			out.println("<br>Employee Desg="+rs.getString(4));
			out.println("<br>Employee Salary="+rs.getInt(5));
			out.println("<br>Employee Country="+rs.getString(6));
			out.println("<br><br><a href='index.html'>back2home</a>");
		}
		else{
		out.println("No Employee found....");
		out.println("<br><br><a href='index.html'>back2home</a>");
		}
		rs.close();
		out.close();
		
		}catch (Exception e) {
			
		System.out.println(e.getMessage());
		}
		
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
		
		public void destroy(){
			try {
				if(ps!=null);
				ps.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				
				if(con!=null);
				con.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}

}
