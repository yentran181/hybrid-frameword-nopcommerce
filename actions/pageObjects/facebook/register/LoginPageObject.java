package pageObjects.facebook.register;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.register.LoginPageUI;

public class LoginPageObject extends BasePage{

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElemetClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}
	
	public boolean isEmailAddressTextboxDisplayed() {
		waitForElemetVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}
	
	public void enterToEmailAddressTextbox(String emailAddress){
		waitForElemetVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, emailAddress, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}
	
	public boolean isConfirmEmailAddressTexboxDisplayed() {
		//waitForElemetVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
