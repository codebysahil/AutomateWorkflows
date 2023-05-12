package comb.qa.dcf.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


import com.dcf.automation.factory.DriverFactory;
import com.dcf.pages.Address;
import com.dcf.pages.BasicInfo;
import com.dcf.pages.EmploymentDetails;
import com.dcf.pages.Experience;
import com.dcf.pages.FinancialInformation;
import com.dcf.pages.GeneralBusinessTerms;
import com.dcf.pages.HomePage;
import com.dcf.pages.PersonalDetails;
import com.dcf.pages.TaxInfo;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;
	public HomePage homePage;
	public BasicInfo basicInfoPage;
	public Address address;
	public PersonalDetails personalDetails;
	public EmploymentDetails employmentDetails;
	public FinancialInformation financialInformation;
	public Experience experience;
	public TaxInfo taxInfo;
	public GeneralBusinessTerms generalBusinessTerms;
	
	@BeforeTest
	public void setup() {
		
		df = new DriverFactory();
		prop =df.initProp();
		
		driver = df.initDriver();
		homePage = new HomePage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
	

}
