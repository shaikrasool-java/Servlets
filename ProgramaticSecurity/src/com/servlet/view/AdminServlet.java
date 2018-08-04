package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			HttpSession ses=request.getSession();
			String str=(String)ses.getAttribute("loggedin");
			if(str==null){
				ses.setAttribute("target","/AdminServlet");
				RequestDispatcher rd=request.getRequestDispatcher("/LoginServlet");
				rd.forward(request, response);
			}
			else{
				PrintWriter out=response.getWriter();
				out.println("<font color=red size=7>From Admin Servlet component</font>");
			}
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
