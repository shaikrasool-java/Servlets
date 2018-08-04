package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("login.html").include(request, response);
	
		
		Cookie ck[]=request.getCookies();
		if(ck!=null){
			String name=ck[0].getValue();
			if(!name.equals("")||name!=null);
			out.print("<b>Welcome to Profile:..</br>");
			out.print("<b>Welcome,  "+name+"</br>");
			out.print("<a href='link.html'>back</a>");
			
		}
		
		else{
			out.print("please Login first...");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	out.close();
	}

}
