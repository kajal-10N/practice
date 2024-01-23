package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//Constructor
	 public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name= "password")
	WebElement txtPassword;
	
	@FindBy(name= "btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath ="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit() {
		btnLogin.click();
	}
	
	public void ClickLogout() {
		logout.click();
	}
	
}
