package com.qa.freecrm.testcases;
import java.io.IOException;

import net.bytebuddy.build.ToStringPlugin;
import org.testng.annotations.*;

import com.qa.freecrm.base.BaseClass;
import com.qa.freecrm.pagelayer.HomePage;
import com.qa.freecrm.pagelayer.LoginPage;
import com.qa.freecrm.utility.TestUtil;

public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil util;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		util = new TestUtil();
		util.webWelementWait();
	}

	@Test
	public void loginTest(){
				homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));

	}

	@AfterMethod
	public void loginPageScreenshot() throws IOException {
		util.takeScreenshot("loginPage");
	}


	@AfterSuite
	public void logoutTest() {
		homePage.logout(); 
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}



}
