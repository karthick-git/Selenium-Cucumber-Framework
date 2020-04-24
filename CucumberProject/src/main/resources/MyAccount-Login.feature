Feature: MyAccount-Login Feature
  Description: This feature will test a Login feature

  #Simple login without parameters
	Scenario: Log-in with valid username and password 
	Given User navigates to practice automationtesting website
	And Click on My Account Menu
	And Enter registered username and password
	When Click on login button
	Then User must successfully login to the web page 