package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String adminEmailAddress) {
		waitForElemetVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminEmailAddress);
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitForAllElemetsVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElemetClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String adminEmailAddress, String adminPassword) {
		inputToUsernameTextbox(adminEmailAddress);
		inputToPasswordTextbox(adminPassword);
		return clickToLoginButton();
	}
}
