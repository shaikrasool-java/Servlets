package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		out.println("Welcome:"+name);
		out.println("<a href='SecondServlet?name="+name+"'>visit</a>");
		
		out.close();
	}
	
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
	

}
