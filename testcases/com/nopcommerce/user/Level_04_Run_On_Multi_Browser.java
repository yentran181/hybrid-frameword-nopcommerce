package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Run_On_Multi_Browser extends BaseTest {
		private WebDriver testClassDriver;
		private String emailAddress = getRandomEmail();
		private UserHomePageObject homePage;
		private UserRegisterPageObject registerPage;
		private UserLoginPageObject loginPage;
		private String firstname , lastname, invalidEmail, notFoundEmail, password, invalidPassword;
		
		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String browserName) {
			System.out.println("Run on" + browserName);
			testClassDriver = getBrowserDriver(browserName, GlobalConstants.NOPCOMMERCE_USER_PAGE_URL);
			System.out.println("Driver - class: " + testClassDriver);
			testClassDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			homePage = new UserHomePageObject(testClassDriver);	
			
			firstname = "Automation";
			lastname = "FC";
			invalidEmail = "yentran18197#gmail.com";
			notFoundEmail = "unregesteremail@gmail.com";
			password = "123456";
			invalidPassword = "wrongpassword";
			
			System.out.println("Pre-condition - Step 01: Click to Register link");
			homePage.openRegisterPage();
			registerPage = new UserRegisterPageObject(testClassDriver);
		
			System.out.println("Pre-condition - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox(emailAddress);
			registerPage.inputToPasswordTextbox(password);
			registerPage.inputToConfirmPasswordTextbox(password);
			
			System.out.println("Pre-condition - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
			
			System.out.println("Pre-condition - Step 04: Verify success message displayed");
			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");	
		}
		
		@Test
		public void Login_01_Empty_Data() {
			
			homePage = new UserHomePageObject(testClassDriver);
			
			System.out.println("Login_01 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
			
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_01 - Login Page - Step 02: Click to Login button");
			loginPage.clickToLoginButton();
			
			System.out.println("Login_01 - Login Page - Step 03: Verify error message displayed");
			Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		}
		
		@Test
		public void Login_02_Invalid_Email() {
			
			homePage = new UserHomePageObject(testClassDriver);

			System.out.println("Login_02 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
		
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_02 - Login Page - Step 02: Input to require fields");	
			loginPage.inputToEmailTextbox(invalidEmail);
			loginPage.inputToPasswordTextbox(password);
			
			System.out.println("Login_02 - Login Page - Step 03: Click to Login button");
			loginPage.clickToLoginButton();

			System.out.println("Login_02 - Login Page - Step 04: Verify error message displayed");
			Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");	
		}
		
		@Test
		public void TC_03_Login_Unregisted_Email() {
			
			homePage = new UserHomePageObject(testClassDriver);

			System.out.println("Login_03 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
			
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_03 - Login Page - Step 02: Input to require fields");	
			loginPage.inputToEmailTextbox(notFoundEmail);
			loginPage.inputToPasswordTextbox(password);

			System.out.println("Login_03 - Login Page - Step 03: Click to Login button");
			loginPage.clickToLoginButton();
			
			System.out.println("Login_03 - Login Page - Step 04: Verify error message displayed");
			Assert.assertEquals(loginPage.getLoginUnsuccessErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"+ "No customer account found");			
		}
		
		@Test
		public void TC_04_Login_Registerd_Email_Empty_Password() {	
			
			homePage = new UserHomePageObject(testClassDriver);

			System.out.println("Login_04 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
			
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_04 - Login Page - Step 02: Input to require fields");	
			loginPage.inputToEmailTextbox(emailAddress);

			System.out.println("Login_04 - Login Page - Step 03: Click to Login button");
			loginPage.clickToLoginButton();
			
			System.out.println("Login_04 - Login Page - Step 04: Verify error message displayed");
			Assert.assertEquals(loginPage.getLoginUnsuccessErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"+ "The credentials provided are incorrect");			
		}
		
		@Test
		public void TC_05_Login_Registerd_Email_Incorrected_Password() {
			
			homePage = new UserHomePageObject(testClassDriver);

			System.out.println("Login_04 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
			
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_04 - Login Page - Step 02: Input to require fields");	
			loginPage.inputToEmailTextbox(emailAddress);
			loginPage.inputToPasswordTextbox(invalidPassword);

			System.out.println("Login_04 - Login Page - Step 03: Click to Login button");
			loginPage.clickToLoginButton();
			
			System.out.println("Login_04 - Login Page - Step 04: Verify error message displayed");
			Assert.assertEquals(loginPage.getLoginUnsuccessErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"+ "The credentials provided are incorrect");					
		}
		
		@Test
		public void TC_06_Login_Success() {
			
			homePage = new UserHomePageObject(testClassDriver);

			System.out.println("Login_04 - Login Page - Step 01: Click to Login Link");
			homePage.openLoginPage();
			
			loginPage = new UserLoginPageObject(testClassDriver);
			
			System.out.println("Login_04 - Login Page - Step 02: Input to require fields");	
			loginPage.inputToEmailTextbox(emailAddress);
			loginPage.inputToPasswordTextbox(password);

			System.out.println("Login_04 - Login Page - Step 03: Click to Login button");
			loginPage.clickToLoginButton();
			
			homePage = new UserHomePageObject(testClassDriver);
			Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		}
		
		@AfterClass
		public void afterClass() {
			testClassDriver.quit();
		}
}
