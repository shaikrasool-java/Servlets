package com.nt.jdbc;

import javax.sql.rowset.JoinRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class Row4 {

	public static void main(String[] args)throws  Exception {
		//Create CachedRowSet
		OracleCachedRowSet crowset1= new oracle.jdbc.rowset.OracleCachedRowSet();
		 crowset1.setUsername("scott");
		 crowset1.setPassword("Tiger");
		 crowset1.setUrl("jdbc:oracle:oci8:@xe");
		 crowset1.setCommand("select empno,ename,deptno from emp");
		 crowset1.setMatchColumn(3);
		 crowset1.execute();
		 
		 //Create CachedRowset
		 OracleCachedRowSet crowset2= new oracle.jdbc.rowset.OracleCachedRowSet();
		 crowset2.setUsername("scott");
		 crowset2.setPassword("Tiger");
		 crowset2.setUrl("jdbc:oracle:oci8:@xe");
		 crowset2.setCommand("select deptno,dname,loc from dept");
		 crowset2.setMatchColumn(1);
		 crowset2.execute();
		 
		 //create JoinRowset
		 JoinRowSet joinRowSet=new OracleJoinRowSet();
		   joinRowSet.addRowSet(crowset2);
		   joinRowSet.addRowSet(crowset1);
		  while(joinRowSet.next()){
			  System.out.println(joinRowSet.getString(1)+"  "+joinRowSet.getString(2)+"  "+joinRowSet.getString(3)+"  "+joinRowSet.getString(4)+"  "+joinRowSet.getString(5));
		   }
		 
		 
		  crowset1.close();
		  crowset2.close();
		  joinRowSet.close();
		 
		
	
	}//main
}//class

