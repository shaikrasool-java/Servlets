package com.nt.jdbc;


import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;


class Filter1 implements Predicate {
    private String colName;

    public Filter1(String colName) {
        this.colName = colName;
        }

    public boolean evaluate(RowSet rs) {
    	System.out.println("evaluate");
        try {
            CachedRowSet crs = (CachedRowSet) rs;
            String object = crs.getString(colName);
            if (object != null && (object.charAt(0) == 'A' || object.charAt(0) == 'a')) {
            return true;
             } else {
            return false;
             }
           } catch (Exception e) {
                return false;
          }
       }//emethod

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
	
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
	
		return false;
	}


}//Filter1 class

public class Row5 {
    public static void main(String[] args) throws Exception {
      //create Filtered Rowset
    	OracleFilteredRowSet frs = new OracleFilteredRowSet();
        frs.setUsername("scott");
        frs.setPassword("tiger");
        frs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        frs.setCommand("select * from emp");
        
        frs.setFilter(new Filter1("ename"));
         frs.execute();
        while (frs.next()) {
        	System.out.println(frs.getInt(1)+"  "+frs.getString(2)+"  "+frs.getString(3));
             }
   }//main
}//class
