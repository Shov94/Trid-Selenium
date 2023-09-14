package com.trid.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilities {
/**
 * This method is used to get data from property file
 * @author KARMA
 * @param key
 * @return
 * @throws Throwable
 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{

		FileInputStream fis=new FileInputStream(IPathConstants.filePath);
		Properties p= new Properties();
		p.load(fis);

		String value=p.getProperty(key);
		return value;
	}
}
