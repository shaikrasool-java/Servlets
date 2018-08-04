package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");

		System.out.println("broser values"+name+" and"+password);
		
		if(password.equals("admin")){
			out.println("<h3>You're successfully Login...");
			out.println(" Welcome:"+name);
			out.println("<a href='link.html' >Go to Home</a>");
			
			Cookie ck=new Cookie("name", name);
			response.addCookie(ck);
			
		}
		else{
			out.print("Sorry! user name and passwords missmatch...");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
	}

}
