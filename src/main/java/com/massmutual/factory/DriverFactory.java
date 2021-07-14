package com.massmutual.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsmanager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>(); 
	
/**
 * This method is to initialize the driver by passing the browser name via properties file 
 * @param prop - reference of Properties file
 * @return - driver instance
 */
	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser").trim();
		System.out.println("The name of the browser is "+browser);
		optionsmanager = new OptionsManager(prop);

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsmanager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}
		else {
			System.out.println("Please pass the correct browser");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());

		return getDriver();

		
	}
/**
 * This method is to get the threadlocal driver instance
 * @return threadlocal driver
 */
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
	
/**
 * This method is to initialize the Properties file where values are stored in the form of key and value
 * @return reference of Properties file
 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
