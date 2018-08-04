package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmpDao;
import com.servlet.model.Emp;

public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	
	String pid=request.getParameter("page");
	System.out.println("==="+pid+"=====");
	int pageid=Integer.parseInt(pid);
	int total=2;
	if(pageid==1){
		System.out.println("enter into page");
	}
	else{
		pageid=pageid-1;
		System.out.println("-------"+pageid);
		pageid=pageid*total+1;
		System.out.println("~~~~~~~~~~~~"+pageid);
	}
	List<Emp> list=EmpDao.getRecords(pageid,total);
		
	out.print("<h1>PageNo:"+pid+"</h1>");
	out.print("<table border='1' cellpadding='4'width='60%'>");
	out.print("<tr><th>Id</th><th>Name</th><th>Country</th>");
	
	for(Emp e:list){
		
		out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCountry()+"</td></tr>");
		
	}
	out.println("</table");
	
	out.print("<a href='ViewServlet?page=1'>1</a>");
	out.print("<a href='ViewServlet?page=2'>2</a>");
	out.print("<a href='ViewServlet?page=3'>3</a>");

	
	out.close();
	}

}
