package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserCustomerAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;

@Listeners(commons.MethodListener.class)

public class Level_18_P1_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getRandomEmail();
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserCustomerAddressesPageObject addressesPage;
	private UserRewardPointsPageObject rewardPointsPage;
	private String firstname , lastname, password;
	private String gender, date, month, year;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneraterManager.getUserHomePage(driver);	
		
		firstname = "Automation";
		lastname = "FC";
		password = "123456";
		gender = "Female";
		date = "18";
		month = "1";
		year = "1997";
	}
	
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02: Select gender is: " + gender);
		registerPage.clickToRadioButtonBylabel(driver, gender);
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is: " + firstname);
		registerPage.inputToTextboxByID(driver, "FirstName", firstname);
		
		log.info("Register - Step 03: Enter to LastName textbox with value is: " + lastname);
		registerPage.inputToTextboxByID(driver, "LastName", lastname);
	
		log.info("Register - Step 04: Select Date Of Birth in dropdown with value d/m/y: " + date + "/" + month + "/" + year);
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04: Enter to Email textbox with value is: " + emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		registerPage.checkToCheckboxByLabelName(driver, "Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		 
		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is: " + password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clicktoButtonByText(driver, "Register");;
		
		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	@Test
	public void User_02_Login() {	
		log.info("Login 01: Navigate to 'Login' page");
		loginPage = registerPage.clickToLoginLink(); 	
		
		log.info("Login 02: Enter to Email textbox with value is: " + emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login 03: Enter to Password textbox with value is: " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Login 04: Click to 'Login' button");
		loginPage.clicktoButtonByText(driver, "Log in");

		
		log.info("Login 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		log.info("My Account - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxAttributeValueByID(driver, "FirstName"), firstname);
	
		log.info("Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxAttributeValueByID(driver, "LastName"), lastname);

		log.info("Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxAttributeValueByID(driver, "Email"), emailAddress);

	
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
