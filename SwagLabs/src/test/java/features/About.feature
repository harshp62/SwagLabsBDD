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

Feature: About

Scenario: Check whether about link is displayed or not

Given user is logged in
When user is on the Inventory Page and opens the menu tab
Then the about link should appear

Scenario: test about link content
Given user is logged in
When user clicks on the about link on the Inventory Page
Then user is redirected to the "https://saucelabs.com/" url
And the page title is "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs"


