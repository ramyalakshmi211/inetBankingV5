package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public   ReadConfig()
	{
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is" +e.getMessage());
			
		}
	}
	
	
	public String getApplicationURL()
	{
		String ApplicationURL=pro.getProperty("baseURL");
		return ApplicationURL;
		
	}

	public String getUserName()
	{
		String UserName=pro.getProperty("Username");
		return UserName;
	}
	
	
	public String getPassword()
	{
		String Password=pro.getProperty("Password");
		return Password;
	}
	
	public String getChromePath()
	{
		String ChromePath=pro.getProperty("ChromePath");
		return ChromePath;
	}
	
	public String getIEdriverpath()
	{
		String IEdriverpath=pro.getProperty(getIEdriverpath());
		return IEdriverpath;
	}
	
	
	
}
