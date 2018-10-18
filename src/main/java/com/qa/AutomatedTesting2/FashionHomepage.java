package com.qa.AutomatedTesting2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FashionHomepage {
	@FindBy(xpath= "//*[@id=\"search_query_top\"]")
	private WebElement searchbar;
	
	public void entersearch(String searchterm) {
		searchbar.sendKeys(searchterm);
		searchbar.submit();
	}
}
// Why does this web element need to be private?
// 