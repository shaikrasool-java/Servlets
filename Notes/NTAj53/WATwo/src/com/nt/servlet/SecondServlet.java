package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  // general settings
		   PrintWriter pw=res.getWriter();
		   //set response content type
		   res.setContentType("text/html");
		   //read form data
		   int val=Integer.parseInt(req.getParameter("tval"));
		   //calculate cube value
		   int cube=val*val*val;
		   pw.println("<br>SecondServlet(WATwo): Cube Value"+cube);
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class

