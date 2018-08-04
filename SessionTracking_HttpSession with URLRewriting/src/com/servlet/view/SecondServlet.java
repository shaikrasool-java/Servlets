package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
    	//General Settings
		res.setContentType( "text/html" ) ;
		PrintWriter pw = res.getWriter( ) ;
        //read form2/req2 data
		String exp=req.getParameter("exp");
		String skills=req.getParameter("skills");
		//Access HttpSession obj
		HttpSession session = req.getSession(false) ;
		//Keep form2/req2 data in Session obj as session attribute values
		session.setAttribute("exp", exp );
		session.setAttribute("skills", skills );
		
		//Generate form3 dynamically from here
		pw.println("<BODY BGCOLOR=cyan>");
		pw.println("<CENTER><H1><FONT COLOR=red>Provide City & Salary</FONT></H1></CENTER>");
		pw.println("<FORM  ACTION="+res.encodeURL("ThirdServlet")+" METHOD=GET>");
		pw.println("<TABLE ALIGN=CENTER>");
		pw.println("<TR>");               
		pw.println("<TD>");               
		pw.println("<H2><FONT COLOR=BLUE>Enter Preference City :");
		pw.println("<INPUT TYPE=TEXT NAME=city SIZE=6>");
		pw.println("</TD></TR>");         
		pw.println("<TR>");               
		pw.println("<TD>");               
		pw.println("<H2><FONT COLOR=BLUE>Enter Expected Salary :");
		pw.println("<INPUT TYPE=TEXT NAME=sal SIZE=16>");
		pw.println("</TD></TR>");         
		pw.println("<TR><TD>");           
		pw.println("<INPUT TYPE=SUBMIT VALUE=Submit >");
		pw.println("</TABLE></BODY>"); 
		
		pw.println("<br>Session Id"+session.getId());
		
	
	} // doGet(-,-)
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
    	doGet(req,res);
    }
    
} // class