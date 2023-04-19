package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to 'Register' button")
	public void clickToRegisterButton() {
		waitForElemetClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Navigate to 'Login' page")
	public UserLoginPageObject clickToLoginLink() {
		waitForElemetClickable(driver, RegisterPageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver); 
		return PageGeneraterManager.getUserLoginPage(driver);
	}

	@Step("Verify error message at 'Firstname' textbox is displayed")
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSGAGE);
	}

	@Step("Verify error message at 'Lasttname' textbox is displayed")
	public String getErrorMessageAtLasttnameTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSGAGE);
	}

	@Step("Verify error message at 'Email' textbox is displayed")
	public String getErrorMessageAtEmailTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSGAGE);
	}

	@Step("Verify error message at 'Password' textbox is displayed")
	public String getErrorMessageAtPasswordTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSGAGE);
	}

	@Step("Verify error message at 'ConfirmPassword' textbox is displayed")
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElemetVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSGAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSGAGE);
	}
	
	@Step("Enter to '{1}' textbox with value is {0}")
	public void inputToRegisterForm(String value, String fieldName) {
		waitForElemetVisible(driver,RegisterPageUI.REGISTER_FORM_DYNAMIC_LOCATOR, fieldName);
		sendKeyToElement(driver, value, RegisterPageUI.REGISTER_FORM_DYNAMIC_LOCATOR, fieldName);
	}
	
	@Step("Enter to 'Firstname' textbox with value is {0}")
	public void inputToFirstnameTextbox(String firstname) {
		waitForElemetVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver,firstname, RegisterPageUI.FIRST_NAME_TEXTBOX);
		
	}
	
	@Step("Enter to 'Lastname' textbox with value is {0}")
	public void inputToLastnameTextbox(String lastname) {
		waitForElemetVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, lastname, RegisterPageUI.LAST_NAME_TEXTBOX);

	}
	
	@Step("Enter to 'Email' textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElemetVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, emailAddress, RegisterPageUI.EMAIL_TEXTBOX);
		
	}

	@Step("Enter to 'Password' textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElemetVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, password, RegisterPageUI.PASSWORD_TEXTBOX);
		
	}

	@Step("Enter to 'ConfirmPassword' textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElemetVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, confirmPassword, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		
	}
	
	@Step("Verify register success message is displayed")
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