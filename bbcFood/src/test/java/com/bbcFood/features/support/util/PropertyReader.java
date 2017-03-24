package com.bbcFood.features.support.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private Properties properties = new Properties();
    private InputStream inputStream = null;
//	private String path = "C:\\Users\\olugboyega.aseru\\workspace\\bbcFood\\src\\test\\java\\com\\bbcFood\\features\\support\\propertiesFile\\config.properties";
	private String path = "src/test/java/com/bbcFood/features/support/propertiesFile/config.properties";
	
	 public PropertyReader(){
	        loadProperties();
	    }
	
	
	private void loadProperties(){
        try{
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
        
	}
	
    public String readProperty(String key){
        return properties.getProperty(key);
    }

	
	
	
}
