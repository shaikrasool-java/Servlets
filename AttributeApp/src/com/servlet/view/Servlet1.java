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
public class Servlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
			RequestDispatcher rd=null;
			PrintWriter out=null;
			HttpSession ses=null;
			ServletContext sc=null;
			
			//general setting
			
			out=response.getWriter();
			response.setContentType("text/html");
			
			// create request attribute
			
			request.setAttribute("attr1", "val1");
			
			// create session attribute
			
			ses=request.getSession();
			ses.setAttribute("attr2", "val2");
			
			// create servlet context attribute
			
			sc=getServletContext();
			sc.setAttribute("attr3", "val3");
			
			//forword the request to servlet component
			
			rd=request.getRequestDispatcher("/Servlet2");
			rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
