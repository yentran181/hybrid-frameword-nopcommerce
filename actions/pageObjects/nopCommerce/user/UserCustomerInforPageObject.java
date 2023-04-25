package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.CustomerInforUI;

public class UserCustomerInforPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		return isElementDisplayed(driver, CustomerInforUI.CUSTOMER_INFOR_HEADER1);
	}

	public UserCustomerAddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.ADĐRESES_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADĐRESES_LINK);
		return PageGeneraterManager.getUserAddressesPage(driver);
	}

}
