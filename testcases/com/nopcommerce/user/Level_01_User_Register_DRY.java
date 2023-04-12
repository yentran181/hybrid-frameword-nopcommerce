package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_User_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email = getRandomEmail();
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void TC_01_Register_Empty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("span#FirstName-error")).isDisplayed());
		//Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getCssValue("color"),"#e4434b");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("span#LastName-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");

		Assert.assertTrue(driver.findElement(By.cssSelector("span#Email-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");

		Assert.assertTrue(driver.findElement(By.cssSelector("span#Password-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");

		Assert.assertTrue(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");


		
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Testing");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@abc#@");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("span#Email-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");

		

	}
	
	@Test
	public void TC_03_Register_Success() {
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Testing");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div.result")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Testing");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("div.message-error.validation-summary-errors li")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error.validation-summary-errors li")).getText(), "The specified email already exists");

	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		
	driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Testing");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getRandomEmail());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("12345");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("span#Password-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
		//Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "must have at least 6 characters");

	}
	
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		
	driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Testing");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getRandomEmail());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123455");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");

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
