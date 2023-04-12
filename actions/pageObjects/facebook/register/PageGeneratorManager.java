package pageObjects.facebook.register;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
		public static LoginPageObject getLoginPage(WebDriver driver) {
			return new LoginPageObject(driver);
		}
		
		public static RegisterPageObject getRegisterPage(WebDriver driver) {
			return new RegisterPageObject(driver);
		}
}
