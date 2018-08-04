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
	
		try {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			HttpSession session=request.getSession(false);
			
			String name=(String)session.getAttribute("name");

			out.println("Helloooo:...."+name);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
