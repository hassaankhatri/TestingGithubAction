package Utilities;

import org.yaml.snakeyaml.Yaml;

import Utilities.JsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YmlUtil {

	public String getDataYML(String fileName, String firstlevel, String secondlevel) throws FileNotFoundException {
		Map<String, Object> dataFile = getDataByYMLFile(fileName);
		Map<String, Object> dataA = (Map<String, Object>) dataFile.get(firstlevel);
		String value = (String) dataA.get(secondlevel);
		return value;
	}
	
	public String getDataYML(String fileName, String firstlevel) throws FileNotFoundException {
		Map<String, Object> dataT  = getDataByYMLFile(fileName);
		Map<String, Object> dataA = (Map<String, Object>) dataT.get(firstlevel);
		return dataA.toString();
	}

	public Map<String, Object> getDataByYMLFile(String fileName) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(new File(fileName));
		Yaml yaml = new Yaml();
		Map<String, Object> dataT = yaml.load(inputStream);
		return dataT;
	}




}
