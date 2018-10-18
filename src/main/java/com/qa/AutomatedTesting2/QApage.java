package com.qa.AutomatedTesting2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QApage {
	@FindBy(xpath = "//*[@id=\"shafeeq\"]/h1/text()")
	private WebElement shafeeq;
	
	public WebElement text() {
		return shafeeq;
	}

}
