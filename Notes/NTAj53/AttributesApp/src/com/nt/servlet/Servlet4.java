package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4  extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//Read and display request Attribute value
		pw.println("<br>(Srv4)attr1 request attribute value::"+req.getAttribute("attr1"));
		//Read and display session attribute value
		 HttpSession ses=req.getSession();
		 pw.println("<br>(Srv4) attr2 session attribute vlaue"+ses.getAttribute("attr2"));
			//Read and dispaly Servletcontext attribute value
			ServletContext sc=getServletContext();
			pw.println("<br>(Srv4) attr3 Servletcontext attribute value:"+sc.getAttribute("attr3"));

	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class
