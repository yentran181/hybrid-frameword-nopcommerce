package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class UserMyProductReviewPageObject extends BasePage {

	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		return null;
	}

}
