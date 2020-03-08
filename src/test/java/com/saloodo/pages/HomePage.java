package com.saloodo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public static final String SHIPPER = "shipper";

	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
    @FindBy(css = "button[type='button']")
    private WebElement register_menu;
    
    
    @FindBy(css = "a[href='/shipper']")
    private WebElement linkShipper;
    
    
    @FindBy(css = "a[href='/carrier']")
    private WebElement linkCarrier;
    
    
    @FindBy(css = "a[href='/login']")
    private WebElement linkLogin;
    
    
    public void goToRegistrationPage(String type) {
    	clickOn(register_menu);
    	
    	if(type.equalsIgnoreCase(SHIPPER)) {
    		clickOn(linkShipper);
    	}else{
    		clickOn(linkCarrier);
    	}
    }
    
    
    public LoginPage loginAccount() {
    	clickOn(linkLogin);
    	return new LoginPage(driver);
    }
}
