package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {

	/* This method is used to get data from Properties file provided key */
	public String getDataFromPropertyFile(String key) throws Exception {
		FileInputStream file = new FileInputStream("./configAppData/commonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		String data = prop.getProperty(key);
		file.close();
		return data;
	}
}
