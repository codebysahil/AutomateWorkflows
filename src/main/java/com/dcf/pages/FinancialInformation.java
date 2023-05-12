package com.dcf.pages;

import org.bouncycastle.jce.provider.BrokenPBE.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dcf.constatnts.AppConstant;
import com.dcf.utils.ElementUtil;

public class FinancialInformation {

	private By primarySourceofWealth = By
			.xpath("//label[@class='checkbox' and @for='dcf-field-PrimarySourcesofWealth-1']");
	private By continueBtn = By.id("dcf-field-Continue");
	private By tradePerMonth = By.xpath("//label[@class='radio'][1]");
//	private By tradePerMonth = By.xpath("//label[@class='radio' and @for='dcf-field-TradesperMonth-6']");

	private By baseCurrency = By.xpath("//select[@name='Currencies']");

	private WebDriver driver;
	private ElementUtil eleUtil;

	public FinancialInformation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("FinancialInformation Page Title" + title);
		return title;
	}

	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("FinancialInformation Page URL is " + pageUrl);
		return pageUrl;
	}

	public Experience submitFinancialInformationDetails() {
		System.out.println("FinancialInformation Detail are :");

		eleUtil.doClickWithWait(this.primarySourceofWealth, AppConstant.SMALL_DEFAULT_TIME_OUT);
		// eleUtil.waitForElementVisible(tradePerMonth,
		// AppConstant.MEDIUM_DEFAULT_TIME_OUT);
		// eleUtil.waitForElementVisible(baseCurrency,
		// AppConstant.MEDIUM_DEFAULT_TIME_OUT);

		scrollPageDown();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doClickWithWait(this.tradePerMonth, AppConstant.LONG_DEFAULT_TIME_OUT);
		eleUtil.selectDropdown(this.baseCurrency, 1);
		// eleUtil.selectDropdown(this.baseCurrency, AppConstant.LONG_DEFAULT_TIME_OUT);

		eleUtil.doClickWithWait(continueBtn, AppConstant.LONG_DEFAULT_TIME_OUT);
		return new Experience(driver);
	}

	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
