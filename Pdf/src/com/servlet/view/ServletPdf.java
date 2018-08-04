package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletPdf extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			            throws ServletException, IOException {
		response.setContentType("application/pdf");
		PrintWriter out=response.getWriter();
		
		response.setHeader("Content-disposition","inline; filename='PAN.pdf'");
		System.out.println("before pdf");
		//PDF p=new PDF(out);
		//Page p1=new Page(p);
		// spdf jar file is not avilable to complete this project,
		// that's why i'm give up this project.....
		
	}

}
