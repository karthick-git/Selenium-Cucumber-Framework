Feature: MyAccount-Login Feature
  Description: This feature will test a Login feature

 #Simple login without parameters
#  Scenario: Log-in with valid username and password
#  Given User navigates to practice automationtesting website
#  And Click on My Account Menu
#  And Enter registered username and password
#  When Click on login button
#  Then User must successfully login to the web page
  
  #Simple login with parameters
#  Scenario: Log-in with valid username and password
#  Given User navigates to practice automationtesting website
#  And Click on My Account Menu
#  And Enter registered username "pavanoltraining" and password "Test@selenium123"
#  When Click on login button
#  Then User must successfully login to the web page
  
  #Simple login with scenario Outline & Examples Keyword
#  Scenario Outline: Log-in with valid username and password
#  Given User navigates to practice automationtesting website
#  And Click on My Account Menu
#  And Enter registered username "<username>" and password "<password>"
#  When Click on login button
#  Then Verify login
#  Examples:
#   | username        | password         |
#   | pavanoltraining | Test@selenium    |
#   | pavanol         | Test@selenium123 |
#   | pavanol         | Test@selenium    | 
    
  #Simple login with Data table params
# 	 Scenario: Log-in with valid username and password
#   Given User navigates to practice automationtesting website
#   And Click on My Account Menu
#   And Enter registered username and password
#      | pavanoltraining | Test@selenium123 |
#   When Click on login button
#   Then User must successfully login to the web page

  
   #Simple login with Data table params with header
 	 Scenario: Log-in with valid username and password
  	Given User navigates to practice automationtesting website
    And Click on My Account Menu
    And Enter registered username and password
       |	user	|	password	|
       | pavanoltraining | Test@selenium123 |
    When Click on login button
    Then User must successfully login to the web page
