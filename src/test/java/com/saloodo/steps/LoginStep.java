package com.saloodo.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.saloodo.common.Titles;
import com.saloodo.factory.Hooks;
import com.saloodo.pages.LoginPage;
import com.saloodo.pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	private WebDriver driver;
	private RegistrationPage registration;
	private LoginPage login;
	
	
	public LoginStep() {
		this.driver = Hooks.driver;
		registration = new RegistrationPage(driver);
		login = new LoginPage(driver);
	}
	
	
	@When("I input the credentials {string} and {string}")
	public void i_input_the_credentials_and(String email, String password) {
		login.inputCredentials(email, password);
	}

	
	@When("I click on login button")
	public void i_click_on_login_button() {
		login.clickOnLoginButton();
	}


	@Then("Shipper should be logged in")
	public void shipper_should_be_logged_in() {
		Assert.assertEquals(true, registration.waitForTitle(Titles.SHIPPER_DASHBOARD.getValue()));
	}


	@Then("Carrier should be logged in")
	public void carrier_should_be_logged_in() {
		Assert.assertEquals(true, registration.waitForTitle(Titles.CARRIER_DASHBOARD.getValue()));
	}
}
