package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password, firstname, lastname;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		homePage = PageGeneraterManager.getUserHomePage(driver);	
		
		firstname = "Automation";
		lastname = "FC";
		password = "123456";
		emailAddress = getRandomEmail();
		
		log.info("Pre-Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value is: " + firstname);
		registerPage.inputToRegisterForm(firstname, "FirstName");
		
		log.info("Pre-Condition - Step 03: Enter to LastName textbox with value is: " + lastname);
		registerPage.inputToRegisterForm(lastname,"LastName");
		
		log.info("Pre-Condition - Step 04: Enter to Email textbox with value is: " + emailAddress);
		registerPage.inputToRegisterForm(emailAddress,"Email");
		
		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is: " + password);
		registerPage.inputToRegisterForm(password,"Password");
		
		log.info("Pre-Condition - Step 06: Enter to ConfirmPassword textbox with value is: " + password);
		registerPage.inputToRegisterForm(password,"ConfirmPassword");
		
		log.info("Pre-Condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-Condition - Step 07: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
				
		log.info("Pre-Condition - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage(); 	
		
		log.info("Pre-Conditionin - Step 10: Enter to Email textbox with value is: " + emailAddress);
		loginPage.inputToLoginForm(emailAddress, "Email");
		
		log.info("Pre-Condition - Step 11: Enter to Password textbox with value is: " + password);
		loginPage.  inputToLoginForm(password, "Password");
		
		log.info("Pre-Condition - Step 12: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-Condition - Step 13: Verify 'Customer info' page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());	

	}
	
	@Test
	public void Search_01_Empty_Data() {
		
	}
	
	@Test
	public void Search_02_Relative_Product_Name() {
		
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}
	
	@Test
	public void Search_04_Parent_Category() {
		
	}
	
	@Test
	public void Search_05_Incorrect_Manufactorer() {
		
	}
	
	@Test
	public void Search_06_Correct_Manufactorer() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
