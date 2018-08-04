package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ErrorServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			System.out.println("Error Servlet:do get(--)");
		
			// include header content
			RequestDispatcher rd1=request.getRequestDispatcher("/HeaderServlet");
			rd1.include(request, response);
			
			//general settings
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			//display error page
			
			out.println("<h1><center>Internal problem</center></h1>");
			out.println("<a href='index.html'>home</a>");
			
			//footer content
			
			RequestDispatcher rd2=request.getRequestDispatcher("/footer.html");
			rd2.include(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("error servlet:dopost(--)");
		doGet(request, response);
	}

}
