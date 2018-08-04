package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 // General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1  data
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		//create cookies having form1/req1 data
		Cookie cookie1=new Cookie("name",name);
		Cookie cookie2=new Cookie("fname",fname);
		//add coookies to the response
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		//Generate form2 Dynamically from here
		pw.println("<h1><center> Submit Income Details </center></h1>");
		pw.println("<form action='surl' method='post'>");
		pw.println("Income : <input type='text' name='income'><br>");
		pw.println("Tax : <input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class

