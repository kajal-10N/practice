package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankimg.Utilities.XLUtils;
import com.inetBanking.PageObjects.LoginPage;

public class Tc_loginTest_DD_001 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDD(String user,String pwd) throws InterruptedException {
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user Name");
		lp.setPassword(pwd);
		logger.info("Password Provided");
		lp.ClickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("failed");
		}
		else {
			Assert.assertTrue(true);
			lp.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); ///close logout alert
			driver.switchTo().defaultContent();
			logger.info("test case pass");
		}
		
	}
	
	public boolean isAlertPresent() {
		try 
		{
		driver.switchTo().alert();
		return true;
	}
		catch(NoAlertPresentException e) {
			return false;
		}
			
		}
	@DataProvider(name="LoginData")

	String [][]getData() throws IOException{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/LoginData.xlsx";
		int rownum =XLUtils.getRowCount(path, "Sheet1");
		int Colcount =XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][Colcount];
		
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<Colcount;j++) 
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
			
		}
		return logindata;
				}

}
