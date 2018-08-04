package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DiscountServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	PrintWriter out=response.getWriter();
	response.setContentType("text/html");

	float amount=Float.parseFloat(request.getParameter("bill"));
	String name=request.getParameter("&iname");
	
	float discount=amount*0.05f;
	float finalamount=amount-discount;
	
	out.println("<br>Item Name:"+name);
	out.println("<br> Bill Amount:"+amount);
	out.println("<br>Discount:"+discount);
	out.println("<br>Final Bill Amount"+finalamount);
	out.close();
	
	
	
	
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
