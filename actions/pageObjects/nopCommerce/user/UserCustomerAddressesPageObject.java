package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class UserCustomerAddressesPageObject extends BasePage{
	private WebDriver driver;

	public UserCustomerAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneraterManager.getUserMyProductReviewPage(driver);
	}
}
