package com.qa.AutomatedTesting2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	WebElement setUsername;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	WebElement makePassword;
	
	public void settings(String a, String b) {
		setUsername.sendKeys(a);
		makePassword.sendKeys(b);
		makePassword.submit();
	}
	

}
