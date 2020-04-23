package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String Username=readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties2");
	
	    if(br.equals("chrome"))
        {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
        }
	    else if(br.equals("IEdriver"))
	    {
		System.setProperty("webdriver.iedriver.driver",readconfig.getIEdriverpath());
		driver=new InternetExplorerDriver();
	    }
	    
	    driver.get(baseURL);
	}
		
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException//tname-testcase name
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	
	
	public String RandomString()
	{
	String generatedstring =RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
		
	}
	
	public static String randomNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return generatedstring2;
	}

}

