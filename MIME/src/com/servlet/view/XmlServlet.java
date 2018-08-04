package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class XmlServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<table border='0'>");
		out.println("<tr><th>Flim</th><th>Actor</th></tr>");
		out.println("<tr><td>Bajirao Masthani</td><td>RanveerSing</td></tr>");
		out.println("<tr><td>Tamasha</td><td>RanbirKapoor</td></tr>");
		out.println("<tr><td>Rab ne banadi Jodi</td><td>SharukKhan</td></tr>");
		out.println("<table>");
		out.println("<a href='index.html'>back2home</a>");
		out.close();
	}

}
