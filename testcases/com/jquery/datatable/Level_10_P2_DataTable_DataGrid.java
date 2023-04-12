package com.jquery.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.jQuery.datatable.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;
import pageUIs.jQuery.dataTable.HomePageUI;

public class Level_10_P2_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String pageNumber;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.JQUERY2_PAGE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void Table_01_EnterToTextboxAtAnyRow() {
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "2", "EFY Viet Nam");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "2", "Tran Thi Yen");
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "2", "999");
		homePage.enterToTextboxAtRowNumberByColumnName("Member Since", "2", "15/03/2023");
	}

}
