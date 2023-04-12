package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String REGISTER_FORM_DYNAMIC_LOCATOR = "xpath=//input[@id='%s']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String FIRST_NAME_ERROR_MESSGAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSGAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSGAGE = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSGAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSGAGE = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_SUCCESS_MESSGAGE = "xpath=//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSGAGE = "xpath=//div[@class='message-error validation-summary-errors']//li";
}
