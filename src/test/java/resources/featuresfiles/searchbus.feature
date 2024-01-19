Feature: Search bus Page
	
	Background:
		Given Navigate to ksrts website
		
	
	Scenario Outline: Varify that user is able to search bus
    When I enter "<leavecity>" in leaving from search bar 
    And I select "<leave_city>" from dropdown opend leave city
    Then I enter "<goingcity_input>" in going to search bar
    And I select "<going_city>" from dropdown opend for going city
    Then I click on date of departure 
    And I select a specific date of departure
    Then I click on date of return 
    And I select a specific date of return
    When I click on search for bus
    
    Examples:
    | leavecity | leave_city | goingcity_input | going_city |
    | Ben | BENGALURU | Bel | BELGAUM |