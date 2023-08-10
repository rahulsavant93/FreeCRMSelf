package com.qa.freecrm.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Timeouts;
import com.qa.freecrm.base.BaseClass;

public class TestUtil extends BaseClass{

	public Timeouts webWelementWait() {


		Timeouts time =	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return time;


	}



	public void takeScreenshot(String file) throws IOException {

		File screenshotFile	=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\rahul\\eclipse-workspace\\FreeCRMSelf\\screenshots\\" + file +".png"));

	}

}




