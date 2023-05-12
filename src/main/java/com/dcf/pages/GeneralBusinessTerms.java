package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class GeneralBusinessTerms {
	
	private By acceptCheckBox = By.xpath("//label[@class='first-label font-resize' and @for='dcf-field-AcceptTandC']");
	private By continueBtn = By.id("dcf-field-Continue");
	// private By iframe = By.xpath("//textarea[@class='textparagraph-scroll']"); 
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	public GeneralBusinessTerms(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("GeneralBusinessTerms Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("GeneralBusinessTerms Page URL is " + pageUrl);
		return pageUrl;
	}
	public void submitGeneralBusinessTerms() {
		System.out.println("EmploymentDetails are");
		
		eleUtil.doClickWithWait(this.acceptCheckBox, AppConstant.LONG_DEFAULT_TIME_OUT);
		eleUtil.doClickWithWait(this.continueBtn, AppConstant.SMALL_DEFAULT_TIME_OUT);
		
	}
	

}
