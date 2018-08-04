package com.nt.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
    
	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String pvalue=null;
		pvalue=super.getParameter(name);
		System.out.println(pvalue);
		if(name.equals("uname")){
			if(pvalue.indexOf("@gmail.com")==-1){
				pvalue=pvalue+"@gmail.com";
			}//if
		}//if
	   return pvalue;
	}//method
}//class
