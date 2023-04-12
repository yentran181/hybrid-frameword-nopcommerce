package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserHomePageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
