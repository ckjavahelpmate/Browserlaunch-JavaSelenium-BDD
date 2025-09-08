Feature: Amazon App

@regression @smoke
Scenario: Verify page title
	Given  	Navigate to "https:/www.amazon.com"
	And 	Wait for 1 seconds
	Then 	Verify page title to be "Amazon.com."
	
