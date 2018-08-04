package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		
		ServletContext sc=getServletContext();
		pw.println("<br>dbuser context param value"+sc.getInitParameter("dbuser"));
		
		ServletConfig cg=getServletConfig();
		pw.println("<br>dbuser init param value"+cg.getInitParameter("dbuser"));
		
		//Gathering various details using ServletContext obj
		pw.println("<br> Context path name/web application name "+sc.getContextPath());
		pw.println("<br> underlying Server info"+sc.getServerInfo());
		pw.println("<br> Servlet api version supported by the Server"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> path of context path directory"+sc.getRealPath("/"));
		pw.println("<br> path of input.html"+sc.getRealPath("/input.html"));
		pw.println("<br> MIME type of input.html"+sc.getMimeType("input.html"));
		//writing Msg to log file
		sc.log("Today's Date and time"+new Date());
		
		//Misc Info of request using ServletRequest(I) methods
		pw.println("<br> request content length "+req.getContentLength());
		  // length in bytes or -1
		pw.println("<br> request content type "+req.getContentType());
		  // request body MIME type or null
		pw.println("<br> request protocol "+req.getProtocol());
		  // HTTP/1.1
		pw.println("<br> request scheme "+req.getScheme());
		 // http
		pw.println("<br> Server name"+req.getServerName());
		   // localhost
		pw.println("<br> Server Port"+req.getServerPort());
		   // 2525 (Tomcat port)
		pw.println("<br> browser machine IP Addrs"+req.getRemoteAddr());
		 // 180.45.45.3
		pw.println("<br> browser machine Host name"+req.getRemoteHost());
		  // sys4
		pw.println("<br> browser s/w port no"+req.getRemotePort());
		 // 3467
		//Using methods of HttpServletRequest(I)
		pw.println("<br> req methodology"+req.getMethod());
		  // GET
		pw.println("<br> req query string"+req.getQueryString());
		   // ?sno=101&sname=raja
		pw.println("<br>  request uri "+req.getRequestURI());
		   //  /DateApp/first
		pw.println("<br>  request url "+req.getRequestURL());
		   // http://localhost:3030/DateApp/first
		pw.println("<br>  Servlet path/url pattern "+req.getServletPath());
		   // /test
		pw.println("<br> Web App/Context name"+req.getContextPath());
		   //   /DateApp
		
		
		
		
		

		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
