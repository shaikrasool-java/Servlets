package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out=null;
		int val1=0;
		int val2=0;
		String s=null;
		
		response.setContentType("text/html");
		out=response.getWriter();
		s=request.getParameter("s1");
		
		if(s.equals("link1")){
			out.println("Date an time:"+new Date());
		}
		else if(s.equals("link2")){
			out.println("system properties:"+System.getProperties());
		}
		else if(s.equals("add")){
			val1=Integer.parseInt(request.getParameter("first"));
			val2=Integer.parseInt(request.getParameter("second"));
			out.println("Addition of two numbers result is:"+(val1+val2));
		}
		else if(s.equals("sub")){
			val1=Integer.parseInt(request.getParameter("first"));
			val2=Integer.parseInt(request.getParameter("second"));
			out.println("Subtraction of two numbers, result is:"+(val1-val2));
		}
		
		else{
			val1=Integer.parseInt(request.getParameter("first"));
			val2=Integer.parseInt(request.getParameter("second"));
			out.println("multiplication of two numbers, the result is:"+(val1*val2));
		}
		out.println("<a href='index.html'>back2home</a>");
		}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
