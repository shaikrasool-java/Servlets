package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//general settings
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//read form 3 request data....
		String city=request.getParameter("city");
		String salary=request.getParameter("salary");
		
		//get access to session object
		
		HttpSession ses=request.getSession();

		// read form1 /request1 and form2/request2 data from session attributes...
		
		String name=(String)ses.getAttribute("name");
		String address=(String)ses.getAttribute("address");
		String age=(String)ses.getAttribute("age");
		String exp=(String)ses.getAttribute("exp");
		String skills=(String)ses.getAttribute("skills");
		
	//insert from1/request, form2/request2 and form3/request3 values as record....in db table
		// table name is "info"....
		
//sql query
//"create table info(name varchar2(20), addr varchar2(20), age number(2), exp number(2),skills varchar2(20),city varchar2(20),salary number(10));"
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver class executed....");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			System.out.println("url executed");
			PreparedStatement ps=con.prepareStatement("insert into info(name,addr,age,exp,skills,city,salary) values(?,?,?,?,?,?,?)");
			System.out.println("prepared statment query excuted");
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, Integer.parseInt(age));
			ps.setInt(4, Integer.parseInt(exp));
			ps.setString(5, skills);
			ps.setString(6, city);
			ps.setString(7, salary);

			
			int i=ps.executeUpdate();
			
			System.out.println("query executed");
			// invalidate the session
			ses.invalidate();
			
			if(i>0)
			{
				out.println("<center><h2>Successfully inserted</h2></center><br/>");
				out.println("<a href='index.html'>back2home</a>");
				
				
			}
			
			
			
			else{
				
				out.println("<center><h2>Sorry some internal problems</h2></center><br/>");
				out.println("<a href='index.html'>back2home</a>");
				
				
			}
			
		} catch (Exception e) {
System.out.println(e.getMessage());		}
		
		
		
		
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
