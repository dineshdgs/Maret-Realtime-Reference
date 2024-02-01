Feature: Signup 
	As a user, I want to be able to signup for the site so that I can access the site's features.

Scenario Outline: Signup with credential 
	Given I am on the Signup page 
	When I enter a FirstName "<First Name>" 
	And I enter a Last Name "<Last Name>" 
	And I enter the DOB "<DOB>" 
	And I am able to pick the gender 
	And I enter the Citizenship "<Citizenship>" 
	And I enter the Current Location "<Current Location>" 
	And I enter the Mobile Number "<Mobile Number>" 
	And I enter the Valid Email "<Email>" 
	And I am able to enter the create account button 
	Then I should be redirected to the dashboard page 
	
	Examples: 
		| First Name | Last Name|   DOB       | Citizenship| Current Location | Mobile Number | Email | 
		| DineshKrish    | Krish        |  02-07-2001 | India   |   Chennai        | 6379732890    | feyaj430487@wiroute.com |
		| 11111       | 2        |  11111111  | 1119       |   1115           | DineshK   |  111285@gmail.com | 
		|            |          |            |            |                  |           |                   |    