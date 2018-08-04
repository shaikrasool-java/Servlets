package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//general settings....
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//get  values from browse....
		
		int i=0;
		String id=request.getParameter("id");
		i=Integer.parseInt(id);
		String name=request.getParameter("name");
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String desg=request.getParameter("desg");
		String country=request.getParameter("country");
		
		//create cookies to store the form1 data...
		
		Cookie ck1=new Cookie("id", id);
		Cookie ck2=new Cookie("name", name);
		Cookie ck3=new Cookie("fname",fname);
		Cookie ck4=new Cookie("email", email);
		Cookie ck5=new Cookie("password", password);
		Cookie ck6=new Cookie("desg", desg);
		Cookie ck7=new Cookie("country", country);
		
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.addCookie(ck3);
		response.addCookie(ck4);
		response.addCookie(ck5);
		response.addCookie(ck6);
		response.addCookie(ck7);
		
		
		// now we need to generate the second form dynamically....
		
		out.println("<center><form action='SecondServlet' method='post'>");
		out.println("<h2>Details of Salary...</h2>");
		out.println("<table border='1'style='color:maroon;'><tr><th></th><th>Enter Details of salary and tax</th>");
		out.println("<tr><td>Income of this month in ruppes:</td><td><input type='text' name='income'></td></tr><br>");
		out.println("<tr><td>Tax in rupees:</td><td><input type='text' name='tax'></td></tr><br>");
		out.println("</table></center>");
		out.println("<center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='submit' value='submit'></center></form>");
	
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
