package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(value="/*")
public class DoublePostingPreventFilter implements Filter {

	@Override
	public void init(FilterConfig fg) throws ServletException {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession ses=null;
		
		  //typecasting
		HttpServletRequest hreq=(HttpServletRequest)req;
		
		 // For 1st request when Session obj is not there for browser
		   if(hreq.getSession(false)==null){ 
			    //create Session 
			   ses=hreq.getSession();
			   chain.doFilter(req, res);
		   }
		   else{   //if Session is already avaiable
			   if(hreq.getMethod().equals("GET")){
				   ses=hreq.getSession();
				   ses.setAttribute("stoken",new Random().nextInt(10000));
				   chain.doFilter(req,res);
			     }//if
			   else{
				   //read ServerSessionToken
				   ses=hreq.getSession();
				   int serverToken=(Integer)ses.getAttribute("stoken");
				   //read clientSEssion Token
				   int clientToken=Integer.parseInt(req.getParameter("ctoken"));
				   System.out.println(clientToken+"--------"+serverToken);
				   if(serverToken==clientToken){
					   ses.setAttribute("stoken",new Random().nextInt(10000));
					   chain.doFilter(req,res);
				   }//if
				   else{
					   RequestDispatcher rd=req.getRequestDispatcher("/dbl_post_err.jsp");
					   rd.forward(req,res);
				   }//else
			   }//else
		   }//else
	}//doFilter(-,-)

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}


}
