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
			
			PrintWriter out=response.getWriter();
		out.println("Page successfully displayed..");
		out.println("<center><b>the user name is="+request.getRemoteUser()+"</center></b>");
		out.println("<center><b>the auth auth type is="+request.getAuthType()+"</center></b>");
		out.println("congradulations you're login "
				+ "successfully");
		out.close();
	}

	
}
