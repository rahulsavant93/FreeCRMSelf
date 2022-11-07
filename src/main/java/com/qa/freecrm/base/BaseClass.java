package com.qa.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseClass {
	public static Properties prop = new Properties();
	public static  WebDriver driver;
	public BaseClass() {
		try {


			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/freecrm/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {


		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			/*options.addArguments("headless");
			options.addArguments("disable-gpu");*/

			driver = new ChromeDriver(options);

		}

		else if(browserName.equals("firefox")) {
			FirefoxOptions options2 = new FirefoxOptions();
			//System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		else if(browserName.equals("Edge")) {
			EdgeOptions options3 = new EdgeOptions();
			//System.setProperty("webdriver.edge.driver", "");
			driver = new EdgeDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}








}
