Feature: Google App

@regression @smoke
Scenario: Verify page title
	Given  	Navigate to "https:/www.Google.com"
	And 	Wait for 1 seconds
	Then 	Verify page title to be "Google"

