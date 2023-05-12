package com.dcf.automation.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	Properties prop;
	public WebDriver initDriver() {
			
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.home.saxo/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();

	return driver;
}
	/**
	 * this returns properties reference with all config properties
	 * @return  returns properties reference
	 */
	public Properties initProp(){
		 prop = new Properties();  // create object of Property class
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");  // make a connection to the property file
			prop.load(ip); // read all the properties
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;  // return 
		
		
	}

}
