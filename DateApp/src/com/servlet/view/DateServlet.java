package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("welcome to servlet");
		Date d=new Date();
		out.println("<b><i>Data and time:</b></i>"+d);
		
		out.close();
		
		
	}

}
