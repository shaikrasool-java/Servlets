package com.nt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ReqTimeAnalyzarListener implements ServletRequestListener {
   private long start,end;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
	}//method
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		end=System.currentTimeMillis();
		//get HttpServletRequest  obj
		HttpServletRequest hreq=(HttpServletRequest)sre.getServletRequest();
		//get Servletcontext obj
		ServletContext sc=sre.getServletContext();
		sc.log(hreq.getRequestURI()+" has taken "+(end-start)+
				                                                   " ms time to process the request");
	}//method
}//class
