package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	try{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		out.print("Welcome:"+name);
		
		Cookie ck=new Cookie("name",name);
		response.addCookie(ck);
		
		
		// creating submit button
		
		out.print("<form action='SecondServlet'>");
		out.print("<input type='submit' value='go'/>");
		out.print("</form>");

		out.close();
		
	}
	catch (Exception e) {

System.out.println(e.getMessage());
	}
	}

}	
