package com.dcf.automation.dcf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dcf.constatnts.AppConstant;
import com.dcf.pages.PersonalDetails;

import comb.qa.dcf.base.BaseTest;

public class EmployementlDetailsTest extends BaseTest {
	
	@BeforeClass
	public void addressSetUp() {
		basicInfoPage = homePage.openAccountClick();
		address = basicInfoPage.submitBasicDetails("Sahil", "Satija", "Sahil.Satija2011@gmail.com");
		personalDetails = address.submitAddressInfo("test","test","test","test","122009");
		employmentDetails= personalDetails.submitPersoanalDetails(4, "8076813509");
	}
	
	@Test
	public void employementDetailsPageTitleTest() {
		String pageTitle = employmentDetails.getPageTitle();
		Assert.assertEquals(pageTitle,AppConstant.ADDRESS_PAGE_TITLE);
	}
	@Test
	public void employementDetailsPageUrlTest() {
		
		String pageUrl = employmentDetails.getPageUrl();
		Assert.assertEquals(pageUrl.contains(AppConstant.ADDRESS_PAGE_FRACTION_URL), true);
	}
	
	@Test
	public void submitEmpDetailsTest(){
		financialInformation = employmentDetails.submitEmploymentDetails();
		Assert.assertEquals(financialInformation.getPageTitle(),AppConstant.ADDRESS_PAGE_TITLE);
	}
}
