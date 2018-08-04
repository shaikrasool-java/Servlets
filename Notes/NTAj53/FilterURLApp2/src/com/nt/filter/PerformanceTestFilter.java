package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PerformanceTestFilter implements Filter {

	 ServletContext  sc=null;
	 
	@Override
	public void init(FilterConfig fg) throws ServletException {
          sc=fg.getServletContext();
	}

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 long start=0, end=0;
		 start=System.currentTimeMillis();
		 chain.doFilter(req,res);
		 end=System.currentTimeMillis();
		 
		 System.out.println(((HttpServletRequest)req).getRequestURI()+" has taken"+(end-start)+" ms");
      //write log file
		 sc.log(((HttpServletRequest)req).getRequestURI()+" has taken"+(end-start)+" ms");

	}


	@Override
	public void destroy() {
		sc=null;

	}

}
