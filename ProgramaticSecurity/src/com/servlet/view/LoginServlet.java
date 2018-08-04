package com.servlet.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			HttpSession ses=request.getSession();
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			if(name.equals("system")&&password.equals("manager")){
				ses.setAttribute("loggedin", "ok");
				String up=(String)ses.getAttribute("target");
				RequestDispatcher rd=request.getRequestDispatcher(up);
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
		
		
	}

	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
