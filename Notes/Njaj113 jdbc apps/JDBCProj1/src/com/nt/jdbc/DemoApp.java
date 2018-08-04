package com.nt.jdbc;

import java.text.SimpleDateFormat;

public class DemoApp {

	public static void main(String[] args)throws Exception {
		//Converting String date value to java.util Date class class obj
		String d1="20-10-1983"; //dd-MM-yyyy
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud=sdf.parse(d1);
		System.out.println("Util date"+ud);
		//Converting java.util.Date class obj to java.sql.Date class obj
		long ms=ud.getTime();
		java.sql.Date sqd=new java.sql.Date(ms);
		System.out.println("sql date"+sqd);
		/*Converting String date value directly to java.sql.Date class obj
		with out converting it to java.util.Date class obj . The string date 
		pattern must be there in yyyy-MM-dd pattern*/
		String d2="2010-10-25"; //yyyy-MM-dd
		java.sql.Date sqd2=java.sql.Date.valueOf(d2);
		System.out.println("Sql date"+sqd2);
		//Converting java.sql.Date class obj to java.util.Date class obj
		java.util.Date ud2=(java.util.Date)sqd2;
		System.out.println("util date"+ud2);
		//Converting java.util.Date class obj to String date value
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		String d3=sdf1.format(ud2);
		System.out.println("String date"+d3);
		
		
		
		
		
		
		

	}

}
