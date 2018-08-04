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

		// general settings
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	
	// read form1 data...
	String name=request.getParameter("name");
	String fname=request.getParameter("fname");
	String mname=request.getParameter("mname");
	String ms=request.getParameter("ms");
	
	if(ms.equals("single")){
		out.println("<center><form action='SecondServlet' method='post'>");
		out.println("Why do you want to marry:<input type='text' name='why'><br>");
		out.println("When do you want to marry:<input type='text' name='when'><br>");
		out.println("How much dowry you want:<input type='text' name='dowry'><br>");
		
		// add form1 data to dynamic form page as hidden box value
		
		out.println("<input type='hidden' name='hname' value="+name+"><br><br>");
		out.println("<input type='hidden' name='hfname' value="+fname+"><br><br>");
		out.println("<input type='hidden' name='hmname' value="+mname+"><br><br>");
		out.println("<input type='hidden' name='hms' value="+ms+"><br><br>");
		
		out.println("<input type='submit' value='submit'>");
		out.println("</center></form>");
	}
	
	else{
		out.println("<center><form action='SecondServlet' method='post'>");
		out.println("Spouse Name:<input type='text' name='why'><br><br>");
		out.println("no.of childrens<input type='text'name='when'><br><br>");
		
		//add form1/req data to dynamic forma page as hidden box value..
		
		out.println("<input type='hidden' name='hname' value="+name+"><br><br>");
		out.println("<input type='hidden' name='hfname' value="+fname+"><br><br>");
		out.println("<input type='hidden' name='hmname' value="+mname+"><br><br>");
		out.println("<input type='hidden' name='hms' value="+ms+"><br><br>");
		
		out.println("<input type='submit' value='submit'>");
		out.println("</center></form>");
	
		
	}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
