Feature: Zomato App

@regression
Scenario: Verify page title
	Given  	Navigate to "https:/www.Zomato.com"
	And 	Wait for 1 seconds
	Then 	Verify page title to be "Zomato"

