<%@page import="java.sql.*" %>

<%!
       Connection con;
	   PreparedStatement ps1,ps2;
       public void jspInit()
         {
			 System.out.println("DBJsp: jspInit() method");
			 try{
			 //get Access to ServletConfig obj
			 ServletConfig cg=getServletConfig();
			 // read init param values
			String s1=cg.getInitParameter("driver");
			String s2=cg.getInitParameter("url");
			String s3=cg.getInitParameter("dbuser");
			String s4=cg.getInitParameter("dbpwd");
			// create jdbc connection ,PreparedStatement objs
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			ps1=con.prepareStatement("insert into student values(?,?,?)");
			ps2=con.prepareStatement("select * from student");
			 }//try
			 catch(Exception e)
			 { e.printStackTrace(); }
		 }//jspInit()
	 %>

	 <%   
        			 System.out.println("DBJsp: from scriptlet ");

	         //read s1 req param value
	          String pval=request.getParameter("s1");

			  if(pval.equals("register")) // when submit btn is clicked
			  {
				  //read form data
				  int no=Integer.parseInt(request.getParameter("tsno"));
				  String name=request.getParameter("tsname");
				  String addrs=request.getParameter("tsadd");
				  //set form data to the params of insert query
				  ps1.setInt(1,no);
				  ps1.setString(2,name);
				  ps1.setString(3,addrs);
				  //execute the Query
				  int result=ps1.executeUpdate();
				  //process the results
				  if(result==0)
				  { %>
				     <b>Registration Failed</b>
			 <% }
				  else
				  { %>
				    <b>Registration Success</b>
				<%}//else
			  }//if
			  else  //when hyperlink is clicked
			  {
				  ResultSet rs=ps2.executeQuery();
				  ResultSetMetaData rsmd=rs.getMetaData();
				  int cnt=rsmd.getColumnCount();  %>
                
				<table>
				   <tr>
			<%	  //print col names
				  for(int i=1;i<=cnt;++i)
				  { %>
				    <td><%=rsmd.getColumnLabel(i) %></td>
                 <%} %>
				 </tr>

               <% while(rs.next())
			    { %>
				<tr>
				 <%for (int i=1;i<=cnt;++i)
					{  %>
                  <td><%=rs.getString(i) %></td>
				  <%} %>
				  </tr>
				  <%} 
				     rs.close(); %>
				</table>
            <%} %>




				  <%! public void jspDestroy()
				          {
							  System.out.println("DBJsp:jspDestroy()");
     					  try
							   {
							   if(ps1!=null)
								    ps1.close();
   							   if(ps2!=null)
     						    ps2.close();

							   if(con!=null)
								    con.close();
							  }//try
							  catch(Exception e)
							  { e.printStackTrace(); }
						  }//jspDestroy()
						  %>

