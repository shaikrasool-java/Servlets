package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.StudentDTO;
import com.servlet.service.StudentService;
import com.servlet.vo.StudentVO;
public class StudentControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		StudentVO vo=null;
		StudentDTO dto=null;
		StudentService service=null;
		PrintWriter out=null;
		ServletOutputStream sos=null;
		String no=null,name=null,m1=null,m2=null,m3=null;
		String result=null;
		
		no=request.getParameter("no");
		name=request.getParameter("name");
		m1=request.getParameter("m1");
		m2=request.getParameter("m2");
		m3=request.getParameter("m3");
		
		// create VO class object having form data...........
		
		vo=new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		
		
		//convert vo class object to dto class object
		
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		// user service class
		
		service=new StudentService();
		result=service.generateResult(dto);
				
		//display result
		
		sos=response.getOutputStream();
		out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h1>Result"+result+"</h1>");
		
		// add hyperlink
		out.println("<a href='index.html'>home</a>");
		
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		doGet(request, response);
	}

}
