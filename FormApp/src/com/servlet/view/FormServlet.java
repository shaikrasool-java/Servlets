package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int age=0;
		String name=request.getParameter("name");
	    age=Integer.parseInt(request.getParameter("age"));
		String  gender=request.getParameter("gender");
		String maritalstatus=request.getParameter("maritalstatus");
		String address=request.getParameter("address");
		String qualification=request.getParameter("qualification");
		String course[]=request.getParameterValues("course");
		String hobbies[]=request.getParameterValues("hobbies");
		
		if(gender.equalsIgnoreCase("M")){
		if(age<=5)
			out.println(name+"....you're a baby boy...");
			else if(age<=12)
				out.println(name+"...you're a small boy....");
			else if(age<=16)
				out.println(name+"...you're a teenage boy....");
				else if(age<=20)
					out.println(name+"...you're a middle age boy");
					else if(age<30)
						out.println(name+"...you're a young man");
					else if(age<50)
						out.println(name+"....you're senior citizen...go and take rest.....");
		}
		else if(gender.equalsIgnoreCase("F")){
			if(age>=5)
				out.println(name+"...you're a baby girl...");
				else if(age<=12)
					out.println(name+"....you're a small girl....");
				else if(age<=16)
					out.println(name+"...you're a teenage girl....");
					else if(age<=20)
						out.println(name+"...you're a middle age girl");
						else if(age<30)
							out.println(name+"...you're a young woman");
						else if(age<50)
							out.println(name+"....you're senior citizen...go and take rest.....");
		}
		out.println("<br>name="+name);
		out.println("<br>age="+age);
		out.println("<br>gender="+gender);
		out.println("<br>Marital Status="+maritalstatus);
		out.println("<br>Address="+address);
		out.println("<br>Qualification="+qualification);
		out.println("<br>Course="+Arrays.toString(course));
		out.println("<br>Hobbies="+Arrays.toString(hobbies));
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
