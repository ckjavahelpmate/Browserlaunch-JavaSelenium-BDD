Feature: Swiggy App

@regression
Scenario: Verify page title
	Given  	Navigate to "https:/www.Swiggy.com"
	And 	Wait for 1 seconds
	Then 	Verify page title to be "Order Food & Groceries. Discover the best restaurants. Swiggy it!"

