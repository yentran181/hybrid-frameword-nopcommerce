package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

public class Level_09_Dynamic_Locator_02 extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getRandomEmail();
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserCustomerAddressesPageObject addressesPage;
	private UserRewardPointsPageObject rewardPointsPage;
	private UserMyProductReviewPageObject myProductReviewPage;
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
	@Test
	public void User_02_Login() {

		loginPage = registerPage.clickToLoginLink(); 	
		loginPage.inputToLoginForm(emailAddress, "Email");
		loginPage.inputToLoginForm(password, "Password");
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void User_03_My_Account_Page() {

		customerInforPage = homePage.openMyAccountPage();		
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());	
	}
	
	@Test
	public void User_04_Dynamic_Locator_Page_01() {
		//Customer Info -> Reward points
		rewardPointsPage = (UserRewardPointsPageObject) customerInforPage.openPageAtMyAccountByName(driver, "Reward points");
		
		//Reward points -> Address
		addressesPage = (UserCustomerAddressesPageObject) rewardPointsPage.openPageAtMyAccountByName(driver, "Addresses");
		
		//Address -> Reward points
		rewardPointsPage = (UserRewardPointsPageObject) addressesPage.openPageAtMyAccountByName(driver, "Reward points");
		
		//Reward points -> My product reviews
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointsPage.openPageAtMyAccountByName(driver, "My product reviews");
		
	}
	
	@Test
	public void User_05_Dynamic_Locator_Page_02() {
		myProductReviewPage.openPageAtMyAccountByName(driver, "Orders");
		
		
	}
}
