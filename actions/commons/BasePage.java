package commons;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.common.Common_Register;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneraterManager;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class BasePage {
	
	protected static BasePage getBasePage() {
		return new BasePage();
	}

 	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl); 
	}
	
	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
	//Tối ưu ở Level_07_Switch_Page
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		return PageGeneraterManager.getUserCustomerInfoPage(driver);
	}
	
	public UserCustomerAddressesPageObject openCustomerAddressesPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.ADĐRESES_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADĐRESES_LINK);
		return PageGeneraterManager.getUserAddressesPage(driver);
	}

	protected UserOrdersPageObject openOrdersPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.ORDERS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ORDERS_LINK);
		return PageGeneraterManager.getUserOrdersPageObject(driver);
	}
	
	protected UserDownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneraterManager.getUserDownloadableProductsPage(driver);
	}
	
	protected UserBackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		return PageGeneraterManager.getUserBackInStockSubscriptionsPage(driver);
	}
	
	protected UserRewardPointsPageObject openRewardPointsPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.REWARD_POINTS_LINK);
		return PageGeneraterManager.getUserRewardPointsPage(driver);
	}
	
	protected UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CHANGE_PASSWORD_LINK);
		return PageGeneraterManager.getUserChangePasswordPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneraterManager.getUserMyProductReviewPage(driver);
	}
	
	//Tối ưu bài Level_09_Dynamic_Locator
	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.PAGE_AT_MY_ACCOUNT_DYNAMIC_LINK, pageName);
		clickToElement(driver, BasePageNopCommerceUI.PAGE_AT_MY_ACCOUNT_DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneraterManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneraterManager.getUserAddressesPage(driver);
		case "Orders":
			return PageGeneraterManager.getUserOrdersPageObject(driver);
		case "Downloadable products":
			return PageGeneraterManager.getUserDownloadableProductsPage(driver);
		case "Back in stock subscriptions":
			return PageGeneraterManager.getUserBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneraterManager.getUserRewardPointsPage(driver);
		case "Change password":
			return PageGeneraterManager.getUserChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneraterManager.getUserMyProductReviewPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My account area!");
		}
	}
	
	//Pattern Object
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName){
		waitForElemetClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}
	
	/**
	 * Enter value to textbox by ID
	 * @author yentt
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElemetVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(driver, value, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);;
	}
	
	/**
	 * Click to dynamic button by text
	 * @author yentt
	 * @param driver
	 * @param buttonText
	 */

	public void clicktoButtonByText(WebDriver driver, String buttonText) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		
	}

	/**
	 * Select item in dropdown by Name attribute 
	 * @author yentt
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemValue
	 */
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, itemValue, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		
	}
	

	/**
	 * Click to dynamic radio button by label name 
	 * @author yentt
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clickToRadioButtonBylabel(WebDriver driver, String radioButtonLabelName) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		checkToCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		
	}
	
	/**
	 * Check to dynamic checkbox by label name
	 * @author yentt
	 * @param driver
	 * @param checkboxLabelName
	 */
	public void checkToCheckboxByLabelName(WebDriver driver, String checkboxLabelName) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
		checkToCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
	}
	
	/**
	 * Get value in textbox by textboxID
	 * @author yentt
	 * @param driver
	 * @param textboxID
	 * @return 
	 */
	public String getTextboxAttributeValueByID(WebDriver driver, String textboxID) {
		waitForElemetVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getAttributeValue(driver, "value", BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
	}
	
	public pageObjects.wordpress.AdminDashboardPageObject openAdminSite(WebDriver driver, String adminPageUrl) {
		openPageUrl(driver, adminPageUrl);
		return pageObjects.wordpress.PageGeneraterManager.getAdminDashboardPage(driver);
	}
	
	public pageObjects.wordpress.UserHomePageObject openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUrl(driver, endUserUrl);
		return pageObjects.wordpress.PageGeneraterManager.getUserHomePage(driver);
	}
	
	//Tối ưu ở Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);
		return PageGeneraterManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElemetClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneraterManager.getAdminLoginPage(driver);
	}
	
	private Alert waitForAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresent(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresent(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresent(driver).getText();
	}

	public void senkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresent(driver).sendKeys(textValue);
	}
		
	public void switchToWindowByID(WebDriver driver, String parentPageWindowID) {
		Set <String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentPageWindowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchToWindowbyTitle(WebDriver driver, String windowTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(windowTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentPageWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentPageWindowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentPageWindowID);
		}
	}
	
	private By getByLocator(String locatorType) {
		By by = null;
		//System.out.println("Locator type: " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else
			throw new RuntimeException("Locator type is not supported!");
		return by;
	}
	
	private WebElement getWebElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return driver.findElement(getByLocator(castRestParameter(dynamicLocator, dynamicValues)));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return driver.findElements(getByLocator(castRestParameter(dynamicLocator, dynamicValues)));
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	public String castRestParameter(String dynamicLocator, String... dynamicValues) {
		dynamicLocator = String.format(dynamicLocator,(Object[])dynamicValues);
		return dynamicLocator;
	}

	public void clickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String inputValue, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		element.clear();
		element.sendKeys(inputValue);
	}
	
	public void clearValueInElementByPressKey(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	}
	
	public String getTextElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String textItem, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String expectedTextItem, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).click();
		sleepInSecond(1);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String attributeName, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getAttribute(attributeName);
	}

	public String getCSSValue(WebDriver driver, String propertyName, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getListWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).size();
	}

	public void checkToCheckboxOrRadio (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckboxOrRadioByJS (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (!element.isSelected()) {
			clickToElementByJS(driver, dynamicLocator, dynamicValues);
		}
	}

	public void uncheckToCheckboxOrRadio (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckboxOrRadioByJS (WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		if (element.isSelected()) {
			clickToElementByJS(driver, dynamicLocator, dynamicValues);
		}
	}


	public boolean isElementDisplayed(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		try {
			return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementUndisplayed (WebDriver driver, String dynamicLocator, String...dynamicValues) {
		System.out.println("Start time = " + new Date().toString());
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, dynamicLocator, dynamicValues);
		overrideImplicitTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible/ displayed");
			return true;
		}
	}
	
	public void overrideImplicitTimeout (WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementSelected(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		return getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues )).isEnabled();
	}

	public void switchToFrameIframe(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		driver.switchTo().frame(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues )));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))).perform();	
	}
	
	public void pressKeyToElement(WebDriver driver, String dynamicLocator, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)),key).perform();	 
	}
	
	public void doubleClickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues ))).perform();
		
	}
	
	public void rightClickToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))).perform();
		
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}
	
	public String getElementValueByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\""+ xpathLocator+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public void removeAttributeInDOM(WebDriver driver, String attributeRemove, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
	}

	public boolean isImageLoaded(WebDriver driver, String dynamicLocator, String dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, castRestParameter(dynamicLocator, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElemetVisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	public void waitForAllElemetsVisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	public void waitForElemetInvisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}

	/*
	 * Wait for element undisplayed in DOM ỏ not in DOM and override implicit timeout
	 */
	public void waitforElementUndisplayed(WebDriver driver, String dynamicLocator, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
		overrideImplicitTimeout(driver, longTimeout);
		}
	public void waitForAllElemetsInvisible(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, castRestParameter(dynamicLocator, dynamicValues))));
	}

	public void waitForElemetClickable(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(dynamicLocator, dynamicValues))));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		//Duong dan cua thu muc upload file
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
		
		//Duong dan cua tat ca cac file
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName =  fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, pageUIs.jQuery.dataTable.BasePageUI.UPLOAD_FILE).sendKeys(fullFileName); 
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
		Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;


}
