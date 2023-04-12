package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_User_Apply_Page_Object_Pattern_I_Register extends BasePage {
		private WebDriver driver;
		private String projectPath = System.getProperty("user.dir");
		private String emailAddress = getRandomEmail();
		private UserHomePageObject homePage;
		private UserRegisterPageObject registerPage;
		private String firstname = "Automation", lastname = "FC", password = "123456";
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Driver - class: " + driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com/");
			homePage = new UserHomePageObject(driver);	
		}
		
		@Test
		public void Register_01_Empty_Data() {

			System.out.println("Register_01 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			
			registerPage = new UserRegisterPageObject(driver);
			
			System.out.println("Register_01 - Home Page - Step 02: Click to Register button");
			registerPage.clickToRegisterButton();

			System.out.println("Register_01 - Home Page - Step 03: Verify error message displayed");

			Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
			Assert.assertEquals(registerPage.getErrorMessageAtLasttnameTextbox(), "Last name is required.");
			Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
			Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
			Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
			
		}
		
		@Test
		public void Register_02_Invalid_Email() {
			
			System.out.println("Register_02 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			
			registerPage = new UserRegisterPageObject(driver);

			System.out.println("Register_02 - Home Page - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox("123@abc#@");
			registerPage.inputToPasswordTextbox(password);
			registerPage.inputToConfirmPasswordTextbox(password);
			
			System.out.println("Register_02 - Home Page - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
		
			System.out.println("Register_02 - Home Page - Step 04: Verify error message displayed");
			Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");	
			
		}
		
		@Test
		public void Register_03_Success() {
			
			System.out.println("Register_03 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			registerPage = new UserRegisterPageObject(driver);
		
			System.out.println("Register_03 - Home Page - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox(emailAddress);
			registerPage.inputToPasswordTextbox(password);
			registerPage.inputToConfirmPasswordTextbox(password);
			
			System.out.println("Register_03 - Home Page - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
			
			System.out.println("Register_03 - Home Page - Step 04: Verify success message displayed");
			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");	
		
		//	System.out.println("Home Page - Step 05: Click to Logout link");
			//registerPage.clickToLogoutButton();
		}
		
		@Test
		public void Register_04_Existing_Email() {
			
			System.out.println("Register_04 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			registerPage = new UserRegisterPageObject(driver);

			System.out.println("Register_04 - Home Page - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox(emailAddress);
			registerPage.inputToPasswordTextbox(password);
			registerPage.inputToConfirmPasswordTextbox(password);
			
			System.out.println("Register_04 - Home Page - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
			
			System.out.println("Register_04 - Home Page - Step 04: Verify error existing email message displayed");
			Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");	

		}
		
		@Test
		public void Register_05_Password_Less_Than_6_Chars() {
			System.out.println("Register_05 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			registerPage = new UserRegisterPageObject(driver);

			System.out.println("Register_05 - Home Page - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox(emailAddress);
			registerPage.inputToPasswordTextbox("12345");
			registerPage.inputToConfirmPasswordTextbox("12345");
			
			System.out.println("Register_05 - Home Page - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
			
			System.out.println("Register_05 - Home Page - Step 04: Verify error invalid password message displayed");
			Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

		}
		
		@Test
		public void Register_06_Invalid_Confirm_Password() {
			
			System.out.println("Register_06 - Home Page - Step 01: Click to Register link");
			homePage.openRegisterPage();
			registerPage = new UserRegisterPageObject(driver);

			System.out.println("Register_06 - Home Page - Step 02: Input to require fields");
			registerPage.inputToFirstnameTextbox(firstname);
			registerPage.inputToLastnameTextbox(lastname);
			registerPage.inputToEmailTextbox(emailAddress);
			registerPage.inputToPasswordTextbox("123456");
			registerPage.inputToConfirmPasswordTextbox("1234567");
			
			System.out.println("Register_06 - Home Page - Step 03: Click to Register button");
			registerPage.clickToRegisterButton();
			
			System.out.println("Register_06 - Home Page - Step 04: Verify error invalid confirm password message displayed");
			Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
			
		}
		
		public String getRandomEmail() {
			
			Random random = new Random();
			return "yentran"+random.nextInt(99999)+"@gmail.com";
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
}
