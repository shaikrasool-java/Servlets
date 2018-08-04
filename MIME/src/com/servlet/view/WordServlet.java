package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WordServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("application/msword");
		PrintWriter out=response.getWriter();
		
		out.println("<table border='1'>");
		out.println("<tr><th>Player</th><th>Team</th></tr>");
		out.println("<tr><td>Kohli</th><th>India</th></tr>");
		out.println("<tr><td>Dhoni</th><th>India</th></tr.");
		out.println("</table>");
		out.println("<a href='index.html'>back2home</a>");
		out.close();
	
	}

}
