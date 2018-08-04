package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   String user=null,pwd=null;
		//general settings
	   pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		user=req.getParameter("uname");
		pwd=req.getParameter("pwd");
		if(user.equals("raja@gmail.com") && pwd.equals("rani")){
			pw.println("<h1> Valid Credentials </h1>");
		}
		else{
			pw.println("<h1> InValid Credentials </h1>");
		}
		pw.println("<br>user="+user+" password="+pwd);
		//close stream 
		pw.close();
	}//doGet(-,-)
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
