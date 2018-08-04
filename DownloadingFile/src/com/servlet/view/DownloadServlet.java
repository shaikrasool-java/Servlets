package com.servlet.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String file="my folder\\a.jpg";
	String filepath="E:\\";
	response.setContentType("APPLICATION/OCTET-STREAM");
	response.setHeader("Content-Disposition","attachment; file=\"" + file+ "\"");
	
	FileInputStream fis=new FileInputStream(filepath+file);
	
	int i;
	while((i=fis.read())!=-1){

		out.write(i);
		
	}
	
	fis.close();
	out.close();
	}

}
