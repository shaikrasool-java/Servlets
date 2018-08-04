package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.LoginDao;

public class FirstServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		System.out.println("checking");
		
		String n=request.getParameter("name");
		String p=request.getParameter("password");
		System.out.println("checked");
		
		if (LoginDao.validate(n, p)) {
			System.out.println("validation");
			RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
			rd.forward(request, response);
			
		} else {
			out.println("Sorry!...try again");
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}
		
	}

}
