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

@Listeners(commons.MethodListener.class)

public class Level_16_P1_Share_Data_Common extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		homePage = PageGeneraterManager.getUserHomePage(driver);	
		
		emailAddress = Common_Register.emailAddress;
		password = Common_Register.password;
		
		log.info("Login 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage(); 	
		
		log.info("Login 02: Enter to Email textbox with value is: " + emailAddress);
		loginPage.inputToLoginForm(emailAddress, "Email");
		
		log.info("Login 03: Enter to Password textbox with value is: " + password);
		loginPage.inputToLoginForm(password, "Password");
		
		log.info("Login 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login 06: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
//		log.info("Login 07: Verify 'Customer info' page is displayed");
//		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed("My account - Customer info"));	
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
