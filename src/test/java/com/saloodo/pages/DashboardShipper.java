package com.saloodo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardShipper extends BasePage{


	public DashboardShipper(WebDriver driver) {
		super(driver);
	}
	
	
    @FindBy(linkText = "Skip it")
    private WebElement skipLink;
    
    
    @FindBy(css = "button[class='btn btn--small btn--black']")
    private WebElement detailsCompanyBtn;
    
    
    @FindBy(name = "displayName")
    private WebElement companyName;
    
    
    @FindBy(name = "street")
    private WebElement streetInput;
    
    
    @FindBy(name = "streetNo")
    private WebElement streetNoInput;
    
    
    @FindBy(name = "streetNoAddition")
    private WebElement streetNoAdditionInput;
    
    
    @FindBy(name = "postalCode")
    private WebElement postalCodeInput;
    
    
    @FindBy(name = "city")
    private WebElement cityInput;
    
    
    @FindBy(css = ".Select-value-label")
    private WebElement countryDropdown;
    
    
    @FindBy(name = "vatId")
    private WebElement vatIdInput;


    public void goToDetailsCompany() {
    	clickOn(skipLink);
    	clickOn(detailsCompanyBtn);
    }
    

    public void enterAdditionalShipperDetails(String street, String streetNo, String streetNoAddition, String postalCode, String city) throws InterruptedException {
    	waitForElementVisibility(companyName);
    	sendValue(streetInput, street);
    	sendValue(streetNoInput, streetNo);
    	sendValue(streetNoAdditionInput, streetNoAddition);
    	sendValue(postalCodeInput, postalCode);
    	sendValue(cityInput, city);
    }


	public String getCompanyName() {
		return companyName.getAttribute("value");
	}


	public String getStreet() {
		return streetInput.getAttribute("value");
	}


	public String getStreetNo() {
		return streetNoInput.getAttribute("value");
	}


	public String getAddressExtension() {
		return streetNoAdditionInput.getAttribute("value");
	}


	public String getPostalCode() {
		return postalCodeInput.getAttribute("value");
	}


	public String getCity() {
		return cityInput.getAttribute("value");
	}
	
	
	public String getCountry() {
		return getText(countryDropdown);
	}


	public String getVatId() {
		return vatIdInput.getAttribute("value");
	}
}
