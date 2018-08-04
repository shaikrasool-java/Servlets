package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //general settings
		  PrintWriter pw=res.getWriter();
		  res.setContentType("text/html");
		  //read s1 req param value
		  String pval=req.getParameter("s1");
		  if(pval.equalsIgnoreCase("add")){
			  int val1=Integer.parseInt(req.getParameter("t1"));
			  int val2=Integer.parseInt(req.getParameter("t2"));
			  pw.println("Addition::"+(val1+val2));
		  }
		  else  if(pval.equalsIgnoreCase("sub")){
			  int val1=Integer.parseInt(req.getParameter("t1"));
			  int val2=Integer.parseInt(req.getParameter("t2"));
			  pw.println("Subtraction::"+(val1-val2));
		  }
		  else if(pval.equalsIgnoreCase("mul")) {
			  int val1=Integer.parseInt(req.getParameter("t1"));
			  int val2=Integer.parseInt(req.getParameter("t2"));
			  pw.println("Multiplication::"+(val1*val2));
		  }
		  else if(pval.equalsIgnoreCase("link1")){
			  pw.println("Date and time "+new Date());
		  }
		  else{
			  pw.println("Date and time "+System.getProperties());
		  }
		  //add hyperlink
		  pw.println("<a href='form.html'>home</a>");
         //close stream
		  pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class

