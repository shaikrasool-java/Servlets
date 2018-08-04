package com.nt.jdbc;

import java.io.FileWriter;

import oracle.jdbc.rowset.OracleWebRowSet;

public class Row3 {

	public static void main(String[] args)throws  Exception {
		
		OracleWebRowSet wrowset= new oracle.jdbc.rowset.OracleWebRowSet();
		wrowset.setUsername("scott");
		 wrowset.setPassword("Tiger");
		 wrowset.setUrl("jdbc:oracle:oci8:@xe");
		 wrowset.setCommand("select * from student");
		 wrowset.execute();
		 while(wrowset.next())
		 {
			 System.out.println(wrowset.getInt(1)+"  "+wrowset.getString(2)+"  "+wrowset.getString(3));
		 }
		 
		  FileWriter fw=new FileWriter("d:\\student.xml");
		  wrowset.writeXml(fw);
		  
		  wrowset.writeXml(System.out);
		 
		  System.out.println("End of App");
		 
		wrowset.close();
	}//main
}//class

