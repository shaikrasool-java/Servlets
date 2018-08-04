package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			out.println("Hello......user...."+name);
			out.println("<a href='index.html'>back2home</a>");
			out.close();
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
