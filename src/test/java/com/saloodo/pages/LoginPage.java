package com.saloodo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
    @FindBy(name = "_email")
    private WebElement emailInput;
    
    
    @FindBy(name = "_password")
    private WebElement passwordInput;
    
    
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;
    
    
    public LoginPage inputCredentials(String email, String password) {
    	sendValue(emailInput, email);
    	sendValue(passwordInput, password);
    	return this;
    }
    
    
    public void clickOnLoginButton() {
    	clickOn(submitBtn);
    }
}
