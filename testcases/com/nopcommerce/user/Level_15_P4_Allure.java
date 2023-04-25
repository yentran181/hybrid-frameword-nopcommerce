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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class Level_15_P4_Allure extends BaseTest {
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
	
	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToRegisterForm(firstname, "FirstName");
		
		registerPage.inputToRegisterForm(lastname,"LastName");
		
		registerPage.inputToRegisterForm(emailAddress,"Email");
		
		registerPage.inputToRegisterForm(password,"Password");
		
		registerPage.inputToRegisterForm(password,"ConfirmPassword");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {	
		loginPage = registerPage.clickToLoginLink(); 	
		
		loginPage.inputToLoginForm(emailAddress, "Email");
		
		loginPage.inputToLoginForm(password, "Password");
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		customerInforPage = homePage.openMyAccountPage();
		
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
