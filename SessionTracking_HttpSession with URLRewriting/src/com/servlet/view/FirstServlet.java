package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
    	//General settings
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
        //read form1/req1 data
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String age=req.getParameter("age");
        //create HttpSession obj for current Browser
		HttpSession session = req.getSession(true);
		//Keep form1/req1 data in HttpSession obj as session attribute values
		session.setAttribute("name", name);
		session.setAttribute("address", address);
		session.setAttribute("age", age);
		
       //Generate form2 dynamically
		pw.println("<BODY BGCOLOR=cyan>");
		pw.println("<CENTER><H1><FONT COLOR=red>Provide Your Exp & Skils</FONT></H1></CENTER>");
		pw.println("<FORM  ACTION="+res.encodeURL("SecondServlet")+" METHOD=GET>");
		pw.println("<TABLE ALIGN=CENTER>");
		pw.println("<TR>");             
		pw.println("<TD>");             
		pw.println("<H2><FONT COLOR=BLUE>Enter Number of Years Exp :");
		pw.println("<INPUT TYPE=TEXT NAME=exp SIZE=6>");
		pw.println("</TD></TR>");
		pw.println("<TR>");     
		pw.println("<TD>");     
		pw.println(" <H2><FONT COLOR=blue><B>Select Skills..............................:</B>");
		
		pw.print("<SELECT NAME=skills>");
		pw.print("<OPTION VALUE=JAVA>JAVA/J2EE </OPTION>");
		pw.print("<OPTION VALUE=.NET>.Net </OPTION>");
		pw.print("<OPTION VALUE=ORACLE>ORACLE 10G </OPTION>");
		pw.print("<OPTION VALUE=XML>XML & Web Services </OPTION>");
		pw.print("</SELECT>"); 
		pw.println("</TD></TR>");
		
		pw.println("<TR><TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
		pw.println("<INPUT TYPe=Submit value=Continue>");
		pw.println("</TABLE></BODY>");
		pw.println("<br>Session Id"+session.getId());
	
		
		
	} // service()
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
      doGet(req,res);
    }
} // class
