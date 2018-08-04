package com.servlet.view;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
public class ConnPoolServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			Connection con=null;
			Statement st=null;
			PrintWriter out=null;
			ResultSet rs=null;
			ResultSetMetaData rsmd=null;
			String table=null;
			int colCnt=0;
			
			
			out=response.getWriter();
			response.setContentType("text/html");
			table=request.getParameter("table");
			
			try {
 				con=makeConnection();
 				st=con.createStatement();
 				rs=st.executeQuery("select*from "+table);
 				rsmd=rs.getMetaData();
 				colCnt=rsmd.getColumnCount();
 				out.println("<table border='1' bgcolor='skyblue'>");
 				out.println("<tr bgcolor='cyan'>");
 				
 				for(int i=1;i<=colCnt;i++){
 					out.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
 					
 					
 				}
				out.println("</tr>");
				while(rs.next()){
					out.println("<tr>");
						for(int i=1;i<=colCnt;i++){
							out.println("<td>"+rs.getString(i)+"</td>");
							
						}
						out.println("</tr>");
				}
				
					out.println("</table>");
					out.println("<br><a href='index.html'>Try Again</a>");
					rs.close();
					st.close();
					con.close();
					
				
			} catch (Exception e) {
				
				out.println("<br><center>InternalProblem</center></br>");
				out.println("<br><a href='index.html'>Try Again</a>");
				
			}
			out.close();
			
			}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	private Connection makeConnection() {
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		try{
			ic=new InitialContext();
			
			ds=(DataSource)ic.lookup("java:/comp/env/mypool");
		con=ds.getConnection();
		}catch (Exception e) {
    System.out.println(e.getMessage());

			
		}
		
		return con;
	}
}
