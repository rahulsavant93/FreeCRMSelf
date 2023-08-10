package com.qa.freecrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.base.BaseClass;

import com.qa.freecrm.pagelayer.HomePage;
import com.qa.freecrm.pagelayer.LoginPage;
import com.qa.freecrm.utility.TestUtil;

public class HomePageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;



	public HomePageTest(){
		super();
	}

	
	@BeforeMethod
	public void setUp(){

		initialization();
		loginPage  = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
 System.out.println("test pass");
	}

	@Test (priority =1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.getHomePageTitle();
		AssertJUnit.assertEquals(homePageTitle, "Cogmento CRM");
	}

	@Test (priority =2)
	public void addContactsLandingPageTest(){

		homePage.addContactsLandingPage();
	}


	
	
	@AfterMethod 
	  public void tearDown(){ driver.quit(); }
	 

}
