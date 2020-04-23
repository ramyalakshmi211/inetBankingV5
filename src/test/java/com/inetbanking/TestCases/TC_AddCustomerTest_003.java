package com.inetbanking.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.AddCustomerPage;
import com.inetbanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addnewcustomer() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		logger.info("Username provided");
		lp.setPassword(Password);
		logger.info("Password Provided");
		lp.ClickSubmit();
		
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.ClickAddNewCustomer();
		
		logger.info("Providing Customer details");
		addcust.custName("Ramya");
		addcust.custgender("female");
		addcust.custdob("18", "09", "1994");
		addcust.custaddress("Gorantla");
		addcust.custcity("Anantapur");
		addcust.custstate("AP");
		addcust.custpinno("515231");
		addcust.custtelephoneno("9550596367");
		
		String email=RandomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		
		 boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		 if(res==true)
		 {
			 Assert.assertTrue(true);
			 logger.info("Test case passed");
		 }
		 else
		 {
			 Assert.assertTrue(false);
			 captureScreen(driver,"addnewcustomer");
			 logger.info("test case failed");
		 }
		
		
		
		
	}

}
