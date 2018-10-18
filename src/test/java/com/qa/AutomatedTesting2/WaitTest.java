package com.qa.AutomatedTesting2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WaitTest {
	WebDriver driver = null;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass
	public static void start() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Joe's Reporting\\waittest.html",true);
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
	public void testofWait() throws InterruptedException {
		test = report.startTest("Checking the Wait");
		driver.get("https://chrisperrins95.github.io/AutomatedTestingExample/");
		test.log(LogStatus.INFO, "QA site Opened");
		QApage q = PageFactory.initElements(driver, QApage.class);
		q.text();
		WebElement find = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("shafeeq")));
		Thread.sleep(3000);
		if(find.getText().equals("I HATE YOU!\n" + "-The Shafeeq")) {
			test.log(LogStatus.INFO, "Test passed");
		}
		else {
			test.log(LogStatus.INFO, "Test failed");
		}
		report.endTest(test);
		assertEquals("I HATE YOU!\n" + "-The Shafeeq", find.getText());
		
	}

}
