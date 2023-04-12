package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends BasePage {
	// Có thể dùng access modifier cho driver là protected, thì class kế thừa có thể
	// dùng luôn driver của baseTest mà k cần khởi tạo driver mới, nhưng như thể
	// code sẽ không rõ ràng, vì thực tế 2 driver của 2 class không liên quan đến
	// nhau.
	private WebDriver baseTestDriver;

	protected WebDriver getBrowserDriver(String browserName, String pageURL) {
		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			baseTestDriver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			baseTestDriver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			baseTestDriver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			baseTestDriver = new FirefoxDriver(options);
		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			baseTestDriver = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.iedriver().setup();
			baseTestDriver = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.operadriver().setup();
			baseTestDriver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// coccoc chay chromedriver, cần trừ đi 5-6 version chrome mới nhất để ra
			// versison driver cho coccoc
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.chromedriver().driverVersion("97.0.4577.6").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("");
			baseTestDriver = new ChromeDriver(options);
		} else if (browserName.equals("coccoc")) {
			// brave version nào dùng chrome version đó
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("");
			baseTestDriver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name is invalid ");
		}

		baseTestDriver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		baseTestDriver.manage().window().maximize();
		baseTestDriver.get(pageURL);
		return baseTestDriver;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
				System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected String getRandomEmail() {

		Random random = new Random();
		return "yentran" + random.nextInt(99999) + "@gmail.com";
	}
}
