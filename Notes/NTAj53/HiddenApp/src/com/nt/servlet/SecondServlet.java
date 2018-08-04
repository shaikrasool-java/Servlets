package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		//read form1/req1 data from hidden boxes
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String ms=req.getParameter("ms");
		//write form1/req1 data and form2/req2 data to Db table as record
		try{
			//Load jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create JDBC PreparedStatement obj
			PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5,f2val2);
			//execute the Query
			int result=ps.executeUpdate();
			//process the Result
			if(result==0)
				pw.println("<h1> <center> Registration Failed</h1></center>");
			else
				pw.println("<h1> <center> Registration Success</h1></center>");
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
			//Generate dynamic webpage having form1/req1 and form2/req2 data
		   pw.println("<br> Form1/req1 data"+name+"...."+fname+"....."+ms);
		   pw.println("<br> Form2/req2 data"+f2val1+"...."+f2val2);
		   //close stream
		   pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)

}//class

