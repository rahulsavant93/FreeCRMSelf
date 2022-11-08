package com.qa.freecrm.testcases;

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
			}

	@Test
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.getHomePageTitle();

		Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}

	@Test
	public void addContactsLandingPageTest(){

		homePage.addContactsLandingPage();
	}

	  @AfterMethod
	  public void tearDown(){
		homePage.logout();
	  }
	 

}
