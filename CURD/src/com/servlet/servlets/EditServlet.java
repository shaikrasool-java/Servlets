package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmpDao;
import com.servlet.java.Emp;
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			
			out.println("<h1>Upadate Employee</h1>");
			String sid=request.getParameter("id");
			
			int id=Integer.parseInt(sid);
			
			Emp e=EmpDao.getEmployeeById(id);
			
			  out.print("<form action='EditServlet2' method='post'>");  
		        out.print("<table>");  
		        out.print("<tr><td>Id</td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
		        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getEmail()+"'/></td></tr>");
		        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getPassword()+"'/></td></tr>");  
		        out.print("<tr><td>Desg:</td><td><input type='text' name='desg' value='"+e.getDesg()+"'/></td></tr>");
		        out.print("<tr><td>Salary:</td><td><input type='text' name='salary' value='"+e.getSalary()+"'/></td></tr>");
		        out.print("<tr><td>Country:</td><td>");  
		        out.print("<select name='country' style='width:150px'>");  
		        out.print("<option>India</option>");  
		        out.print("<option>USA</option>");  
		        out.print("<option>UK</option>");  
		        out.print("<option>Other</option>");  
		        out.print("</select>");  
		        out.print("</td></tr>");  
		        
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");
		
		out.close();	
		
	}
		

}
