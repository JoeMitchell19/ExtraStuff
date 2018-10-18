package com.qa.AutomatedTesting2;
import static org.junit.Assert.assertEquals;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateUser {
	WebDriver driver = null;
	public static ExtentReports report;
	public static ExtentTest reporttest;
	
	@BeforeClass
	public static void begin() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Joe's Reporting\\createusertest.html",true);
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
	public static void finish() {
		report.flush();
	}
	
	@Test
	public void test1() throws InterruptedException {
		reporttest = report.startTest("Creating a new User");
		driver.get("http://thedemosite.co.uk/addauser.php");
		Thread.sleep(5000);
		reporttest.log(LogStatus.INFO, "New user page opened");
		UserPage user = PageFactory.initElements(driver, UserPage.class);
		user.settings("jm1","workplz");
		reporttest.log(LogStatus.INFO, "New username and password assigned");
		Thread.sleep(1000);
		driver.get("http://thedemosite.co.uk/login.php");
		Thread.sleep(2000);
		reporttest.log(LogStatus.INFO, "New login page opened");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.checkdetails("jm1","workplz");
		Thread.sleep(5000);
		reporttest.log(LogStatus.INFO, "New login attempted");
		if(login.getVerification().equals("**Successful Login**")) {
			reporttest.log(LogStatus.PASS, "Login Attempt was successful");
		}
		else {
			reporttest.log(LogStatus.FAIL, "Login Attempt was not successful");
		}
		report.endTest(reporttest);
		assertEquals("**Successful Login**", login.getVerification());
		
	}

}
// Note that a large portion of the afternoon was lost due to technical issues. As a result, I didn't make as much progress as I wanted today.
//I am more than happy to stay behind for extra help on Thursday if it is available.
