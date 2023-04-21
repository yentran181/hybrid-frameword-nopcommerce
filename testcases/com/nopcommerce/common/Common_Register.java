package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)

public class Common_Register extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstname , lastname;
	public static String emailAddress = getRandomEmail();
	public static String password;
	public static Set<Cookie> loggedCookies;
	
	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all classes test")
	public void Register(String browserName) {
		
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		homePage = PageGeneraterManager.getUserHomePage(driver);
		
		firstname = "Automation";
		lastname = "FC";
		password = "123456";
		
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
		
		log.info("Pre-Condition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Pre-Condition - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage(); 	
		
		log.info("Pre-Condition - Step 10: Enter to Email textbox with value is: " + emailAddress);
		loginPage.inputToLoginForm(emailAddress, "Email");
		
		log.info("Pre-Condition - Step 11: Enter to Password textbox with value is: " + password);
		loginPage.inputToLoginForm(password, "Password");
		
		log.info("Pre-Condition - Step 12: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-Condition - Step 13: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
			
		loggedCookies = getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookies at Common Class: " + cookie);
		}
		
	}
	 
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
