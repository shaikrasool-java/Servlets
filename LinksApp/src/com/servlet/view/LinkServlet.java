package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String pval=request.getParameter("s1");
		
		if(pval.equalsIgnoreCase("link1")){
		
	out.println("<h1>Date and time"+new Date()+"</h1>");
	
		}
	else if(pval.equalsIgnoreCase("link2")) {
		
		Locale locale[]=Locale.getAvailableLocales();
		out.println("<h1>All Languages</h1>");
		for(Locale lo:locale){
			
			out.println(lo.getDisplayLanguage()+"<br>");
			
		            }
			}
	
	else{
		Locale locale[]=Locale.getAvailableLocales();
		out.println("<h1>All Countries</h1>");
		for(Locale lo:locale){
			out.println(lo.getDisplayCountry());
		}
	}
	out.println("<a href='index.html'>home</a>");
	out.close();
			
	}

}
