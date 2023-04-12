package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
public class Level_08_Switch_Role extends BaseTest {
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	private WebDriver driver;
	private String useremailAddress, userpassword, adminEmailAddress, adminPassword;
	private UserRegisterPageObject registerPage;
	private String firstname , lastname, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		userHomePage = PageGeneraterManager.getUserHomePage(driver);	
		useremailAddress = getRandomEmail();
		userpassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		firstname = "Automation";
		lastname = "FC";

		
	}
	
	@Test
	public void Role_00_Register() {
		registerPage = userHomePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(useremailAddress);
		registerPage.inputToPasswordTextbox(userpassword);
		registerPage.inputToConfirmPasswordTextbox(userpassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");	
	}
	
	@Test
	public void Role_01_User_To_Admin() {
		System.out.println(useremailAddress);
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(useremailAddress, userpassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		clickToLogoutLinkAtUserPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		adminLoginPage = PageGeneraterManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderisDisplayed());
		
	}
	
	@Test
	public void Role_02_Admin_To_User() {
		
	}
	
}

