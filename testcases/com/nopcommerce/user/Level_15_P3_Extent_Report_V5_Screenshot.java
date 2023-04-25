package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
import reportConfig.ExtentManagerV5;
import reportConfig.ExtentTestManagerV5;

@Listeners(commons.MethodListener.class)

public class Level_15_P3_Extent_Report_V5_Screenshot extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getRandomEmail();
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserCustomerAddressesPageObject addressesPage;
	private UserRewardPointsPageObject rewardPointsPage;
	private String firstname , lastname, password;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneraterManager.getUserHomePage(driver);	
		
		firstname = "Automation";
		lastname = "FC";
		password = "123456";
	}
	
	@Test
	public void User_01_Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "User_01_Register");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is: " + firstname);
		registerPage.inputToRegisterForm(firstname, "FirstName");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Enter to LastName textbox with value is: " + lastname);
		registerPage.inputToRegisterForm(lastname,"LastName");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is: " + emailAddress);
		registerPage.inputToRegisterForm(emailAddress,"Email");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is: " + password);
		registerPage.inputToRegisterForm(password,"Password");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is: " + password);
		registerPage.inputToRegisterForm(password,"ConfirmPassword");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	@Test
	public void User_02_Login(Method method) {	
		ExtentTestManagerV5.startTest(method.getName(), "User_02_Register");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 01: Navigate to 'Login' page");
		loginPage = registerPage.clickToLoginLink(); 	
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 02: Enter to Email textbox with value is: " + emailAddress);
		loginPage.inputToLoginForm(emailAddress, "Email");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 03: Enter to Password textbox with value is: " + password);
		loginPage.inputToLoginForm(password, "Password");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 06: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login 07: Verify 'Customer info' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());	

		//Customer Info -> Reward points
		rewardPointsPage = (UserRewardPointsPageObject) customerInforPage.openPageAtMyAccountByName(driver, "Reward points");
		
		//Reward points -> Address
		addressesPage = (UserCustomerAddressesPageObject) rewardPointsPage.openPageAtMyAccountByName(driver, "Addresses");
		
		//Address -> Reward points
		rewardPointsPage = (UserRewardPointsPageObject) addressesPage.openPageAtMyAccountByName(driver, "Reward points");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
