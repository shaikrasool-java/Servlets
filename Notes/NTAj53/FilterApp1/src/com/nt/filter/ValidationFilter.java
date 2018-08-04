package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {
	
	public ValidationFilter() {
		System.out.println("ValidationFilter:0-param constructor");
	}

	@Override
	public void init(FilterConfig fg) throws ServletException {
		System.out.println("ValidationFilter:init(-)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ValidationFilter:doFilter(-,-,-)");
		PrintWriter pw=null;
		int val1=0,val2=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
		//validation logic
		if(val1<=0 || val2<=0){
			pw.println("Inputs must be +ve....|||||");
			 pw.println("<br><a href='input.html'>home</a>");
			 pw.close();
		}
		else{
			System.out.println("ValidationFilter:before chain.doFilter(-,-)");
			//forward request to servlet comp
			chain.doFilter(req,res);
			System.out.println("ValidationFilter:after chain.doFilter(-,-)");
			
		}//else
	}//doFilter(-,-)

	@Override
	public void destroy() {
		System.out.println("ValidationFilter:destroy(-)");
	}//destroy()

}//class
