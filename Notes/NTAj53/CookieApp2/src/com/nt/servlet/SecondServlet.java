package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  // general settings
		PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   //read form2/req2 data
	   int income=Integer.parseInt(req.getParameter("income"));
	   int tax=Integer.parseInt(req.getParameter("tax"));
	   //read form1/req1 data from cookies (SessionTracking)
	   String name=null,fname=null;
	   Cookie cks[]=req.getCookies();
	   if(cks!=null){
	      name=cks[0].getValue();
	      fname=cks[1].getValue();
	   }//if
	   try{
	   //write form1/req1 and form2/req2 values to Db table as record
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
	   //create PreparedStatement obj
	   PreparedStatement ps=con.prepareStatement("insert into tax_tab values(?,?,?,?)");
	   ps.setString(1,name);
	   ps.setString(2,fname);
	   ps.setInt(3,income);
	   ps.setInt(4, tax);
	   //execute the Query
	   int result=ps.executeUpdate();
	   if(result==0)
		   pw.println("<h1><center>Registration failed</center></h1>");
	   else
		   pw.println("<h1><center>Registration sucess</center></h1>");
	   }//try
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   // generate dynamic webpage displaying form1/req1 and form2/req2 data
	   pw.println("<br>Form1/req1 data:::"+name+"....."+fname);
	   pw.println("<br>Form2/req2 data:::"+income+"....."+tax);
	   //close stream
	   pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
	   
}//class

