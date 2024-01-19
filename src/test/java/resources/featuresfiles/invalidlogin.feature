Feature: Validate invalid username and password

	Background:
		Given Navigate to ksrts website

  
  Scenario: Varification for invalid credentials
    When I click on sign in button
    And I enter a invalid username & password from datasheet
    And I check term & conditions check box
    When I click on the login button
    Then I can see login incorrect message should be displayed