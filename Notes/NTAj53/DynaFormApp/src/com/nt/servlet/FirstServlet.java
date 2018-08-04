package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
  @Override
public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   // general settings
	  PrintWriter pw=res.getWriter();
	 //set response content type
	  res.setContentType("text/html");
	  //read form1 data(request1 data)
	  String name=req.getParameter("name");
	  String fname=req.getParameter("fname");
	  String mstatus=req.getParameter("ms");
	  if(mstatus==null)
		  mstatus="single";
	  //Generate form2 dynamically from here
	  if(mstatus.equalsIgnoreCase("married")){
		  pw.println("<form action='s2url' method='post'>");
		  pw.println("Spouse name: <input type='text' name='f2t1'><br>");
		  pw.println("No.children: <input type='text' name='f2t2'><br>");
		  pw.println("<input type='submit' value='submit'>");
		  pw.println("</form>");
	  }
	  else{
		  pw.println("<form action='s2url' method='get'>");
		  pw.println("When do u want to marry: <input type='text' name='f2t1'><br>");
		  pw.println("why do u want to marry: <input type='text' name='f2t2'><br>");
		  pw.println("<input type='submit' value='submit'>");
		  pw.println("</form>");
	  }
	  //close stream
	  pw.close();
   }//doGet(-,-)
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}//doPost(-,-)
	
}//class
