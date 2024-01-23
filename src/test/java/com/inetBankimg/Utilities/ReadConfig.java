package com.inetBankimg.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;

public class ReadConfig {

	Properties pro; //object of properties class
	
	//to load the value
	public ReadConfig() {
		File src = new File ("./Configurations\\config.Properties");//src refering property file
		try {
			FileInputStream f = new FileInputStream(src);  //open file into read mode
			pro = new Properties();
			pro.load(f);       //load is method  load complete file
			
		}catch(Exception e){
			System.out.println("Exception is :"+e.getMessage());
		}
	}
	
	//method for read and return value
	
	public String getURL()  {
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	public String getUsername() {
		String name=pro.getProperty("username");
		return name;
	}
	public String getPassword() {
		
		String pass=pro.getProperty("password");
		return pass;
		
	}
	
//	public String getChromePath() {
//		String path = pro.getProperty("chromepath");
//		return path;
//	}
}
