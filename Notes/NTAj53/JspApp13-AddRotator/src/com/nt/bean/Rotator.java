package com.nt.bean;

import java.util.Random;

public class Rotator {
	private String images[]={"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"};
	private String links[]={"http://www.titan.com","http://www.nataraz.in",
			                                    "http://www.nareshit.com","http://www.olacabs.com",
			                                    "http://www.uber.com"};
	private  int counter;
	
	public void nextAdvertisement(){
		Random rad=null;
		rad=new Random();
		counter=rad.nextInt(4);
	}//nextAdvertisement()
	
	public String getImage(){
		return images[counter];
	}
	
	public String getLink(){
		return links[counter];
	}
}//class
