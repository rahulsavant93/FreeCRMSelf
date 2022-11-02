package com.qa.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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

			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","C:/Eclipse/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if(browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", "");
			driver = new EdgeDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}








}
