package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class TaxInfo {

	private By nationalIdNumber = By.id("dcf-field-NIN_1"); //852596351254
	private By taxIdentificationNumber = By.id("dcf-field-TIN"); //bqmps8568j
	private By continueBtn = By.id("dcf-field-Continue");
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	public TaxInfo(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("TaxInfo Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("TaxInfo Page URL is " + pageUrl);
		return pageUrl;
	}

	public GeneralBusinessTerms submitTaxInfoDetails() {
		System.out.println("TaxInfo Detail are :");

		eleUtil.doSendKeysWithWait(this.nationalIdNumber, AppConstant.LONG_DEFAULT_TIME_OUT, "852596351254");
		eleUtil.doSendKeysWithWait(this.taxIdentificationNumber, AppConstant.LONG_DEFAULT_TIME_OUT,"bqmps8568j");
		
		eleUtil.doClickWithWait(continueBtn, AppConstant.LONG_DEFAULT_TIME_OUT);
		return new GeneralBusinessTerms(driver);
	}
}
