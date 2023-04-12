package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.CustomerInforUI;

public class UserCustomerInforPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed(String fieldName) {
		return isElementDisplayed(driver, castRestParameter(CustomerInforUI.CUSTOMER_INFOR_HEADER, fieldName));
	}

	public UserCustomerAddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageUI.ADĐRESES_LINK);
		clickToElement(driver, BasePageUI.ADĐRESES_LINK);
		return PageGeneraterManager.getUserAddressesPage(driver);
	}

}
