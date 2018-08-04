package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsTest {
	public static void main(String[] args) {
		InputStream is=null;
		Properties props=null;
		try{
		//locate file using inputStream
		is=new FileInputStream("src/com/nt/commons/personalDetails.properties");
        //load Properties file data into java.util.Properties class obj
		 props=new Properties();
		props.load(is);
		System.out.println("props data"+props);
		System.out.println("name key value"+props.getProperty("name"));
		
		}//try
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
