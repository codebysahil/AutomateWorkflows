package com.dcf.automation.dcf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dcf.constatnts.AppConstant;
import com.dcf.pages.PersonalDetails;

import comb.qa.dcf.base.BaseTest;

public class ExperienceDetailsTest extends BaseTest {
	
	@BeforeClass
	public void addressSetUp() {
		basicInfoPage = homePage.openAccountClick();
		address = basicInfoPage.submitBasicDetails("Sahil", "Satija", "Sahil.Satija2011@gmail.com");
		personalDetails = address.submitAddressInfo("test","test","test","test","122009");
		employmentDetails= personalDetails.submitPersoanalDetails(4, "8076813509");
		financialInformation =employmentDetails.submitEmploymentDetails();
		experience = financialInformation.submitFinancialInformationDetails();
	}
	
	@Test
	public void PageTitleTest() {
		String pageTitle = financialInformation.getPageTitle();
		Assert.assertEquals(pageTitle,AppConstant.ADDRESS_PAGE_TITLE);
	}
	@Test
	public void TestExperincePageUrl() {
		
		String pageUrl = financialInformation.getPageUrl();
		Assert.assertEquals(pageUrl.contains(AppConstant.ADDRESS_PAGE_FRACTION_URL), true);
	}
	
	@Test
	public void UserShouldSubmitExperienceDetailsSuccessfully() {
		taxInfo= experience.submitExperienceDetails();
		Assert.assertEquals(taxInfo.getPageTitle(),AppConstant.ADDRESS_PAGE_TITLE);
	}
}
