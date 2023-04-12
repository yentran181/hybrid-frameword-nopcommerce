package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElemetClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElemetClickable(driver, RegisterPageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver); 
		return PageGeneraterManager.getUserLoginPage(driver);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSGAGE);
	}

	public String getErrorMessageAtLasttnameTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSGAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSGAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSGAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSGAGE);
	}
	
	public void inputToRegisterForm(String value, String fieldName) {
		waitForElemetVisible(driver,RegisterPageUI.REGISTER_FORM_DYNAMIC_LOCATOR, fieldName);
		sendKeyToElement(driver, value, RegisterPageUI.REGISTER_FORM_DYNAMIC_LOCATOR, fieldName);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElemetVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver,firstname, RegisterPageUI.FIRST_NAME_TEXTBOX);
		
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElemetVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, lastname, RegisterPageUI.LAST_NAME_TEXTBOX);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElemetVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, emailAddress, RegisterPageUI.EMAIL_TEXTBOX);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElemetVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, password, RegisterPageUI.PASSWORD_TEXTBOX);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElemetVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, confirmPassword, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElemetVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSGAGE);
	}

	public String getErrorExistingEmailMessage() {
		waitForElemetVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSGAGE);
	}

	public void clickToLogoutButton() {
		waitForElemetClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}
	
}