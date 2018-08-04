package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String ss=req.getParameter("tsearch");
		//generate hyperlink having href url pointing to Google
		pw.println("<a href='https://google.co.in/search?q="+ss+"'> go to google</a>");
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
