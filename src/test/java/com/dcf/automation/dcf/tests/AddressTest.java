package com.dcf.automation.dcf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dcf.constatnts.AppConstant;


import comb.qa.dcf.base.BaseTest;

public class AddressTest extends BaseTest {
	
	@BeforeClass
	public void addressSetUp() {
		basicInfoPage = homePage.openAccountClick();
		address = basicInfoPage.submitBasicDetails("Sahil", "Satija", "Sahil.Satija2011@gmail.com");
	}
	
	@Test
	public void basicPageTitleTest() {
		String pageTitle = address.getPageTitle();
		Assert.assertEquals(pageTitle,AppConstant.BASIC_PAGE_TITLE);
	}
	@Test
	public void homePageUrlTest() {
		
		String pageUrl = address.getPageUrl();
		Assert.assertEquals(pageUrl.contains(AppConstant.BASIC_PAGE_FRACTION_URL), true);
	}
	
	
	@Test
	public void submitAddressTest() throws InterruptedException {
		personalDetails= address.submitAddressInfo("test","test","test","test","122009");
		Assert.assertEquals(personalDetails.getPageTitle(),AppConstant.ADDRESS_PAGE_TITLE);
	}
}
