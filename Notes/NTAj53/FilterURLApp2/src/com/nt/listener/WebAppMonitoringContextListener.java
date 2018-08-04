package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppMonitoringContextListener implements ServletContextListener {
     
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// get Servletcontext obj
		ServletContext sc=sce.getServletContext();
		//write log message
		sc.log(sc.getContextPath()+" is deployed/reloaded at"+new Date());
	}//method
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// get Servletcontext obj
		ServletContext sc=sce.getServletContext();
		//write log message
		sc.log(sc.getContextPath()+" is undeployed/stopped/reloaded at"+new Date());
	}//method
}//class
