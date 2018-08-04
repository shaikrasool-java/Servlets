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
public class Servlet2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		// general settings
		out=response.getWriter();
		response.setContentType("text/html");
		
		//read and display request attrubute value
		out.println("<br>Servlet2:attr1 attribute value="+request.getAttribute("attr1"));
	
		//read and display session attribute value
		
		ses=request.getSession();
		out.println("<br>Servlet2:attr2 attribute value+"+ses.getAttribute("attr2"));
		
		//read and display servlet context attribute values
		
		sc=getServletContext();
		out.println("<br>Servlet2:attr3 attribute value="+sc.getAttribute("attr3"));
		
		// forword request to third servlet
		
		 rd=request.getRequestDispatcher("/Servlet3");
		rd.forward(request, response);
		
		
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
