package com.dcf.automation.dcf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dcf.constatnts.AppConstant;
import com.dcf.pages.EmploymentDetails;
import com.dcf.pages.PersonalDetails;

import comb.qa.dcf.base.BaseTest;

public class PersoanalDetailsTest extends BaseTest {
	
	@BeforeClass
	public void addressSetUp() {
		basicInfoPage = homePage.openAccountClick();
		address = basicInfoPage.submitBasicDetails("Sahil", "Satija", "Sahitest@gmail.com");
		personalDetails = address.submitAddressInfo("test","test","test","test","122009");
	}
	
	@Test
	public void personalDetailsPageTitleTest() {
		String pageTitle = personalDetails.getPageTitle();
		Assert.assertEquals(pageTitle,AppConstant.ADDRESS_PAGE_FRACTION_URL);
	}
	@Test
	public void personalDetailsPageUrlTest() {
		
		String pageUrl = personalDetails.getPageUrl();
		Assert.assertEquals(pageUrl.contains(AppConstant.ADDRESS_PAGE_FRACTION_URL), true);
	}
	
	
	@Test
	public void submitPersoanalDetailsTest()  {
		employmentDetails= personalDetails.submitPersoanalDetails(4,"8076813509");
		 Assert.assertEquals(employmentDetails.getPageTitle(),AppConstant.BASIC_PAGE_TITLE);
	}
}
