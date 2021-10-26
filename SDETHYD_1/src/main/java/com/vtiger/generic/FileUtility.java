package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This Method will read the the data from prop file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropfile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Shruthi Badala\\git\\SDETHYD_1\\SDETHYD_1\\common.properties");

		Properties prop = new Properties();
		prop.load(fis);
		String keys = prop.getProperty(key);
		return keys;
		
	}
}
