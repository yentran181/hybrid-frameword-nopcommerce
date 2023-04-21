package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
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

public class Level_16_P3_Share_Data_Cookies extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
		homePage = PageGeneraterManager.getUserHomePage(driver);	
		
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage(); 	
		
		log.info("Login - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_Register.loggedCookies);
		loginPage.refreshCurrentPage(driver);
			
		log.info("Login - Step 03: Verify 'My Account' link is displayed");
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
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
