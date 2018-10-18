package com.qa.AutomatedTesting2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DemoSiteReadAndWriteExcel {
	WebDriver driver = null;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeClass
	public static void start() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Joe's Reporting\\exceltest.html",true);
	}
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@After
	public void teardown() {
		driver.quit();
	}
	@AfterClass
	public static void end() {
		report.flush();
	}
	@Test
	public void exceltest() throws InterruptedException {
		ExcelUtils.setExcelFile();
		System.out.println(ExcelUtils.getExcelWSheet().toString());
		for (int i = 1; i <= (ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows() - 1);i++) {
			test = report.startTest("Excel Data Test: " +i);
			test.log(LogStatus.INFO, "Starting Test "+i);
			
			driver.get("http://thedemosite.co.uk/addauser.php");
			test.log(LogStatus.INFO, "Opening Create account webpage");
			test.log(LogStatus.INFO, "Opening file stream using Excel Utils class");
			UserPage user = PageFactory.initElements(driver, UserPage.class);
			user.settings(ExcelUtils.getCellData(i,0), ExcelUtils.getCellData(i,1));
			test.log(LogStatus.INFO, "New username and password assigned");
			
			driver.get("http://thedemosite.co.uk/login.php");
			test.log(LogStatus.INFO, "Opening login webpage");
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.checkdetails(ExcelUtils.getCellData(i,0), ExcelUtils.getCellData(i,1));
			test.log(LogStatus.INFO, "Attempt to Log in");
			
			if(login.getVerification().equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "Login Attempt was successful");
				ExcelUtils.setCellData("PASS", i, 3);
			}
			else if(ExcelUtils.getCellData(i,0).length() < 8 || ExcelUtils.getCellData(i,0).length() > 16 || ExcelUtils.getCellData(i,1).length() < 4 || ExcelUtils.getCellData(i,1).length() > 8){
				test.log(LogStatus.FAIL, "Login Attempt was not successful because there is an error in the data");
				ExcelUtils.setCellData("FAIL", i, 3);
			}
			else {
				test.log(LogStatus.FAIL, "Login Attempt was not successful");
				ExcelUtils.setCellData("FAIL", i, 3);
			}
			report.endTest(test);
			assertEquals("**Successful Login**", login.getVerification());

			
			
	}
		
	}
}
