package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		try {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			out.print("Hello >>>"+name);
			out.print("<a href='index.html'>back to home</a>");
			out.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	
	}

}
