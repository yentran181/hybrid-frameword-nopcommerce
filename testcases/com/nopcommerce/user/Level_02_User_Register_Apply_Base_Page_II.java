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

public class Level_02_User_Register_Apply_Base_Page_II extends BasePage {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String email = getRandomEmail();
		BasePage basePage;	
		
		@BeforeClass
		public void beforeClass() {
			basePage = BasePage.getBasePage();
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com/");
			
		}
		
		@Test
		public void TC_01_Register_Empty_Data() {
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");
		
			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='FirstName-error']"));
			//Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getCssValue("color"),"#e4434b");
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='FirstName-error']"), "First name is required.");
			
			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='LastName-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='LastName-error']"), "Last name is required.");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='Email-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='Email-error']"), "Email is required.");
			
			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='Password-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='Password-error']"), "Password is required.");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='ConfirmPassword-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='ConfirmPassword-error']"), "Password is required.");
			
		}
		
		@Test
		public void TC_02_Register_Invalid_Email() {
			
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			
			basePage.sendKeyToElement(driver, "xpath=//input[@id='FirstName']", "Automation");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='LastName']", "Testing");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Email']", "123@abc#@");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Password']", "123456");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='ConfirmPassword']", "123456");

			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='Email-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='Email-error']"), "Wrong email");		
			
		}
		
		@Test
		public void TC_03_Register_Success() {
			
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			
			basePage.sendKeyToElement(driver, "xpath=//input[@id='FirstName']", "Automation");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='LastName']", "Testing");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Email']", email);
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Password']", "123456");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='ConfirmPassword']", "123456");

			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");
			
			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//div[@class='result']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//div[@class='result']"), "Your registration completed");		
			System.out.println(email);
		}
		
		@Test
		public void TC_04_Register_Existing_Email() {
			
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			
			basePage.sendKeyToElement(driver, "xpath=//input[@id='FirstName']", "Automation");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='LastName']", "Testing");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Email']", email);
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Password']", "123456");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='ConfirmPassword']", "123456");

			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//div[@class='message-error validation-summary-errors']//li"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");		

		}
		
		@Test
		public void TC_05_Register_Password_Less_Than_6_Chars() {
			
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			
			basePage.sendKeyToElement(driver, "xpath=//input[@id='FirstName']", "Automation");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='LastName']", "Testing");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Email']", email);
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Password']", "12345");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='ConfirmPassword']", "12345");

			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='Password-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");		

		}
		
		@Test
		public void TC_06_Register_Invalid_Confirm_Password() {
			
			basePage.waitForElemetClickable(driver, "xpath=//a[@class='ico-register']");
			basePage.clickToElement(driver, "xpath=//a[@class='ico-register']");
			
			basePage.sendKeyToElement(driver, "xpath=//input[@id='FirstName']", "Automation");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='LastName']", "Testing");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Email']", email);
			basePage.sendKeyToElement(driver, "xpath=//input[@id='Password']", "123456");
			basePage.sendKeyToElement(driver, "xpath=//input[@id='ConfirmPassword']", "123455");

			basePage.waitForElemetClickable(driver, "xpath=//button[@id='register-button']");
			basePage.clickToElement(driver, "xpath=//button[@id='register-button']");

			Assert.assertTrue(basePage.isElementDisplayed(driver, "xpath=//span[@id='ConfirmPassword-error']"));
			Assert.assertEquals(basePage.getTextElement(driver, "xpath=//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");		
			
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
