package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	
	@Test(dataProvider="LoginData")  //need to specify name of the data priovider or else test case can't understand frm whch DP need to take data
	public void LoginDDT(String user,String pwd )
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.ClickSubmit();
	
	
	
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login Failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login passed");
		lp.ClickLogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
}
	
	public boolean isAlertPresent()  //user defined method created to check if alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/Logindata.xlsx";
		int rowcount=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][] =new String [rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getcellData(path, "Sheet1", i,j); //1 0
			}
		}
		return logindata;
	}

}
