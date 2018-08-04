package com.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmpDao;
import com.servlet.java.Emp;
public class EditServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			response.setContentType("text/html");
		
			PrintWriter out=response.getWriter();
			
			int salary=0;
			
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String desg=request.getParameter("desg");
			String sal=request.getParameter("salary");
			salary=Integer.parseInt(sal);
			String country=request.getParameter("country");
			
			Emp e=new Emp();
			
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setPassword(password);
			e.setDesg(desg);
			e.setSalary(salary);
			e.setCountry(country);
				
			int status=EmpDao.update(e);
					
					if(status>0){
						
						response.sendRedirect("ViewServlet");
					}
					else{
						out.println("sorry! unable to update record");
					}
					out.close();
	}

}
