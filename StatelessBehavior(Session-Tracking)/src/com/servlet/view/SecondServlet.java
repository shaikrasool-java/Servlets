package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		// read 1form  second form data
		
		out.println("<br>First Form Data is");
		out.println("<br>Name is="+request.getParameter("name"));
		out.println("<br>Age is="+request.getParameter("age"));
		out.println("<br>Marital status="+request.getParameter("ms"));
		out.println("<br><br>Second form data is <br><br> spouse name:"+request.getParameter("st1")+"<br><br>"+request.getParameter("st2"));
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
