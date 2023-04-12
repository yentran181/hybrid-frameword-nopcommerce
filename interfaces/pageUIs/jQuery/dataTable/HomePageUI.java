package pageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String SELECTED_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s' and @class='qgrd-pagination-page-link active']";
	public static final String ACTION_ICON = "xpath=//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,'%s')]";
	public static final String TOTAL_VALUE = "xpath=//td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='total']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[contains(@class,'header') and text() = '%s']//parent::div[contains(@class,'header')]//following-sibling::input[contains(@class,'header')]";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']//li[%s]";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody//tr";
	public static final String ALL_ROW_EACH_PAGE_BY_LABEL = "xpath=//tbody//tr//td[@data-key='%s']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[text()='%s']//preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]//input";

}
