package com.servlet.service;

import com.servlet.bo.StudentBO;
import com.servlet.dao.StudentDAO;
import com.servlet.dto.StudentDTO;

public class StudentService {

	public String generateResult(StudentDTO dto){
		
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		StudentDAO dao=null;
		int cnt=0;
		
		// use b.logic to calculate total, avg and result;
		
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		
		if(avg<35)
			result="fail";
		else
			result="pass";
		
				
		//prepare BO class object having persistance data
		
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		// use dao
		
		dao=new StudentDAO();
		cnt=dao.insert(bo);
		
		if(cnt==0)
			return "Registration failed";
		else
			return "Registration succeded and Result="+result;
		
		
		
	}
	
	
	
}
