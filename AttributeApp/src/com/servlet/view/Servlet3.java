package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out=null;
		HttpSession ses=null;
		ServletContext sc=null;
		
		//general setting 
		out=response.getWriter();
		response.setContentType("text/html");
		
		//read adn display request attribute value
		out.println("<br>Servlet3:attr1 attribute value="+request.getAttribute("attr1"));
		
		//read and display session attubute value
		ses=request.getSession();
		out.println("<br>Servlet3:attr2 attribute value="+ses.getAttribute("attr2"));
		
		//read and display servlet context attribute value
		sc=getServletContext();
		out.println("<br>Servlet3:attr3 attribute value="+sc.getAttribute("attr3"));
		
		RequestDispatcher rd=request.getRequestDispatcher("/Servlet4");
		rd.forward(request, response);
		
	
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
