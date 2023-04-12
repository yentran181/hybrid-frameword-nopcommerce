package com.nopcommerce.user;


public class Level_09_Dynamic_Locator_01{
	public static void main(String[] args) {
		String REGISTER_LINK= "//a[@class='ico-register']";
		String LOGIN_LINK = "//a[@class='ico-login']";
		String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
		String DYNAMIC_LOCATOR_01 = "a[@class='%s']";
		String DYNAMIC_LOCATOR_02 = "a[@class='%s']a[@class='%s']//a[@class='%s']";
		String DYNAMIC_LOCATOR_03 = "a[@class='%s']//a[@class='%s']//a[@class='%s']//a[@class='%s']//a[@class='%s']//a[@class='%s']";
		
		//Không dùng dynamic locator
		clickToElement(REGISTER_LINK);
		clickToElement(MY_ACCOUNT_LINK);
		clickToElement(LOGIN_LINK);
		
		//Dynamic locator có 1 tham số truyền vào
		clickToElement(DYNAMIC_LOCATOR_01,"ico-register");
		clickToElement(DYNAMIC_LOCATOR_01,"ico-login");
		clickToElement(DYNAMIC_LOCATOR_01,"ico-account");
		
		//Dynamic locator có 2 tham số truyền vào
		clickToElement(DYNAMIC_LOCATOR_02, "ico-register","value2");
		clickToElement(DYNAMIC_LOCATOR_02, "ico-login","value2");
		clickToElement(DYNAMIC_LOCATOR_02, "ico-account","value2");

		//Dynamic locator có n tham số truyền vào
		clickToElement(DYNAMIC_LOCATOR_03,"value1","value2","value3","value4","value5","value6");
	}
	public static void clickToElement(String buttonName) {
		System.out.println(buttonName);
	}
	
	public static void clickToElement(String dynamicLocator, String dynamicValue) {
		System.out.println(String.format(dynamicLocator, dynamicValue));
	}
	
	public static void clickToElement(String dynamicLocator, String dynamicValue_01, String dynamicValue_02) {
		System.out.println(String.format(dynamicLocator, dynamicValue_01, dynamicValue_02));
	}
	
	public static void clickToElement(String dynamicLocator, String...dynamicValue) {
		System.out.println(String.format(dynamicLocator,(Object[])dynamicValue));
	}
	
}
