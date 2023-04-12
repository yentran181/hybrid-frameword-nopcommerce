package pageObjects.jQuery.datatable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject (WebDriver driver) {
		this.driver = driver; 
	}

	public void paginationByPageNumber(String pageNumber) {
		waitForElemetClickable(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageSelected(String pageNumber) {
		waitForAllElemetsVisible(driver, HomePageUI.SELECTED_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.SELECTED_PAGE_NUMBER, pageNumber);
	}

	public void clickDeleteOrEditIconByCountryName(String countryName, String actionName) {
		waitForElemetClickable(driver, HomePageUI.ACTION_ICON, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON, countryName, actionName);
		sleepInSecond(3);
	}

	public String getTotalValueByCountryName(String countryName) {
		waitForElemetVisible(driver, HomePageUI.TOTAL_VALUE, countryName);
		return getTextElement(driver, HomePageUI.TOTAL_VALUE, countryName);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElemetVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendKeyToElement(driver, value, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total page = " + totalPage);
		List<String> allRowValuesAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(2);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		for (String value : allRowValuesAllPage) {
			System.out.println("--------------------------");
			System.out.println(value);
		}
		return allRowValuesAllPage;
	}
	
	public List<String> getValueOfColumnEachRowAtAllPage(String labelName) {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total page = " + totalPage);
		List<String> allValuesOfColumnAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			List<WebElement> allRowOfColumnElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE_BY_LABEL, labelName);
			for (WebElement eachRowOfColumn : allRowOfColumnElementEachPage) {
				allValuesOfColumnAllPage.add(eachRowOfColumn.getText());
			}
		}
		for (String value : allValuesOfColumnAllPage) {
			System.out.println("--------------------------");
			System.out.println(value);
		}
		return allValuesOfColumnAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElemetVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeyToElement(driver, value, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

}
