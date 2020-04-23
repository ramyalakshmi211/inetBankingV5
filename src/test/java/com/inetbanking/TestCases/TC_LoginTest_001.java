package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		
		logger.info("Entered Username");
		lp.setPassword(Password);
		
		logger.info("Entered Password");
		lp.ClickSubmit();
		
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			
			logger.info("Login Test Passed");

		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			
			logger.info("Login Test Failed");
			
			
		}
		
	}
	
	

}
