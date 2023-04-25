package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to 'Login' button")
	public UserHomePageObject clickToLoginButton() {
		waitForElemetClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageGeneraterManager.getUserHomePage(driver);
	}
	
	@Step("Enter to {1} textbox with value is {0}")
	public void inputToLoginForm(String value, String fieldName) {
		waitForElemetVisible(driver,LoginPageUI.LOGIN_FORM_TEXTBOX, fieldName);
		sendKeyToElement(driver, value, LoginPageUI.LOGIN_FORM_TEXTBOX, fieldName);
	}
	
	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddess) {
		waitForElemetVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, emailAddess, LoginPageUI.EMAIL_TEXTBOX);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElemetVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, password, LoginPageUI.PASSWORD_TEXTBOX);
	}
	
	@Step("Verify error message at 'Email' textbox is displayed")
	public String getErrorMessageAtEmailTextbox() {
		waitForElemetVisible(driver, LoginPageUI.EMAIL_ERROR_MESSGAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSGAGE);
	}

	@Step("Verify login fail message is displayed")
	public String getLoginUnsuccessErrorMessage() {
		waitForElemetVisible(driver, LoginPageUI.LOGIN_UNSUCCESS_MESSGAGE);
		return getTextElement(driver, LoginPageUI.LOGIN_UNSUCCESS_MESSGAGE);
	}
	
	@Step("Click to 'Logout' link")
	public void clickToLogoutLink() {
		waitForElemetClickable(driver, LoginPageUI.LOGOUT_LINK);
		clickToElement(driver, LoginPageUI.LOGOUT_LINK);
		
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
		
	}


}