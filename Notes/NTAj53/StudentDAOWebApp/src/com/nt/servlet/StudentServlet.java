package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   String sno=null,sname=null,m1=null,m2=null,m3=null;
	   StudentVO vo=null;
	   StudentDTO dto=null;
	   StudentService service=null;
	   String result=null;
	   PrintWriter pw=null;
		//read form data
	   sno=req.getParameter("sno");
	   sname=req.getParameter("sname");
	   m1=req.getParameter("tm1");
	   m2=req.getParameter("tm2");
	   m3=req.getParameter("tm3");
	   //prepre VO class obj having form data
	   vo=new StudentVO();
	   vo.setSno(sno); vo.setSname(sname);
	   vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
	   //Convert VO class obj to DTO class obj
	   dto=new StudentDTO();
	   dto.setSno(Integer.parseInt(vo.getSno()));
	   dto.setSname(sname);
	   dto.setM1(Integer.parseInt(vo.getM1()));
	   dto.setM2(Integer.parseInt(vo.getM2()));
	   dto.setM3(Integer.parseInt(vo.getM3()));
	   // use Service class
	   service=new StudentService();
	   result=service.generateResult(dto);
	   // Display results
	   pw=res.getWriter();
	   pw.println("<h1> Result is :::"+result+"</h1>");
     	//close stream
	   pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
