package com.qa.freecrm.pagelayer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.base.BaseClass;
import com.qa.freecrm.utility.TestUtil;

public class HomePage extends BaseClass{

	TestUtil testUtil = new TestUtil();


	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement Contacts;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]/parent::*/following-sibling::button/i")
	WebElement addContactsButton;
	
	@FindBy(xpath = "//i[@class='settings icon']")
	WebElement settings;
	
	@FindBy(xpath = "//i[@class='settings icon']/following-sibling::div/a[5]//span[contains(text(),'Log Out')]")
	WebElement logout;

	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {
	
		 return driver.getTitle();
		
		
	}
	
	public ContactsPage addContactsLandingPage() {
		Actions a = new Actions(driver);
		a.moveToElement(Contacts).build().perform();
		testUtil.webWelementWait();
		addContactsButton.click();
		return new ContactsPage();
	}
	
	public void logout() {
		settings.click();
		logout.click();
	}

}
