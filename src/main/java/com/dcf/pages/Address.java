package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class Address {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By subHeaderText=By.xpath("//span[@class='steptitle']");
	private By streetName = By.id("dcf-field-Street");
	private By houseNumber = By.id("dcf-field-BuildingNumber");
	private By city= By.id("dcf-field-City");
	private By state = By.id("dcf-field-State");
	private By postCode= By.id("dcf-field-Postcode");
	private By continueBtn= By.id("dcf-field-Continue");
	
	
	 public Address(WebDriver driver) {
		 this.driver= driver;
		 eleUtil = new ElementUtil(driver);
	 }
	 
	
	public String getPageTitle() {
		String title= driver.getTitle();
		System.out.println("Basic Info Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Basic Page URL is "+ pageUrl);
		return pageUrl;
	}
	
   public PersonalDetails submitAddressInfo(String streetName, String houseNumber, String city, String state, String postCode) {
	   System.out.println("basic details are : " + streetName + ":" + houseNumber+ ":" +streetName);
		eleUtil.doSendKeysWithWait(this.streetName, AppConstant.MEDIUM_DEFAULT_TIME_OUT, streetName);
		eleUtil.doSendKeysWithWait(this.houseNumber, AppConstant.MEDIUM_DEFAULT_TIME_OUT, houseNumber);
		eleUtil.doSendKeysWithWait(this.streetName, AppConstant.MEDIUM_DEFAULT_TIME_OUT, streetName);
		eleUtil.doSendKeysWithWait(this.city, AppConstant.MEDIUM_DEFAULT_TIME_OUT, city);
		eleUtil.doSendKeysWithWait(this.postCode, AppConstant.MEDIUM_DEFAULT_TIME_OUT, postCode);
		eleUtil.doSendKeysWithWait(this.state, AppConstant.MEDIUM_DEFAULT_TIME_OUT, state);
		
	
		eleUtil.doClick(continueBtn);
		return new PersonalDetails(driver);
		
   }
	
	
}
