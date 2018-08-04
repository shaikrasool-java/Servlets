package com.nt.jdbc;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Row2 {

	public static void main(String[] args)throws  Exception {
		
		OracleCachedRowSet crowset= new oracle.jdbc.rowset.OracleCachedRowSet();
		 crowset.setUsername("scott");
		 crowset.setPassword("Tiger");
		 crowset.setUrl("jdbc:oracle:oci8:@xe");
		 crowset.setCommand("select * from student");
		 crowset.execute();
		 int cnt=0;
		 while(crowset.next()){
			 if(cnt==0){
				 Thread.sleep(30000);
			 }
		     System.out.println(crowset.getInt(1)+" "+crowset.getString(2)+"  "+crowset.getString(3));
		     cnt++;
		   }
		/* crowset.setReadOnly(false);
		 System.out.println("Before Sleep");
		 Thread.sleep(30000); //pause DB
		 System.out.println("After Sleep");
		 //modify record in disconnected mode
		 crowset.absolute(4);
		  crowset.updateString(2,"BigBBC");
		 crowset.updateRow();
		 System.out.println("Before Sleep1");
		 Thread.sleep(30000);  //Restrart DB
		 System.out.println("After Selep1");
		 crowset.acceptChanges();
		 while(crowset.next()){
		     System.out.println(crowset.getInt(1)+" "+crowset.getString(2)+"  "+crowset.getString(3));
		   }*/
		crowset.close();
	}//main
}//class

