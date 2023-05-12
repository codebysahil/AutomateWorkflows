package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class EmploymentDetails {
	

	private By occupation = By.id("dcf-field-Occupation");
	private By areYouPep = By.xpath("//label[@class='radio'][1]");
	private By continueBtn = By.id("dcf-field-Continue");
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	public EmploymentDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("EmploymentDetails Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("EmploymentDetails Page URL is " + pageUrl);
		return pageUrl;
	}
	public FinancialInformation submitEmploymentDetails() {
		System.out.println("EmploymentDetails are");
		eleUtil.selectDropdown(this.occupation, 8);
		eleUtil.doClickWithWait(this.areYouPep, AppConstant.LONG_DEFAULT_TIME_OUT);
		eleUtil.doClickWithWait(this.continueBtn, AppConstant.SMALL_DEFAULT_TIME_OUT);
		return new FinancialInformation(driver);
	}

}
