package com.saloodo.steps;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.saloodo.common.Titles;
import com.saloodo.factory.Hooks;
import com.saloodo.fixtures.DataRegistration;
import com.saloodo.pages.DashboardCarrier;
import com.saloodo.pages.HomePage;
import com.saloodo.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStep {
	
	private WebDriver driver;
	private HomePage home;
	private RegistrationPage registration;
	private DashboardCarrier dashboardCarrier;
	
	
	public RegistrationStep() {
		this.driver = Hooks.driver;
		home = new HomePage(driver);
		registration = new RegistrationPage(driver);
		dashboardCarrier = new DashboardCarrier(driver);
	}
	
	
	@Given("I navigate to registration page as a {string}")
	public void i_navigate_to_registration_page_as_a(String type) {
		home.goToRegistrationPage(type);
	}
	
	
	@When("I submit the shipper form with valid data")
	public void i_submit_the_shipper_form_with_valid_data() throws InterruptedException {
		Map<String, String> map = DataRegistration.addShipper();
		
		registration.signUpShipper(map.get("companyName"), 
							  	   map.get("email"), 
							  	   map.get("firstName"), 
							  	   map.get("lastName"), 
							  	   map.get("phone"),
							  	   map.get("vatId"),
							  	   map.get("contactByEmail"),
							  	   map.get("TermsAndConditions"))
					.clickOnSubmit();
	}
	
	
	@When("I submit the carrier form with valid data")
	public void i_submit_the_carrier_form_with_valid_data() throws InterruptedException {
		Map<String, String> map = DataRegistration.addCarrier();
		
		registration.signUpCarrier(map.get("companyName"), 
							  	   map.get("firstName"), 
							  	   map.get("lastName"), 
							  	   map.get("email"),
							  	   map.get("phone"),
							  	   map.get("password"),
							  	   map.get("contactByEmail"),
							  	   map.get("TermsAndConditions"))
					.clickOnSubmit();
	}

	
	@Then("Should display {string}")
	public void should_display(String message) {
		Assert.assertEquals(true, registration.waitForTitle(Titles.SHIPPER_REGISTRATION.getValue()));
		Assert.assertEquals(message, registration.getSuccessMessageForShipper());
	}
	
	
	@Then("A popup box should display with the message {string}")
	public void a_popup_box_should_display_with_the_message(String message) {
		Assert.assertEquals(message, dashboardCarrier.getSuccessMessageForCarrier());
	}
}
