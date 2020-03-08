@smoke
Feature: Registration flow

	Scenario: Register a new shipper
 		Given I navigate to registration page as a "shipper"
 		When I submit the shipper form with valid data
		Then Should display "Thank you for creating your account with Saloodo!"
	
	Scenario: Register a new carrier
		Given I navigate to registration page as a "carrier"
 		When I submit the carrier form with valid data
		Then Carrier should be logged in
		And A popup box should display with the message "Welcome to Saloodo!" 