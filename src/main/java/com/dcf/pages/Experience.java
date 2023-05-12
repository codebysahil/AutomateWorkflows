package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class Experience {
	
	private By levelOfExperience = By.xpath("//label[@class='radio' and @for='dcf-field-KnowledgeOfFinancialInstruments-2']");
	
	private By financialInstrumentsTraded = By.xpath("//label[@class='checkbox' and @for='dcf-field-ProductTradingExperience-6']");
	private By continueBtn = By.id("dcf-field-Continue");

	private WebDriver driver;
	private ElementUtil eleUtil;

	public Experience(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Experience Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Experience Page URL is " + pageUrl);
		return pageUrl;
	}

	public TaxInfo submitExperienceDetails() {
		System.out.println("Experience Detail are : " );

		eleUtil.doClickWithWait(this.levelOfExperience, AppConstant.SMALL_DEFAULT_TIME_OUT);
		eleUtil.doClickWithWait(this.financialInstrumentsTraded, AppConstant.SMALL_DEFAULT_TIME_OUT);
		
		eleUtil.doClickWithWait(continueBtn, AppConstant.SMALL_DEFAULT_TIME_OUT);
		return new TaxInfo(driver);
	}
	

}
