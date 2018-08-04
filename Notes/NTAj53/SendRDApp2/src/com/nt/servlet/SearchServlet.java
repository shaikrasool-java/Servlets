package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   //General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		String ss=req.getParameter("tsearch");
		String engg=req.getParameter("engg");
		//prpeare url with query String to perform send Redirection with Search Engg
		String url=null;
		if(engg.equals("google")){
			url="https://google.co.in/search?q="+ss;
		}
		else if(engg.equals("bing")){
			url="http://bing.com/search?q="+ss;
		}
		else{
			url="http://in.search.yahoo/search?p="+ss;
		}
		//perform SendRedirection
		System.out.println("Before SendRedirct(-)");
		res.sendRedirect(url);
		RequestDispatcher rd=req.getRequestDispatcher("/hello.html");
		rd.include(req,res);
		System.out.println("After SendRedirct(-)");
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class

