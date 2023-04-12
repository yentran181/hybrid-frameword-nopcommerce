package pageUIs.jQuery.uploadFile;

import java.io.File;

import org.apache.commons.exec.OS;

public class BasePageUI {
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_TYPE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String DB_DEV_URL = "";
	public static final String DB_DEV_USER = "";
	public static final String DB_DEV_PASS = "";
	public static final long SHORT_TIMEOUT = 5;

	
}
