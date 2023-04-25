package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Navigate to 'Register' page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElemetClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK );
		return PageGeneraterManager.getUserRegisterPage(driver);
	} 
	
	@Step("Navigate to 'Login' page")
	public UserLoginPageObject openLoginPage() {
		waitForElemetClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver); 
		return PageGeneraterManager.getUserLoginPage(driver);
	}
	
	@Step("Verify 'My Account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElemetVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to 'My Account' page")
	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElemetClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getUserCustomerInfoPage(driver);
	}

}