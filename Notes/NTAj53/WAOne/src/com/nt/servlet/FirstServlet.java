package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //general settings
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 int val=Integer.parseInt(req.getParameter("tval"));
		 //calc square value
		 int square=val*val;
		 pw.println("FirstServlet(WAONE): Square value"+square);
		 //include the repsonse of  Dest Webcomp's SecondServlet 
		    // get Servletcontext obj of  current web application(WAOne)
		    ServletContext sc1=getServletContext();
		    //get Servletcontext obj of  Dest web application(WATwo)
		    ServletContext sc2=sc1.getContext("WATwo");
		    //create RequestDispatcher obj
		    RequestDispatcher rd=sc2.getRequestDispatcher("/surl");
		    rd.include(req,res);
	}//doGet(-,-)
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)

}//class
