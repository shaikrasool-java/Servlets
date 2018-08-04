package com.servlet.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String search=null;
		String engine=null;
		String url=null;
		
	search=request.getParameter("search");
	engine=request.getParameter("engine");
	
	// prepare url with query string for send redirection
	
	if(engine.equals("google")){
		url="https://www.google.co.in/search?q="+search;
	}
	else if(engine.equals("bing")){
		url="http://www.bing.com/search?q="+search;
	}
	else if(engine.equals("yahoo")){
		url="http://in.search.yahoo.com/search?p="+search;
	}
	System.out.println("Before Search Servlet:sendRedirect(-)");
	response.sendRedirect(url);
	
	RequestDispatcher rd=request.getRequestDispatcher("index.html");
	rd.include(request, response);
	
	System.out.println("After search servlet: sendRedirect(-)");
	
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
