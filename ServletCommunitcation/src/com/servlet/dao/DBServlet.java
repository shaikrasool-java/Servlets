package com.servlet.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DBServlet extends HttpServlet {

		Connection con;
		PreparedStatement ps;
		private static final String GET_EMPLOYEE_DETAILS="SELECT ID, NAME, DESG,SALARY FROM EMPLOYEE WHERE ID=?";
	
		public void init()
		{
		String driver=null, url=null,user=null,password=null;
		try{
			
			ServletContext sc=getServletContext();
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("url");
			user=sc.getInitParameter("user");
			password=sc.getInitParameter("password");
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(GET_EMPLOYEE_DETAILS);
		}
		catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		
		catch (Exception e) {
		System.out.println(e.getMessage());
		}
    }

		public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			PrintWriter out=null;
			int i=0;
			ResultSet rs=null;
			RequestDispatcher rd=null,rd1=null, rd2=null;
			
			try{
				rd1=request.getRequestDispatcher("/HeaderServlet");
				rd1.include(request, response);
				
				// get print writer object
				out=response.getWriter();
				response.setContentType("text/html");
				out.println("<b>Before raising Exception</b>");
				// read form data(request, response)
				i=Integer.parseInt(request.getParameter("id"));
				
				// set values to prepared statement...
				ps.setInt(1, i);
				rs=ps.executeQuery();
				
			// process result set
				
				
				if(rs.next()){
					out.println("<h2><center>");
					out.println("<br>Emp id="+rs.getInt(1));
					out.println("<br> Emp name="+rs.getString(2));
					out.println("<br> Emp desg="+rs.getString(3));
					out.println("<br> Emp salary="+rs.getInt(4));
					out.println("<br><br><a href='index.html'>home</a>");
					out.println("</center></h2>");
				}
				else {
					out.println("Record is not found...please try again");
					out.println("<br><br><a href='index.html'>home</a>");
				}
				
				rd2=request.getRequestDispatcher("/footer.html");
				rd2.include(request, response);
				
				rs.close();
				out.close();
				
				
			}catch (Exception e) {

			rd=request.getRequestDispatcher("/ErrorServlet");
			rd.forward(request, response);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy(){
		
		try{
			if(ps!=null)
				ps.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			if(con!=null)
				con.close();
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	
	}
	
}
