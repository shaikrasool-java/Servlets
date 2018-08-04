package com.nt.jdbc;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class Row1 {

	public static void main(String[] args)throws  Exception {
		
		RowSet jrowset= new oracle.jdbc.rowset.OracleJDBCRowSet();
		 jrowset.setUsername("scott");
		 jrowset.setPassword("Tiger");
		 jrowset.setUrl("jdbc:oracle:oci8:@xe");
		 jrowset.setCommand("select * from student");
		 jrowset.execute();
		 int cnt=0;
		 while(jrowset.next()){
			 if(cnt==0){
				 System.out.println("sleeep mode");
				 Thread.sleep(20000);
			 }
		     System.out.println(jrowset.getInt(1)+" "+jrowset.getString(2)+"  "+jrowset.getString(3));
		     cnt++;
		   }
		 
		 
		jrowset.close();
	}//main
}//class

