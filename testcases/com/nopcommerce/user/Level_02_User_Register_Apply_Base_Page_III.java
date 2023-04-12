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

public class Level_02_User_Register_Apply_Base_Page_III extends BasePage {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String email = getRandomEmail();
		//BasePage basePage;	
		
		@BeforeClass
		public void beforeClass() {
			//basePage = getBasePage();
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com/");
			
		}
		
		@Test
		public void TC_01_Register_Empty_Data() {
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");
		
			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='FirstName-error']"));
			//Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getCssValue("color"),"#e4434b");
			Assert.assertEquals(getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
			
			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='LastName-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");

			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='Email-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
			
			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='Password-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");

			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='ConfirmPassword-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
			
		}
		
		@Test
		public void TC_02_Register_Invalid_Email() {
			
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			
			sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
			sendKeyToElement(driver, "//input[@id='LastName']", "Testing");
			sendKeyToElement(driver, "//input[@id='Email']", "123@abc#@");
			sendKeyToElement(driver, "//input[@id='Password']", "123456");
			sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");

			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='Email-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Wrong email");		
			
		}
		
		@Test
		public void TC_03_Register_Success() {
			
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			
			sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
			sendKeyToElement(driver, "//input[@id='LastName']", "Testing");
			sendKeyToElement(driver, "//input[@id='Email']", email);
			sendKeyToElement(driver, "//input[@id='Password']", "123456");
			sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");
			
			Assert.assertTrue(isElementDisplayed(driver, "//div[@class='result']"));
			Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");		
			System.out.println(email);
		}
		
		@Test
		public void TC_04_Register_Existing_Email() {
			
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			
			sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
			sendKeyToElement(driver, "//input[@id='LastName']", "Testing");
			sendKeyToElement(driver, "//input[@id='Email']", email);
			sendKeyToElement(driver, "//input[@id='Password']", "123456");
			sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");

			Assert.assertTrue(isElementDisplayed(driver, "//div[@class='message-error validation-summary-errors']//li"));
			Assert.assertEquals(getTextElement(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");		

		}
		
		@Test
		public void TC_05_Register_Password_Less_Than_6_Chars() {
			
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			
			sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
			sendKeyToElement(driver, "//input[@id='LastName']", "Testing");
			sendKeyToElement(driver, "//input[@id='Email']", email);
			sendKeyToElement(driver, "//input[@id='Password']", "12345");
			sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");

			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='Password-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");		

		}
		
		@Test
		public void TC_06_Register_Invalid_Confirm_Password() {
			
			waitForElemetClickable(driver, "//a[@class='ico-register']");
			clickToElement(driver, "//a[@class='ico-register']");
			
			sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
			sendKeyToElement(driver, "//input[@id='LastName']", "Testing");
			sendKeyToElement(driver, "//input[@id='Email']", email);
			sendKeyToElement(driver, "//input[@id='Password']", "123456");
			sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123455");

			waitForElemetClickable(driver, "//button[@id='register-button']");
			clickToElement(driver, "//button[@id='register-button']");

			Assert.assertTrue(isElementDisplayed(driver, "//span[@id='ConfirmPassword-error']"));
			Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");		
			
		}
		
		public String getRandomEmail() {
			
			Random random = new Random();
			return "yentran"+random.nextInt(99999)+"@gmail.com";
		}
		
		@AfterClass
		public void afterClass() {
			//driver.quit();
		}
}
