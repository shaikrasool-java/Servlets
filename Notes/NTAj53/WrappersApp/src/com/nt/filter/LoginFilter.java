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
import javax.servlet.http.HttpServletResponse;

import com.nt.wrappers.MyRequest;
import com.nt.wrappers.MyResponse;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig fg) throws ServletException {
	

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mreq=null;
		MyResponse mres=null;
		String respMsg=null;
		//Create Custom Request obj
		mreq=new MyRequest(((HttpServletRequest)req));
		//create CustomResponse obj
	   mres=new MyResponse(((HttpServletResponse)res));
	   
		chain.doFilter(mreq,mres);
		
		respMsg=mres.toString().toUpperCase();
		//Add signature
		respMsg=respMsg+"<br> HCL, HYD";
		//write response to browwr
		PrintWriter pw=res.getWriter();
		pw.println(respMsg);
	}//doFilter(-,-)


	
	@Override
	public void destroy() {
		

	}

}
