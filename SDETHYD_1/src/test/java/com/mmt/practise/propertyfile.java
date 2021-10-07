package com.mmt.practise;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyfile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Shruthi Badala\\eclipse-workspace\\SDETHYD_1\\common.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty("browser");
System.out.println(value);
	}

}
