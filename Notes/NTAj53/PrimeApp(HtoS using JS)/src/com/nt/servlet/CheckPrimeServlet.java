package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPrimeServlet  extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int no=Integer.parseInt(req.getParameter("no"));
		//check given no.of prime number or not
		boolean flag=true;
		for(int i=2;i<no;++i){
			if(no%i==0){
				flag=false;
				break;
			}
		}//for
		if(flag==false){
			pw.println("<h1>"+no +" is not a prime number </h1>");
		}
		else{
			pw.println("<h1>"+no +" is  a prime number </h1>");
		}
		//add hyperlink
		pw.println("<a href='form.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class

