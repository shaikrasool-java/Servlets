package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmpDao;
import com.servlet.java.Emp;

public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int salary=0;
		int id=0;
		String i=request.getParameter("id");
		id=Integer.parseInt(i);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sal=request.getParameter("salary");
		salary=Integer.parseInt(sal);
		String desg=request.getParameter("desg");
		String country=request.getParameter("country");
		
		
		Emp e=new Emp();
		
		System.out.println("Browser values"+name+" "+password+" "+email+"  "+sal+" "+desg+" "+country);
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setSalary(salary);
		e.setDesg(desg);
		e.setCountry(country);
	
		int status=EmpDao.save(e);
		
		
		if(status>0){
			out.println("<p>record save successfully</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else{
			out.println("Sorry! unable to store record");
		}
		out.close();
		
	}

}
