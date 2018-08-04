package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CheckBrowserFilter implements Filter {
     
	@Override
	public void init(FilterConfig fg) throws ServletException {
     
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String browser=null;
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
	// know the current browser s/w
		browser=((HttpServletRequest)req).getHeader("user-agent");
		if(browser.indexOf("firefox")==-1){
			pw.println(" Request must be given from Mozill Firefix  ");
			return;
		}
		else{
			chain.doFilter(req,res);
		}
	}//doFilter(-,-)

	@Override
	public void destroy() {

	}
}//class
