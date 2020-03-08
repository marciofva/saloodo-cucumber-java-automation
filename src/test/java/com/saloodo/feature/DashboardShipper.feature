@smoke
Feature: Shipper dashboard flow
  
  Background: User is Logged In
		Given I submit username and password for shipper
		Then Shipper should be logged in

  Scenario: Enter additional company details
    Given I navigate to company details page
    When I fill up additional details
    Then The company update profile shoud be filled up