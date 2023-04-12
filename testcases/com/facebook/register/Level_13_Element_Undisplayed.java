package com.facebook.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.facebook.register.LoginPageObject;
import pageObjects.facebook.register.PageGeneratorManager;

@Listeners(commons.MethodListener.class)

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getRandomEmail();
	private LoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.FACEBOOK_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}
	
	@Test
	public void User_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void User_01_Verify_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailAddressTextbox(emailAddress);
		verifyTrue(loginPage.isConfirmEmailAddressTexboxDisplayed());

		loginPage.enterToEmailAddressTextbox("");
		sleepInSecond(3);
		verifyFalse(loginPage.isConfirmEmailAddressTexboxDisplayed());
	}
	
	@Test
	public void User_01_Verify_Element_Undisplayed_Not_In_DOM() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
