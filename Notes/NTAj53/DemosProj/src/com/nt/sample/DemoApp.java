package com.nt.sample;

import java.text.SimpleDateFormat;

public class DemoApp {

	public static void main(String[] args)throws Exception {
	
		//Converting String date value to java.util.Date class obj
		 String d1="45-19-1990"; //dd-MM-yyyy;
		  SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		  java.util.Date ud1=sdf1.parse(d1);
		  System.out.println("util date"+ud1);
		  //Converting java.util.Date class obj java.sql.Date class obj
		  long ms=ud1.getTime();
		  java.sql.Date sqd=new java.sql.Date(ms);
		  System.out.println("sql date"+sqd);
		  /*if given String date value pattern is "yyyy-MM-dd" then it can
		   be converted directly to java.sql.Date class obj with out converting
		   it to java.util.Date class obj . For this we need to use  valueOf()
		   available in java.sql.Date class.*/
		  String d2="2010-11-23";  //yyyy-MM-dd
		  java.sql.Date sqd2=java.sql.Date.valueOf(d2);
		  System.out.println("String date"+d2);
		  //converting java.sql.Date class obj to java util.Date class obj
		  java.util.Date ud2=(java.util.Date)sqd2;  //type casting
		  System.out.println("Util Date"+ud2);
		  //Converting java.util.Date class obj to String date value
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd");
		   String d3=sdf.format(ud2);
		   System.out.println("String date"+d3);
		   
		   
		  

	}

}
