Feature: Tags in cucumber

@SanityTest
Scenario: Verify login
Given This is valid login test

@SanityTest @End2End
Scenario: Verify logout
Given this is logout test

@RegressionTest
Scenario: Verify search
Given this is search test

@RegressionTest @End2End
Scenario: verify advanced search
Given This is advanced search test

@End2End
Scenario: verify prepaid recharge
Given This is prepaid recharge test

@End2End
Scenario: Verify post paid recharge
Given This is post paid recharge test