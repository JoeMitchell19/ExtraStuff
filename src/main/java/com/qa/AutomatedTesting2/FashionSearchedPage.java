package com.qa.AutomatedTesting2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FashionSearchedPage {
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement clothingtype;
	
	public WebElement getSearch() {
		return clothingtype;
	}

}
