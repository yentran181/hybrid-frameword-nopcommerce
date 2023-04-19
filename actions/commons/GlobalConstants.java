package commons;

import java.io.File;

public class GlobalConstants {
	public static final String NOPCOMMERCE_USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String NOPCOMMERCE_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String JQUERY_PAGE_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String JQUERY2_PAGE_URL = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
	public static final String JQUERY_FILE_UPLOAD_URL = "https://blueimp.github.io/jQuery-File-Upload/";
	
	public static final String FACEBOOK_PAGE_URL = "https://www.facebook.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	
	//Upload file folder
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	
	//Database Account/User/Pass/Port
	public static final String DB_DEV_URL = "192.168.1.1:9800";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "1234abcd@";
	
	public static final String DB_TEST_URL = "192.168.1.1:9800";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "1234abcd@";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
	public static final String JAVA_VERSION = System.getProperty("java.vesion");


}
