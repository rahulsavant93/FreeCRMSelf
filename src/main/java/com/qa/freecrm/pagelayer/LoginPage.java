package com.qa.freecrm.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath ="//div[contains(text(),'Login')]")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pwd) {
		
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

}
