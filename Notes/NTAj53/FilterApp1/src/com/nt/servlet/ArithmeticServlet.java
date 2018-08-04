package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ArithmeticServlet: doGet(-,-)");
		 PrintWriter pw=null;
		 int val1=0,val2=0;
		 float div=0.0f;
		 //general settings
		  pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 val1=Integer.parseInt(req.getParameter("t1"));
		 val2=Integer.parseInt(req.getParameter("t2"));
		 //perform DIVISION
		 div=(float)val1/val2;
		 //Display result
		 pw.println("<h3>Result is ::::</h3>"+div);
		
		 //add hyperlink
		 pw.println("<br><a href='input.html'>home</a>");
		 //close stream 
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ArithmeticServlet: doPost(-,-)");
		doGet(req,res);
	}//doPost(-,-)

}//class
