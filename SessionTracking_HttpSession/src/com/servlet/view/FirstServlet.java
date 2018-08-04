package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			out.println("Welcome:"+name);
			
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			out.println("<a href='SecondServlet'>visit</a>");
			
			out.close();
			
			
					
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
