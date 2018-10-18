package com.qa.AutomatedTesting2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginUser {
	WebDriver driver = null;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@After
	public void teardown() {
		driver.quit();
	}
	@Test
	public void test2() throws InterruptedException {
		driver.get("http://thedemosite.co.uk/login.php");
		Thread.sleep(10000);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.checkdetails("","");
		Thread.sleep(5000);
		assertEquals("**Successful Login**", login.getVerification());
	

}
}
//Note that a large portion of the afternoon was lost due to technical issues. As a result, I didn't make as much progress as I wanted today.
//I am more than happy to stay behind for extra help on Thursday if it is available.