package com.saloodo.steps;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.saloodo.factory.Hooks;
import com.saloodo.fixtures.DataShipperDetails;
import com.saloodo.pages.DashboardShipper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardShipperStep {
	
	private WebDriver driver;
	private DashboardShipper dashboard;
	
	
	public DashboardShipperStep() {
		this.driver = Hooks.driver;
		dashboard = new DashboardShipper(driver);
	}
	

	@Given("I navigate to company details page")
	public void i_navigate_to_company_details_page() {
		dashboard.goToDetailsCompany();
	}
	

	@When("I fill up additional details")
	public void i_fill_up_additional_details() throws InterruptedException {
		Map<String, String> map = DataShipperDetails.updateWithValidData();
		dashboard.enterAdditionalShipperDetails(map.get("street"), 
												map.get("streetNo"), 
												map.get("addressExtension"), 
												map.get("postcode"), 
												map.get("city"));
	}

	
	@Then("The company update profile shoud be filled up")
	public void the_company_update_profile_shoud_be_filled_up() {
		Map<String, String> map = DataShipperDetails.updateWithValidData();
		Assert.assertEquals(map.get("companyName"), dashboard.getCompanyName());
		Assert.assertEquals(map.get("street"), dashboard.getStreet());
		Assert.assertEquals(map.get("streetNo"), dashboard.getStreetNo());
		Assert.assertEquals(map.get("addressExtension"), dashboard.getAddressExtension());
		Assert.assertEquals(map.get("postcode"), dashboard.getPostalCode());
		Assert.assertEquals(map.get("city"), dashboard.getCity());
		Assert.assertEquals(map.get("country"), dashboard.getCountry());
		Assert.assertEquals(map.get("vatId"), dashboard.getVatId());
	}
}
