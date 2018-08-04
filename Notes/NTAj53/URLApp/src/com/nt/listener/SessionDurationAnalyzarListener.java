package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDurationAnalyzarListener implements HttpSessionListener{
       private long start,end;  
	
       @Override
	public void sessionCreated(HttpSessionEvent hse) {
		start=System.currentTimeMillis();
		//get ServletContext
		ServletContext sc=hse.getSession().getServletContext();
		//write log message
		sc.log(sc.getContextPath()+"::: Session started at"+new Date());
	}//method

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		end=System.currentTimeMillis();
		//get ServletContext
		ServletContext sc=hse.getSession().getServletContext();
		//write log message
		sc.log(sc.getContextPath()+"::: Session ended at"+new Date());
		sc.log(sc.getContextPath()+"::: Session duration ::"+(end-start)+" ms.");
	}//method
}//class
