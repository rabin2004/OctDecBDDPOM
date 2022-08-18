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

@Release1.0 @SearchFunctionality
Feature: Search Functionality
As a customer using search funtionality I should be able to find desired products.

Scenario: Positive search functionality test by clicking search icon
Given customer is in home page
When customer provides valid product for search
And clicks search icon
Then related product should be displayed

Scenario: Positive search functionality test by hitting enter key
Given customer is in home page
When customer provides valid product for search
And customer hits enter key
Then related product should be displayed

Scenario: Negative search functionality test by hitting enter key
Given customer is in home page
When customer provides invalid product for search
And customer hits enter key
Then related product shouldnot be displayed

Scenario: Negative search functionality test by clicking search icon
Given customer is in home page
When customer provides invalid product for search
And clicks search icon
Then related product shouldnot be displayed

@DataDriven
Scenario Outline: Positive search functionality test data driven
Given customer is in home page
When customer provides valid "<product>" for search
And clicks search icon
Then related "<product>" should be displayed

Examples:
|product|
|apple|
|orange|
|samsung|
|google|





