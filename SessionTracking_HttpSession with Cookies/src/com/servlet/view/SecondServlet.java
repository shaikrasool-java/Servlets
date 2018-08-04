package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		
		//general settings..
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//read form2 data from FirstServlet
		
		String exp=request.getParameter("exp");
		String skills=request.getParameter("skills");
		
		// get access to session object
		
		HttpSession ses=request.getSession();
		
		// keep form 2 data with session
		
		ses.setAttribute("exp", exp);
		ses.setAttribute("skills", skills);
		
		//generate form3 dynamically.....
		
		out.println("<center><form action='ThirdServlet' method='post'>");
		out.println("<h1>Info 2....</h1><table border='1'>");
		out.println("<tr><th></th><th>enter details</th>");
		out.println("<tr><td>Enter Preference City</td>"
				+ "<td><input type='text' name='city'></td></tr>");
		out.println("<tr><td>Enter Expected Salary</td>"
				+ "<td><input type='text' name='salary'></td></tr>");
		out.println("<tr><td><td><input type='submit' value='Continue'></td></td></tr>");
		out.println("</center></table>");
		
		
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
