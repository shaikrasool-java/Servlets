package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Servlet4 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession ses=null;
		PrintWriter out=null;
		ServletContext sc=null;
		
		//general settings
		
		out=response.getWriter();
		response.setContentType("text/html");
		
		// read and display request attribute values
		out.println("<br>Srevlet4: attr1 attribute value="+request.getAttribute("attr1"));
		
		//read and display session attribute value
		ses=request.getSession();
		out.println("<br>Servlet4:attr2 attribute value="+ses.getAttribute("attr2"));
		
		//read and display servlet context value
		
		sc=getServletContext();
		out.println("<br>Servlet4:attr3 attribute value="+sc.getAttribute("attr3"));
		
	
	
	}
@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
