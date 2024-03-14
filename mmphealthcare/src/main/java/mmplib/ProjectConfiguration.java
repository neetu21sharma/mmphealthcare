package mmplib;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	Properties prop = new Properties();
	public Properties loadProperties(String fName) throws IOException
	{
		//create a file object(specify the filename)
		File f = new File(fName);
		//to read the file - FileInputStream requires file object - file object is reading file from file object to be passed
		FileInputStream fis = new FileInputStream(f.getAbsolutePath());
		prop.load(fis);//store the key value pair in the memory if u want to retrieve the information from properties
		return prop;
		
		
		
		
	}

}