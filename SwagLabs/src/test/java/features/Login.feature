#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Login

Scenario Outline: Test all valid login credentials

Given User is on the homepage and title is displayed
When User inputs valid <username> and <password> and logs in
Then he is redirected to the Inventory page
And the products tab is visible

Examples:

|username								|password|
|standard_user					|secret_sauce|
|locked_out_user				|secret_sauce|
|problem_user						|secret_sauce|
|performance_glitch_user|secret_sauce|

Scenario Outline: Test invalid password

Given User is on the homepage and title is displayed
When User inputs valid <username> and invalid <password>
Then Appropriate error message is displayed
And User is still on the homepage

Examples:

|username								|password|
|standard_user					        |abc|
|locked_out_user				        |s1ss2s36hsadasd|
|problem_user						    |456456456456|
|performance_glitch_user                |asda"####"|


Scenario: Test blank password field

Given User is on the homepage and title is displayed
When user inputs valid username as "standard_user" and leaves the password field blank
Then Error message is displayed requiring the user to input a password
And User is still on the homepage

Scenario Outline: Test Invalid Username

Given User is on the homepage and title is displayed
When User inputs invalid <username> and valid password as "secret_sauce"
Then Appropriate error message is displayed
And User is still on the homepage

Examples:

|username		|							
|asdas123123	|						
|aaasdasd"#$#$&"|					
|"#$^&@#$"				|				
|ascacasc12312312312312312|






