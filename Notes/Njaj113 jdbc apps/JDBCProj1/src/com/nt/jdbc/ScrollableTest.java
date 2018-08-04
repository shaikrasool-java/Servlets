package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollableTest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj with type,mode values
            if(con!=null){
           	ps=con.prepareStatement("select * from student",
           			                                     ResultSet.TYPE_SCROLL_SENSITIVE,
            			                                 ResultSet.CONCUR_READ_ONLY);
            }
            	//create ResultSet obj
            if(ps!=null)
            	rs=ps.executeQuery("select * from student");
            //display records (top -bottom)
            if(rs!=null){
            	System.out.println("Top----Bottom");
            	while(rs.next()){
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            	}//while
            	System.out.println("Bottom----Top");
            	while(rs.previous()){
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            	}//while
            	System.out.println("------------------------------");
            	//first Record
            	rs.first();
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            	//last record
            	rs.last();
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            	//3rd record from top
            	rs.absolute(3);
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            	//3rd record from bottom
            	rs.absolute(-3);
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            	//relative 
            	rs.relative(2);
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            	//relative
            	rs.relative(-4);
            	System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            }//if
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(ps!=null)
					ps.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally	 
	}//main
}//class
