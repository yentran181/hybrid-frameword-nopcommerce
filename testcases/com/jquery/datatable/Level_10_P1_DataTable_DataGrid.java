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

public class Level_10_P1_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String pageNumber;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.JQUERY_PAGE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
	}
	

	public void Table_01_PaginationByPageNumber() {
		homePage.paginationByPageNumber("12");
		Assert.assertTrue(homePage.isPageSelected("12"));
		
		homePage.paginationByPageNumber("10");
		Assert.assertTrue(homePage.isPageSelected("10"));
		
		homePage.paginationByPageNumber("20");
		Assert.assertTrue(homePage.isPageSelected("20"));
	}
	
	public void Table_02_Sendkey_To_Textbox() {
		homePage.enterToHeaderTextboxByLabel("Country", "Afghanistan");
	}

	public void Table_03_getValueEachRowAtAllPage() {
		homePage.getValueEachRowAtAllPage();
	}
	
	@Test
	public void Table_04_getValueEachRowOfColumnAtAllPage() {
		homePage.getValueOfColumnEachRowAtAllPage("females");
		homePage.getValueOfColumnEachRowAtAllPage("country");
		homePage.getValueOfColumnEachRowAtAllPage("males");
		homePage.getValueOfColumnEachRowAtAllPage("total");

	}

}
