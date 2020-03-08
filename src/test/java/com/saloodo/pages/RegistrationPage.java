package com.saloodo.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public static final String YES = "yes";


	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
    

	@FindAll({
		@FindBy(name = "name"),
		@FindBy(name = "companyName")
	})
    private WebElement companyNameInput;
    
	
	@FindBy(name = "email")
    private WebElement emailInput;
    
	
	@FindBy(name = "firstName")
    private WebElement firstNameInput;
    
	
	@FindBy(name = "lastName")
    private WebElement lastNameInput;
    
	
	@FindAll({
		@FindBy(name = "phoneNumber"),
		@FindBy(name = "phone")
	})
    private WebElement phoneNumberInput;
    
    
    @FindBy(name = "vatId")
    private WebElement vatIdInput;
    
    
    @FindBy(id = "passwordInput")
    private WebElement passwordInput;
    
    
    @FindBy(css = ".filter-checkbox-container .filter-checkbox")
    private List<WebElement> agreementCheckBox ;
    
    
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;
    
    
    @FindBy(css = ".col-sm-12 > h2")
    private WebElement shipperRegistrationMessage;
    
    
    private void inputCompanyName(String companyName) {
    	sendValue(companyNameInput, companyName);
    }
    
    
    private void inputEmail(String email) {
    	sendValue(emailInput, email);
    }
    
    
    private void inputFirstName(String firstName) {
    	sendValue(firstNameInput, firstName);
    }
    
    
    private void inputLastName(String lastName) {
    	sendValue(lastNameInput, lastName);
    }
    
    
    private void inputPhone(String phone) {
    	sendValue(phoneNumberInput, phone);
    }
    
    
    private void inputVatId(String vatId) {
    	sendValue(vatIdInput, vatId);
    }
    
    
    private void inputPassword(String password) {
    	sendValue(passwordInput, password);
    }
    
    
    private void checkAgreements(String contactedByEmail, String termsAndConditions) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", submitBtn);
    	
    	if (contactedByEmail.equalsIgnoreCase(YES)) {
    		clickOn(agreementCheckBox.get(0));
    	}

    	if (termsAndConditions.equalsIgnoreCase(YES)) {
    		clickOn(agreementCheckBox.get(1));
		}
    }
    

    public RegistrationPage signUpShipper(String companyName, String email, String firstName, String lastName, String phone, String vatId, String contactedByEmail, String termsAndConditions) {
    	inputCompanyName(companyName);
    	inputEmail(email);
    	inputFirstName(firstName);
    	inputLastName(lastName);
    	inputPhone(phone);
    	inputVatId(vatId);
    	checkAgreements(contactedByEmail, termsAndConditions);
    	return new RegistrationPage(driver);
    }
    
 
    public RegistrationPage signUpCarrier(String companyName, String firstName, String lastName, String email, String phone, String password, String contactedByEmail, String termsAndConditions) {
    	inputCompanyName(companyName);
    	inputFirstName(firstName);
    	inputLastName(lastName);
    	inputEmail(email);
    	inputPhone(phone);
    	inputPassword(password);
    	checkAgreements(contactedByEmail, termsAndConditions);
    	return new RegistrationPage(driver);
    }
    
    
    public void clickOnSubmit() throws InterruptedException {
    	Thread.sleep(4000);
    	clickOn(submitBtn);
    }
    

    public String getSuccessMessageForShipper() {
    	return getText(shipperRegistrationMessage);
    }
}
