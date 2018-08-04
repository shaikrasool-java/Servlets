package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropsTest {
	public static void main(String[] args)throws Exception {
		//Locate the file Using stream
		InputStream is=
				new FileInputStream("src/com/nt/commons/myfile.properties");
		//Load properties file content into java.util.Properties
		Properties props=new Properties();
		props.load(is);
		//Display data
		System.out.println(props);
		System.out.println("age key value"+props.getProperty("age"));
	}//main
}//class

