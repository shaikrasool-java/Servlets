package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
public class UploadingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);

	
		try {
			
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			MultipartRequest m=new MultipartRequest(request,"E:Rasool");
			out.println("Successfully Uploaded");
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	}

}
