package com.readingpropertiesfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFiles {
	
	public static Properties prop;
	
	public void loadPropertiesFile() throws IOException
	{
		System.out.println("Load Properties File");
		File f=new File("Configuration.properties");
		
		FileInputStream fis=new FileInputStream(f)	;
		
		prop=new Properties();
		
		prop.load(fis);
		System.out.println("Properties File is loaded sucessfully");
	}
	
	
	public String getProperty(String property)
	{
		return prop.getProperty(property);
	}

	

}
