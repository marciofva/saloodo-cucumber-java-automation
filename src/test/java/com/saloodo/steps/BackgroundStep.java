package com.saloodo.steps;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.saloodo.common.Titles;
import com.saloodo.factory.Hooks;
import com.saloodo.fixtures.DataLogin;
import com.saloodo.pages.HomePage;
import com.saloodo.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BackgroundStep {
	
	private WebDriver driver;
	private HomePage home;
	private RegistrationPage registration;
	
	
	public BackgroundStep() {
		this.driver = Hooks.driver;
		home = new HomePage(driver);
		registration = new RegistrationPage(driver);
	}
	
	
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		home.loginAccount();
	}
	
	
	@Given("I submit username and password for shipper")
	public void i_submit_username_and_password_for_shipper() {
		Map<String, String> map = DataLogin.loginAsAShipper();
		home.loginAccount().inputCredentials(map.get("username"), map.get("password")).clickOnLoginButton();
	}
	
	
	@Then("Login page should be displayed")
	public void login_page_should_be_displayed() {
		Assert.assertEquals(true, registration.waitForTitle(Titles.LOGIN.getValue()));
	}
}
