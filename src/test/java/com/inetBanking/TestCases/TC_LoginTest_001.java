package com.inetBanking.TestCases;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter Username");
		
		lp.setPassword(password);
		logger.info("Enter Password");
		
		lp.ClickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		
		 Assert.assertTrue(true);
		 logger.info("test case pass");
		
		}
		else {
			
			takescreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("test case fail");
		}
	}
		
	
}
