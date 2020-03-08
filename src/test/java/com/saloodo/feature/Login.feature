@smoke
Feature: Login flow

  Background: User is Logged In
		Given I navigate to the login page
		Then Login page should be displayed

  Scenario: Login as a shipper
  	When I input the credentials "marcio.fva@outlook.com" and "kfay779R?"
    And I click on login button
    Then Shipper should be logged in
 
 Scenario: Login as a carrier
 		When I input the credentials "michael@test.com" and "mqin118W%"
    And I click on login button
    Then Carrier should be logged in