package com.qa.freecrm.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.BaseClass;

public class ContactsPage extends BaseClass{
	
	@FindBy(name="first_name")
	WebElement firstName;

	
	@FindBy(name="last_name")
	WebElement lastName;
	
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name ="Email address")
	WebElement email;
	
	@FindBy(xpath="//label[contains(text(),'Category')]/parent::*//i[@class='dropdown icon']")
	WebElement categoryDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Category')]/parent::*//i[@class='dropdown icon']/following-sibling::div/div/span[contains(text(),'Customer')]")
	WebElement categoryCustomer;
		
	@FindBy(xpath="//label[contains(text(),'Status')]/parent::*//i[@class='dropdown icon']")
	WebElement statusDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Status')]/parent::*//i[@class='dropdown icon']/following-sibling::div/div/span[contains(text(),'Active')]")
	WebElement statusActive;
	
	@FindBy(xpath="//div[@class='item']/button/i[@class='save icon']")
	WebElement saveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
