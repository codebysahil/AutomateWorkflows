package com.dcf.automation.dcf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dcf.constatnts.AppConstant;

import comb.qa.dcf.base.BaseTest;

public class BasicInfoTest extends BaseTest {
	
	@BeforeClass
	public void basicSetUp() {
		basicInfoPage = homePage.openAccountClick();
	}
	
	@Test
	public void basicPageTitleTest() {
		String basicInfoPageTitle = basicInfoPage.getBasicPageTitle();
		Assert.assertEquals(basicInfoPageTitle,AppConstant.BASIC_PAGE_TITLE);
	}
	@Test
	public void homePageUrlTest() {
		
		String basicPageUrl = basicInfoPage.getBasicPageUrl();
		Assert.assertEquals(basicPageUrl.contains(AppConstant.BASIC_PAGE_FRACTION_URL), true);

	}
	
	
	@Test
	public void fillBasicInfoTest() throws InterruptedException {
		address = basicInfoPage.submitBasicDetails("Sahil", "Satija", "Sahil.Satija2011@gmail.com");
		Assert.assertEquals(address.getPageTitle(),AppConstant.ADDRESS_PAGE_TITLE);
	}
}
