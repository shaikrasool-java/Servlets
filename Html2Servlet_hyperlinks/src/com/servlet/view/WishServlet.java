package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WishServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int hour=0;
		Calendar  calender=null;
		calender=Calendar.getInstance();
		hour=calender.get(Calendar.HOUR_OF_DAY);
		
		if (hour<=12) {
			out.println("<h1 style='color:red'>Good Morning</h1>");
			
		}else if(hour>=12){
				out.println("<h1 style='color:blue'>Good Afternoon</h1>");
			}
		 else {
			 out.println("<h1>Good Evening</h1>");

			 out.println("<a href='index.html'>home</a>");
		}
				}

}
