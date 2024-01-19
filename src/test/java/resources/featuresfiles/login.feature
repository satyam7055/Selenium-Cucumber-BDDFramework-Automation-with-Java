Feature: Validate username and password

	Background:
		Given Navigate to ksrts website

  
  Scenario: Varification for valid credentials
    When I click on sign in button
    And I enter a username & password from datasheet
    And I check term & conditions check box
    When I click on the login button
    Then I can see user name available on header
    
