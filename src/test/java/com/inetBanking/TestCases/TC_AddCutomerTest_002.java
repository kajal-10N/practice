package com.inetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;

public class TC_AddCutomerTest_002 extends BaseClass {

	@Test
	public void addNewCutsomer() throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter Username");
		
		lp.setPassword(password);
		logger.info("Enter Password");
		lp.ClickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
			addcust.ClickNewCustomer();
			
			addcust.custName("kajal");
			addcust.custgender("female");
			addcust.custdob("05","10","1995");
			addcust.custaddress("India");
			addcust.custcity("yavatmal");
			addcust.custstate("Maharatshtra");
			addcust.custpinno("445323");
			addcust.custtelephoneno("9923526381");
			String email= randomestring()+"@gmail.com";
			addcust.custemailId(email);
			
			addcust.custpassword("abcdfe");
			addcust.custsubmit();
			
			Thread.sleep(3000);
			boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
			if(res == true) {
				Assert.assertTrue(true);
			}
			else {
				takescreenshot(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
		}

	public String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	public String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	}
	

