Feature: Facebook App

@regression
Scenario: Verify page title
	Given  	Navigate to "https:/www.Facebook.com"
	And 	Wait for 1 seconds
	Then 	Verify page title to be "Facebook – log in or sign up"

