package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	// By locators-- ObjectRepository
	private WebDriver driver;
	private By openAccount = By.id("secondactionbuttonid");
	
	
	// page constructor
	
	public HomePage( WebDriver driver) {
		
		this.driver= driver;
	}
	// page actions or behavior or actions of this page
	
	
	public String getHomePageTitle() {
		
		String title= driver.getTitle();
		System.out.println("Login Page Title" + title);
		return title;
	}
	
	public String getHomePageUrl() {
		String homePageUrl = driver.getCurrentUrl();
		System.out.println("Home Page URL is "+ homePageUrl);
		return homePageUrl;
	}
	
	
	public boolean openAccountExist() {
		return driver.findElement(openAccount).isDisplayed();
		
		
	}
	
	public BasicInfo openAccountClick() {
		
		driver.findElement(openAccount).click();
		return new BasicInfo(driver);
	}



}
