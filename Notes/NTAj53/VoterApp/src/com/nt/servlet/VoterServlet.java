//VoterSrv.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class VoterServlet extends HttpServlet
{
	public void process(HttpServletRequest req,
		                                HttpServletResponse res)throws ServletException,IOException
	{
		 System.out.println("VoterServlet:process(-,-) ");
		// general settings
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		//read form data/request parameter values
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		//read vflag value
		String vstatus=req.getParameter("vflag");
		int age=0;
		if(vstatus.equals("no")){
		//Perform Server side form validations
		List<String> errList=new ArrayList<String>();
          System.out.println("start of Server Side form validations");
		if(name==null || name.equals("") || name.length()==0){
			errList.add("Person name is mandatory");
     	}//if
		if(tage==null || tage.equals("") || tage.length()==0){
           	errList.add("Person age is mandatory");
		}
		else{
			try{
     		  age=Integer.parseInt(tage);
			}
			catch(NumberFormatException nfe){
             	errList.add("Person age must numeric value");
			}//catch
		}//else

		//Display form validation error messages
     if(errList.size()!=0){
		for(String errMsg:errList){
			pw.println("<p style='color:red'>"+errMsg+"</p>");
		}//for
		System.out.println("End of SErver Side form validations");
		return;
    	 }
	}//if
	else{
		age=Integer.parseInt(tage);
	}


		//write request processing logic
		if(age>=18)
			pw.println("<h1 style='color:blue'>"+ name+" u  r elgible to vote </h1>");
		else
			pw.println("<h1 style='color:pink'>"+ name+" u  r not elgible to vote </h1>");
         //add hyperlink
		 pw.println("<a href='input.html'><img src='tips.gif'></a>");
          //close stream
		  pw.close();
	}//doGet(-,-)
	public void doGet(HttpServletRequest req,
		                                HttpServletResponse res)throws ServletException,IOException
	{
	   System.out.println("VoterSrv:doGet111(-,-)");
		process(req,res);
	}//doPost(-,-)
	public void doPost(HttpServletRequest req,
		                                HttpServletResponse res)throws ServletException,IOException
	{
	   System.out.println("VoterSrv:doPost111(-,-)");
		process(req,res);
	}//doPost(-,-)


}//class
//>javac  -d  .  VoterServlet.java
