package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //general settings
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 
		 //create Cookies (InMemory Cookies)
		 Cookie cookie1=new Cookie("AP","Amarvathi");
		 Cookie cookie2=new Cookie("TN","Chennai");
		 res.addCookie(cookie1); res.addCookie(cookie2);
		 //create Persistent cookies (having 2 mins expiry time)
		 Cookie cookie3=new Cookie("TS","hyd");
		 Cookie cookie4=new Cookie("MH","mumbai");
		 cookie3.setMaxAge(120); cookie4.setMaxAge(120);
		 res.addCookie(cookie3); res.addCookie(cookie4);
		 pw.println("<h1><center> Cookies are added Successfully</center></h1>");
         //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
