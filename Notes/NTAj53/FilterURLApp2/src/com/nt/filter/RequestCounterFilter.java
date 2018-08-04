package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestCounterFilter implements Filter {
	private int counter;
	private FilterConfig fg;
	

	@Override
	public void init(FilterConfig fg) throws ServletException {
		this.fg=fg;
		counter=0;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		counter++;
		//get Access to ServletContext obj
		sc=fg.getServletContext();
		// place request count in ServletContext obj
		sc.setAttribute("ReqCnt",counter);
		//forward request
		chain.doFilter(req,res);
	}//doFilter

	@Override
	public void destroy() {
	  fg=null;
		
	}
	

	

}
