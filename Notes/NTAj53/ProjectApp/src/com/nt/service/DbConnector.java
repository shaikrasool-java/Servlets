package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nt.model.BookBean;

public class DbConnector
{
	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}//getConnection()

	public ArrayList<BookBean> search(String category)
	{
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookBean> al = new ArrayList<BookBean>();

		try
		{
			//execute the Query
			String searchQuery;
			searchQuery = "SELECT BOOKID, BOOKNAME, AUTHORNAME, STATUS " +
									" FROM SELECT_BOOKS WHERE CATEGORY = ? ";
			ps = con.prepareStatement(searchQuery);

			ps.setString(1, category);
			rs = ps.executeQuery();

			while(rs.next())
			{
				BookBean b = new BookBean();
				b.setBookId(rs.getString(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setStatus(rs.getString(4));
				al.add(b);
			}
			rs.close();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		finally
		{
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		} // finally
		return al;
	} // search()
} // class