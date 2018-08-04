package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//general settings
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
	//read data ...// request data
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String  age=request.getParameter("age");
		
	//create session for browser window...
		
		HttpSession ses=request.getSession();
		
	//keep form 1 data in session attributes...
		ses.setAttribute("name", name);
		ses.setAttribute("address", address);
		ses.setAttribute("age", age);

		
	//generate form2 dynamically....
		
		out.println("<center><form action='SecondServlet' method='post'>");
		out.println("<h1>Info....</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>enter..</th><th>enter details</th></tr>");
		out.println("<tr><td>Enter No.of Experience:</td>"
				+ "<td><input type='text' name='exp'></td></tr>");
		out.println("<tr><td>Select Skill:</td>"
				+ "<td><select name='skills'>");
		out.println("<option value='java'>java/j2ee</option>");
		out.println("<option value='.net'>.net</option>");
		out.println("<option value='oracle'>oracle10g/11g</option>");
		out.println("<option value='xml'>xml&web services</option>");
		out.println("</td></tr>");
		out.println("<tr><td><td><input type='submit' value='Continue'></td></td></tr>");
		out.println("</table></center>");
		
		//close stream
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
