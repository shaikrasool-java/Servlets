package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class UploadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 // general settings
		PrintWriter pw=res.getWriter();
		res.setHeader("Content-Disposition","attachment;fileName=Title.xls");
		res.setContentType("application/vnd.ms-excel");
		try{
		//prepare Special request obj that holds uploaded files
		MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
		//create UploadBean class obj to perform file uploading
		UploadBean upb=new UploadBean();
		upb.setFolderstore("c:/store");
		upb.setOverwrite(false);
		upb.store(nreq); //completes file uploading
		//Display the names uploaded file
		Hashtable ht=nreq.getFiles();
		Enumeration e=ht.elements();
		pw.println("<br> The followng files are uploaded<br>");
		while(e.hasMoreElements()){
			UploadFile file=(UploadFile)e.nextElement();
			pw.println("<br>"+file.getFileName()+"--->"+file.getFileSize()+"---> "+file.getContentType());
		}//while
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		//clsoe stream
		pw.close();
   	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
