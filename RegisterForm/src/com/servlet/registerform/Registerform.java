package com.servlet.registerform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registerform extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
	
		
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		System.out.println("Enter into servlet");
		int id=0;
		String i=request.getParameter("id");
		id=Integer.parseInt(i);
		String n=request.getParameter("name");
		String p=request.getParameter("password");
		String e=request.getParameter("email");
		String c=request.getParameter("country");
		
		System.out.println("inpts from browser"+n+" "+p);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("class loaded");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				System.out.println("connetion established"+con);
				PreparedStatement ps=con.prepareStatement("insert into employee(id,name,password,email,country) values(?,?,?,?,?)");
				
				System.out.println(" i am prepared statment"+ps);
				ps.setInt(1, id);
				ps.setString(2,n);
				ps.setString(3,p);
				ps.setString(4,e);
				ps.setString(5,c);
				
				int q=ps.executeUpdate();
				System.out.println("record count"+q);
				if(q>0){
					out.println("you successfully registered");
				}
				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
				System.out.println("Some thing wrong");
				// TODO: handle exception
			}
		
		
		
		}

}
