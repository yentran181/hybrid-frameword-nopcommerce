package com.jquery.uploaFile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String pageNumber;
	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String pythonFileName = "Python.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFileNames = {csharpFileName, javaFileName, pythonFileName, rubyFileName};

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.JQUERY_FILE_UPLOAD_URL);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Upload_01_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, csharpFileName);
		Assert.assertTrue(homePage.isFileLoadByName(csharpFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
	}
	
	@Test
	public void Upload_Multi_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		
		Assert.assertTrue(homePage.isFileLoadByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadByName(rubyFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
