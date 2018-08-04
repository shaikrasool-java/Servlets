package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	
	// general setting 
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	
		// get the values from submitted in first servlet...
		
		int i=0;
		int j=0;
		String salary=request.getParameter("income");
		i=Integer.parseInt(salary);
		String tax=request.getParameter("tax");
		j=Integer.parseInt(tax);
		
	// read form1/req1 data from cookies...
		
		Cookie ck[]=request.getCookies();
		String id=null;
		String name=null;
		String fname=null;
		String email=null;
		String password=null;
		String desg=null;
	//	String salary=null;
		String country=null;
		
		if(ck!=null){
			
			id=ck[0].getValue();
			name=ck[1].getValue();
			fname=ck[2].getValue();
			email=ck[3].getValue();
			password=ck[4].getValue();
			desg=ck[5].getValue();
		//	salary=ck[6].getValue();
			country=ck[6].getValue();
			
		}
		else{
			out.println("<center><h1 style='color:red'>Please enter all details...</h1></center>");
		}
		
		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("drive class excuted....");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("url excuted...");
			PreparedStatement ps=con.prepareStatement("insert into emp(id,name,fathername,email,password,desg,salary,tax,country) values(?,?,?,?,?,?,?,?,?)");
			System.out.println("query excuted...");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3,fname);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setString(6, desg);
			ps.setString(7, salary);
			ps.setString(8, tax);
			ps.setString(9, country);
			
			int result=ps.executeUpdate();
			System.out.println("updated query....");
			
			if(result==1){
				out.println("<center><h1 style='color:green'>Record successfully inserted....</h1></center>");
				out.println("<a href='index.html'>Back2Home</a>");
			
			}
			else{
				out.println("<center><h1 style='color:red'>Sorry! record not inserted</h1></center>");
				out.println("<a href='index.html'>Back2Home</a>");
			}
					} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		// display form1 and form2 data....
		
		out.println("<center><table border='1'><tr><th>Details of employee record</th>");
		out.println("<tr><td>Id:"+id+"</tr></td>");
		out.println("<tr><td>Name:"+name+"</tr></td>");
		out.println("<tr><td>Father Name:"+fname+"</tr></td>");
		out.println("<tr><td>Email:"+email+"</tr></td>");
		out.println("<tr><td>Password:"+password+"</tr></td>");
		out.println("<tr><td>Desg:"+desg+"</tr></td>");
		out.println("<tr><td>Salary:"+salary+"</tr></td>");
		out.println("<tr><td>Tax:"+tax+"</tr></td>");
		out.println("<tr><td>Country:"+country+"</tr></td>");
		out.println("</center></table>");

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
