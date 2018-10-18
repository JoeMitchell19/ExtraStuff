package com.qa.AutomatedTesting2;

import static org.junit.Assert.*;

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

public class SearchTest {
	WebDriver driver = null;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass
	public static void start() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Joe's Reporting\\websearchtest.html",true);
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
	public void dresssearch() throws InterruptedException{
		test = report.startTest("Searching for a Dress");
		driver.get("http://automationpractice.com/index.php");
		test.log(LogStatus.INFO, "Shopping site Opened");
		Thread.sleep(3000);
		FashionHomepage home = PageFactory.initElements(driver, FashionHomepage.class);
		FashionSearchedPage result = PageFactory.initElements(driver, FashionSearchedPage.class);
		home.entersearch("Dress");
		test.log(LogStatus.INFO, "Search term entered");
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Search in Progress");
		if(result.getSearch().getText().equals("Printed Summer Dress")) {
			test.log(LogStatus.PASS, "Successful Search Performed");
		}
		else {
			test.log(LogStatus.FAIL, "Unsuccessful Search Performed");
		}
		report.endTest(test);
		assertEquals("Printed Summer Dress",result.getSearch().getText());
	
		
		
	}

}
