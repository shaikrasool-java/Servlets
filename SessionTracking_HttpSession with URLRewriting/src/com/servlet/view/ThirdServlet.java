package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThirdServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
		//general settings
		res.setContentType( "text/html" ) ;
		PrintWriter pw = res.getWriter( ) ;

		 //Read form3/req3 data
		int sal=0;
		String city=req.getParameter("city");
		String salary=req.getParameter("sal");

		 //Get Access to HttpSession obj
		HttpSession session = req.getSession(false) ;   

          //read form/req1 and form2/req2 values from HttpSession obj as session attribute values
		String name = (String)session.getAttribute("name");
		String address = (String)session.getAttribute("address");
		String age = (String)session.getAttribute("age");
		String exp = (String)session.getAttribute("exp");
		String skills = (String)session.getAttribute("skills");

		//write all the 3 form values/req values to DB table as record (jdbc code)
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			System.out.println("url loaded......");
			PreparedStatement pst=con.prepareStatement("INSERT INTO INFO(name, addr, age,exp,skills,city,salary) VALUES(?,?,?,?,?,?,?)");
			System.out.println("ps running....");
			pst.setString(1,name);
			pst.setString(2,address);
			pst.setInt(3,Integer.parseInt(age));
			pst.setInt(4,Integer.parseInt(exp));
			pst.setString(5,skills);
			pst.setString(6,city);
			pst.setString(7,salary);

			int i = pst.executeUpdate();
			System.out.println("ps executed......"+i);
              //invalidate the Session
			session.invalidate();
			System.out.println("session invalidata...."+session);

			 if(i > 0)
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Registration Successuful </FONT></H1></CENTER>");

				pw.println("<a href= index.html>Home</a>");
			 }
			 else
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
				pw.println("<a href=index.html>Home</a>");
			  }
		} // try
		catch(Exception e)
		{
			e.printStackTrace();
			pw.println("<BODY BGCOLOR=cyan>");
			pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
			pw.println("<a href= index.html>Home</a>");
		}
		pw.println("<br>Session Id"+session.getId());
	} // doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
		doGet(req,res);
	}

}