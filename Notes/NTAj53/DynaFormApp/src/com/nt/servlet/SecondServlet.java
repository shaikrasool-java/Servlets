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
		  //read form1/req1 data
		  String name=req.getParameter("name");
		  String fname=req.getParameter("fname");
		  String ms=req.getParameter("ms");
		  //read form2/req2 data
		  String f2val1=req.getParameter("f2t1");
		  String f2val2=req.getParameter("f2t2");
		  //read and display form1/req1 and form2/req2 data
		  pw.println("<br>Form1/req1 data"+name+"...."+fname+"...."+ms);
		  pw.println("<br>Form2/req2 data"+f2val1+"...."+f2val2);
		  //add hyperlink
		  pw.println("<a href='details.html'>home</a>");
		  //close stream
		  pw.close();
		  
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)

}//class
