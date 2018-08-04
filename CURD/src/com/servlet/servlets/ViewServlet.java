package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmpDao;
import com.servlet.java.Emp;



public class ViewServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			response.setContentType("text/html");
			
			PrintWriter out=response.getWriter();
			System.out.println("i am from viewservlet");
			out.println("<a href='index.html'>Add New Employee</a>");
			out.println("<h1>Employee List</h1>");
			
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Salary</th><th>Desg</th><th>Country</th><th>Edit</th><th>Delete</th></tr>"); 
		for(Emp e:list){
			
			//out.print("<table border='1' width=100%");
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"
					+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getSalary()+"</td><td>"+e.getDesg()+"</td><td>"+e.getCountry()
					+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td>"+
			 		"<a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
				
			
		}
		
		out.print("</table>");
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
		
	}
}
