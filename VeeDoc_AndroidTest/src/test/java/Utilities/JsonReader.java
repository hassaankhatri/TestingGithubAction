package Utilities;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	String jsonFilePath;
	
	public JsonReader(String filePath) {
		jsonFilePath = filePath;
	}
	
	public String getValue(String key) {
		JSONParser jsonParser = new JSONParser();
		String value = null;
	      try {
	    	  JSONObject jsonObject = (JSONObject)jsonParser.parse(new FileReader(jsonFilePath));
	         value = (String)jsonObject.get(key);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		return value;
	}
}
