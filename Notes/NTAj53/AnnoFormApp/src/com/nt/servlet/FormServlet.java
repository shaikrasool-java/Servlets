package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet(description = "anno-test",
                             urlPatterns = { "/test" },
                             name="form",
                             loadOnStartup=1,
                             initParams={@WebInitParam(name="dbuser",value="scott"),
                            		                  @WebInitParam(name="dbpwd",value="tiger"),
                                                     })
public class FormServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet logical name"+config.getServletName());
		System.out.println("dbuser init param"+config.getInitParameter("dbuser"));
		System.out.println("dbpwd init param"+config.getInitParameter("dbpwd"));
		
	}
       
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
    		throws ServletException, IOException {
    	PrintWriter pw=null;
    	ServletOutputStream sos=null;
    	String user=null;
	//general settings
    	//pw=res.getWriter();
    	sos=res.getOutputStream();
    	res.setContentType("text/html");
    	//read form data
    	user=req.getParameter("user");
    	//display Wish msg
    	sos.println("Good morning "+user);
    	//close stream
    	sos.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
