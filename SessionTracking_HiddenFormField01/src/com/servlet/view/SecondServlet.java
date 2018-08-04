package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	
		//general settings
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		// read form1/request1 data
		
		String sname=request.getParameter("hname");
		String sfname=request.getParameter("hfname");
		String smname=request.getParameter("hmname");
		String sms=request.getParameter("ms");
		
		//read form2/request2 data
		
		String sval1=request.getParameter("why");
		String sval2=request.getParameter("when");
		
		out.println("name:"+sname+"<br><br>");
		out.println("father name:"+sfname+"<br><br>");
		out.println("mother name:"+smname+"<br><br>");
		out.println("marital status:"+sms+"<br><br>");
		out.println("why...:"+sval1+"<br><br>");
		out.println("when...."+sval2+"<br><br>");
	
	out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
