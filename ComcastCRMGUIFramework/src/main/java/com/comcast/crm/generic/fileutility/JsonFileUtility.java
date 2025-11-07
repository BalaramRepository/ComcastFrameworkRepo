package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {

	/* This method is used to get data from JSON file provided key */
	public String getDataFromJsonFile(String key) throws Exception {
		FileReader file = new FileReader("./configAppData/commonData.json");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(file);
		JSONObject jObj = (JSONObject) object;
		String data = jObj.get(key).toString();
		file.close();
		return data;
	}
}
