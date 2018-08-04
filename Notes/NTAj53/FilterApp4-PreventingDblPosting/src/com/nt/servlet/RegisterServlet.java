package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerurl")
public class RegisterServlet extends HttpServlet {
       
 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		//display form data
		pw.println("<h1> Name is:</h1>"+name);
		
     pw.close();		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
