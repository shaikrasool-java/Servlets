package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookiesServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //general settings
			 PrintWriter pw=res.getWriter();
			 res.setContentType("text/html");
			//read cookies
			 Cookie cks[]=req.getCookies();
			 pw.println("<table>");
			 pw.println("<tr><td>Cookie name</td><td>Cookie value </td></tr>");
			 if(cks!=null){
			   for(Cookie ck:cks){
				 pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
			   }//for
			 }//if
			 //close stream
			 pw.close();
  	}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}//doPost(-,-)
}//class
