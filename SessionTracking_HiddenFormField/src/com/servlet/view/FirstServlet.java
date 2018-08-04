package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			
			out.println("welcome...>>>"+name);
			out.print("<form action='SecondServlet'>");
			out.print("<input type='hidden' name='name' value='"+name+"'/>");
			out.print("<input type='submit' value='go'/>");
			out.print("</form>");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
