package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankimg.Utilities.ReadConfig;



public class BaseClass {

	ReadConfig read =new ReadConfig();
	public String baseURL =read.getURL();
	public String username = read.getUsername();
	public String password = read.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");

		
		 logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.Properties");
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		if(br.equals("chrome")) {
				driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	 
	
	@AfterClass
		public void TearDown() {
		driver.quit();
	}
	
	public void takescreenshot(WebDriver driver ,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	
	
	}
