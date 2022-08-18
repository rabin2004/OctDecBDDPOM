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

Feature: Change Language feature
As a customer, I should be able to switch to desired language

@Smoke
Scenario: Validate default language
Given customer is in homepage
When customer clicks on flag icon
Then customer should see English radiobutton default selected

@DataDriven
Scenario: Validate switch language between English and Spanish
Given customer is in homepage
When customer clicks on flag icon
And customer clicks "English" radio button
Then language should change "English"




