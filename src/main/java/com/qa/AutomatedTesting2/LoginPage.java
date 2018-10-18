package com.qa.AutomatedTesting2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	WebElement enterUsername;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	WebElement enterPassword;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement verification;
	
	
	public void checkdetails(String a, String b) {
		enterUsername.sendKeys(a);
		enterPassword.sendKeys(b);
		enterPassword.submit();
	}


	public String getVerification() {
		return verification.getText();
	}
	


}
