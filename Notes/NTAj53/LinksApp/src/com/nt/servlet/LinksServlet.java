package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 // general settings
		 PrintWriter pw=res.getWriter();
		 //set content type
		 res.setContentType("text/html");
		 //read additional req param values
		 String pval=req.getParameter("s1");
		 //proess the request based on the hyperlink that is clicked
		 if(pval.equalsIgnoreCase("link1")){
			 pw.println("<h1>Date and Time "+new Date()+"</h1>");
		 }
		 else if(pval.equalsIgnoreCase("link2")){
			 Locale locale[]=Locale.getAvailableLocales();
			 pw.println("<h1>All Languages</h1>");
			 for(Locale lc:locale){
				 pw.println(lc.getDisplayLanguage()+"<br>");
			 }//for
		 }//else
		 else{
			 Locale locale[]=Locale.getAvailableLocales();
			 pw.println("<h1>All countries</h1>");
			 for(Locale lc:locale){
				 pw.println(lc.getDisplayCountry()+"<br>");
			 }//for
		 }//else
		 //add hyperlink
		 pw.println("<a href='links.html'>home</a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class
