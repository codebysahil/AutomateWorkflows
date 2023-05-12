package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class BasicInfo {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// By Locators
	private By firstName = By.id("dcf-field-Firstname");
	private By lastName = By.id("dcf-field-Lastname");
	private By emailId = By.id("dcf-field-Email");
	private By marketingConsent = By.xpath("//label[@class ='first-label font-resize'][1]");
	private By continueBtn = By.id("dcf-field-Continue");
	private By confirmYourEmail = By.id("dcf-field-Confirmyouremail");

	public BasicInfo(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getBasicPageTitle() {
		String title = driver.getTitle();
		System.out.println("Basic Info Page Title" + title);
		return title;
	}

	public String getBasicPageUrl() {
		String basicPageUrl = driver.getCurrentUrl();
		System.out.println("Basic Page URL is " + basicPageUrl);
		return basicPageUrl;
	}

	public Address submitBasicDetails(String fName, String lName, String email) {
		System.out.println("basic details are : " + firstName + ":" + lastName + ":" + emailId);
		eleUtil.doSendKeysWithWait(this.firstName, AppConstant.MEDIUM_DEFAULT_TIME_OUT, fName);
		eleUtil.doSendKeysWithWait(this.lastName, AppConstant.MEDIUM_DEFAULT_TIME_OUT, lName);
		eleUtil.doSendKeysWithWait(this.emailId, AppConstant.MEDIUM_DEFAULT_TIME_OUT, email);
		try {
			if (eleUtil.checkSingleElementExist(confirmYourEmail)) {
				System.out.println("confirmYourEmail) exist");
				eleUtil.doSendKeysWithWait(this.confirmYourEmail, AppConstant.SMALL_DEFAULT_TIME_OUT, email);
			}
	    }
		catch (Exception e) {
			System.out.println("confirmYourEmail exception");
		}
		
		eleUtil.doClickWithWait(marketingConsent, AppConstant.SMALL_DEFAULT_TIME_OUT);
		System.out.println("continueBtn exist");
		
		try {
		eleUtil.doClickWithWait(continueBtn, AppConstant.SMALL_DEFAULT_TIME_OUT);
		}
		catch (Exception e) {
			System.out.println("continueBtn exception");
		}
		System.out.println("return new Address");
		return new Address(driver);
	
			// TODO: handle exception
		}
}
		