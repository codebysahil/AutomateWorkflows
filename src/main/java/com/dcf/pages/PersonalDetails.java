package com.dcf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class PersonalDetails {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By gender = By.xpath("//div[@class='option'][1]");
	private By dd = By.id("dcf-date-dcf-field-DateofBirth");
	private By mm = By.id("dcf-month-dcf-field-DateofBirth");
	private By yy = By.id("dcf-year-dcf-field-DateofBirth");
	private By mobile = By.id("dcf-phonenumber-dcf-field-Phone");

	private By continueBtn = By.id("dcf-field-Continue");

	public PersonalDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("PersonalDetails Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("PersonalDetails Page URL is " + pageUrl);
		return pageUrl;
	}

	public EmploymentDetails submitPersoanalDetails(int yy, String mobile) {
		System.out.println("Persoanal Detail are : " + yy + ":" + mobile);

		eleUtil.doClickWithWait(this.gender, AppConstant.SMALL_DEFAULT_TIME_OUT);
		eleUtil.selectDropdown(this.dd, 1);
		eleUtil.selectDropdown(this.mm, 2);
		eleUtil.selectDropdown(this.yy, 3);
		eleUtil.doSendKeysWithWait(this.mobile, AppConstant.SMALL_DEFAULT_TIME_OUT, mobile);

		eleUtil.doClickWithWait(continueBtn, AppConstant.SMALL_DEFAULT_TIME_OUT);
		return new EmploymentDetails(driver);
	}

}
