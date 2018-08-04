package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// read form1 request1 data
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String mstatus=request.getParameter("ms");
		
	
		if(mstatus==null)
			mstatus="single";
		
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
				
			//general settings....
			
			if(mstatus.equals("married")){
				out.println("<form action='SecondServlet' method='post'>");
				out.println("<b>Spouse Name:</b><input type='text' name='st1'/>");
				out.println("<b>No.of Children:</b><input type='text' name='st2'/>");
				out.println("<input type='submit' value='submit'/>");
				out.println("</form>");
			}
			else{
				out.println("<form action='SecondServlet' method='post'>");
				out.println("<b>When do you want marry:<input type='text' name='st1'>");
				out.println("<b>why do you want marry:<input type='text' name='st2'>");
				out.println("<input type='submit' value='submit'>");
				out.println("</form>");
			}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
