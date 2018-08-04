package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	public String generateResult(StudentDTO dto){
		int total=0;
		float avg=0.0f;
		String result=null;
		int count=0;
		StudentDAO dao=null;
		//write b.logic to calculate total,avg and result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg>=35)
			result="pass";
		else
			result="fail";
		//prepare BO class obj
		StudentBO bo=new StudentBO();
		bo.setSno(dto.getSno());bo.setSname(dto.getSname());
		bo.setTotal(total); bo.setAvg(avg); bo.setResult(result);
		//use DAO
		dao=new StudentDAO();
	    count=dao.insert(bo);
	    if(count==0)
	    	return "student Registration failed and the result is"+result;
	    else
	    	return "student Registration succeded and the result is"+result;
	}//generateResult(-)
}//class
