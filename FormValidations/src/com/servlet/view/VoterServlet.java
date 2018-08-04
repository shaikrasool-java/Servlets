package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VoterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		int i=0;
		String vstatus=null;
		vstatus=request.getParameter("vflag");
		if(vstatus.equals("no")){
			//server form validation logic
			if(name.equals("")||name==null||name.length()==0){
				out.println("<font color=red> Name is mandatory</font>");
				System.out.println("validations from server side");
				return;
			}
			
			if(age.equals("")||age==null||age.length()==0){
				out.println("<font color=red>Age is mandatory</font>");
				System.out.println("age validation");
				return;
			}
			else{
				try{
					 i=Integer.parseInt(age);
				}
				catch(Exception e){
					out.println("<font color=red> Age must be numeric value</font>");
					
					
				}
			}
		}
		else{
			
			i=Integer.parseInt(age);
			
		}
		
		if(i>=18){
			out.println("<h1><font color='green'>"+name+" ..you're eligibile for vote </font></h1>");
		}
		else{
			out.println("<h1><font color='red'>"+name+" you're not eligible</font><h1>");
			out.println("<br><br><a href='index.html'><img src='tips.gif' width='100' height='100'></a>");
		}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
