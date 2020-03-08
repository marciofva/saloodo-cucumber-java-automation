package com.saloodo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardCarrier extends BasePage {


	public DashboardCarrier(WebDriver driver) {
		super(driver);
	}
	
	
    @FindBy(css = ".sc-gFXMyG > .sc-bxivhb")
    private WebElement popupMessage;
    
  
    public String getSuccessMessageForCarrier() {
    	return getText(popupMessage);
    }
}
