package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			String name=request.getParameter("name");
			float price=Float.parseFloat(request.getParameter("price"));
			float quantity=Float.parseFloat(request.getParameter("quantity"));
			
			float amount=price*quantity;
	
			if(amount>5000){
				response.sendRedirect("http://localhost:8081/SendRedirectTest2/DiscountServlet?bill="+amount+"&iname"+name);
			}
			else{
				out.println("from bill servlet component");
				out.println("<br> Item name="+name+"<br> Item price="+price+"<br>Item Quantity="+quantity+"<br>amount="+amount);
			}
	
	out.close();
	}			
			
@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
