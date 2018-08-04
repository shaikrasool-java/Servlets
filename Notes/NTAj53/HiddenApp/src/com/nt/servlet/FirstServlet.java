package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	 @Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  // general settings
		   PrintWriter pw=res.getWriter();
		   res.setContentType("text/html");
		   //read form1/req1 data
		   String pname=req.getParameter("name");
		   String pfname=req.getParameter("fname");
		   String  mstatus=req.getParameter("ms");
		   //Generate form2 dynamically from here
		   if(mstatus.equals("married")){
			   pw.println("<form action='surl' method='post'>");
			   pw.println("Spouse name:<input type='text' name='f2t1'><br>");
			   pw.println("No.of childs:<input type='text' name='f2t2'><br>");
			   pw.println("<input type='hidden' name='hname' value="+pname+">");
			   pw.println("<input type='hidden' name='hfname' value="+pfname+">");
			   pw.println("<input type='hidden' name='ms' value="+mstatus+">");
			   pw.println("<input type='submit' value='submit'>");
		   }
		   else{
			   pw.println("<form action='surl' method='post'>");
			   pw.println("When do u want to marry:<input type='text' name='f2t1'><br>");
			   pw.println("Why do u wanto to marry :<input type='text' name='f2t2'><br>");
			   pw.println("<input type='hidden' name='hname' value="+pname+">");
			   pw.println("<input type='hidden' name='hfname' value="+pfname+">");
			   pw.println("<input type='hidden' name='ms' value="+mstatus+">");
			   pw.println("<input type='submit' value='submit'>");
		   }
		   
		   //close stream
		   pw.close();
	}//doGet(-,-)
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}//doPost(-,-)
	
}//class
