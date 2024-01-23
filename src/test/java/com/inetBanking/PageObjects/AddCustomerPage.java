package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement AddnewCustomer;
	
	@FindBy(name="name")
	WebElement CustomerName;
	
	@FindBy(name="rad1")
	WebElement Gender;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name ="state")
	WebElement txtstate;
	
	@FindBy(name ="pinno")
	WebElement pincode;
	
	@FindBy(name ="telephoneno")
	WebElement number;
	
	@FindBy(name ="emailid")
	WebElement mail;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="sub")
	WebElement btnsubmit;
	
	public void ClickNewCustomer() {
		AddnewCustomer.click();
	}
	public void custName(String cname) {
		CustomerName.sendKeys(cname);
	}
	public void custgender(String gender) {
		Gender.click();
	}
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	public void custaddress(String address) {
		txtAddress.sendKeys(address);
	}
	public void custcity(String city) {
		txtCity.sendKeys(city);
	}
	public void custstate(String state) {
		txtstate.sendKeys(state);
	}
	public void custpinno(String pinno) {
		pincode.sendKeys(String.valueOf(pinno));
	}
	public void custtelephoneno(String telephone) {
		number.sendKeys(telephone);
	}
	public void custemailId(String cemail) {
		mail.sendKeys(cemail);
	}
	public void custpassword(String password) {
		pass.sendKeys(password);
	}
	public void custsubmit() {
		btnsubmit.click();
	}
}
