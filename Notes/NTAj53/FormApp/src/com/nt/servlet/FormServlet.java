package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
  @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter 
	  PrintWriter pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  //read form data
	  String name=req.getParameter("name");
	  int age=Integer.parseInt(req.getParameter("age"));
	  String addrs=req.getParameter("addrs");
	  String gender=req.getParameter("gender");
	  String ms=req.getParameter("ms");
	    if(ms==null){
	    	ms="single";
	    }
	  String qlfy=req.getParameter("qlfy");
	  String courses[]=req.getParameterValues("courses");
	  String hobies[]=req.getParameterValues("hb");
	  //write request processing logic/b.logic
	  if(gender.equalsIgnoreCase("M")){
		  if(age<=5)
			  pw.println("<h1>Master."+name+" u  r baby boy </h1> ");
		  else if(age<=12)
			  pw.println("<h1>Master."+name+" u  r  boy </h1> ");
		  else if(age<=19)
			  pw.println("<h1>Mr."+name+" u  r  teenage boy </h1> ");
		  else if(age<=35)
			  pw.println("<h1>Mr."+name+" u  r  young man </h1> ");
		  else if(age<=50)
			  pw.println("<h1>Mr."+name+" u  r  middle aged man </h1> ");
		  else 
			  pw.println("<h1>Mr."+name+" u  r  Budda man </h1> ");
	  }//if
	  else{
		  if(age<=5){
			  pw.println("<h1>Master."+name+" u  r baby girl </h1> ");
		  }
		  else if(age<=12){
			  pw.println("<h1>Master."+name+" u  r  girl </h1> ");
		  }
		  else if(age<=19){
			  if(ms.equalsIgnoreCase("married")){
				  pw.println("<h1>Mrs."+name+" u  r  teenage girl </h1> ");
			  }
			  else{
				  pw.println("<h1>Miss."+name+" u  r  teenage girl </h1> ");
			  }
		  }
		  else if(age<=35){
			  if(ms.equalsIgnoreCase("married")){
				  pw.println("<h1>Mrs."+name+" u  r  young  woman </h1> ");
			  }
			  else{
				  pw.println("<h1>Miss."+name+" u  r  young woman </h1> ");
			  }
		  }
		  else if(age<=50){
			  if(ms.equalsIgnoreCase("married")){
				  pw.println("<h1>Mrs."+name+" u  r  middle aged  woman </h1> ");
			  }
			  else{
				  pw.println("<h1>Miss."+name+" u  r  middle aged woman </h1> ");
			  }
		  }
		  else{
			  if(ms.equalsIgnoreCase("married")){
				  pw.println("<h1>Mrs."+name+" u  r  Old  woman </h1> ");
			  }
			  else{
				  pw.println("<h1>Miss."+name+" u  r  old  woman </h1> ");
			  } 
		  }
	  }
	   //Display form data
	  pw.println("<b> name : </b>"+name+"<br>");
	  pw.println("<b> Age : </b>"+age+"<br>");
	  pw.println("<b> Address : </b>"+addrs+"<br>");
	  pw.println("<b> Gender : </b>"+gender+"<br>");
	  pw.println("<b> Marital Status "+ms+"<br>");
	  pw.println("<b> Qualification : </b>"+qlfy+"<br>");
	  pw.println("<b> Courses : </b>"+Arrays.toString(courses)+"<br>");
	  pw.println("<b> Hobies : </b>"+Arrays.toString(hobies)+"<br>");
	  //Add hyperlink 
	  pw.println("<a href='form.html'>home </a>");
	   //close stream 
	  pw.close();
	
  }//doGet(-,-)
  @Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class
