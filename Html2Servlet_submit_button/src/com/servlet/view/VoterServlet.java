package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VoterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		int i=Integer.parseInt(age);
		
		if (i>=18) {
			out.println("<h1 style='color:green'>"+name+":  you're eligibile for vote....</h1>");
			
		} else {
			out.println("<h1 style='color:red'>"+name+":   you're still child!!! wiat for few years.....</h1>");
			
			out.println("<a href='index.html'>back</a>");
		}
	}

}
