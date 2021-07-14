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
Feature: Validation of transactional data

  Scenario: Verify the count of values appear on the screen
    Given user lands on the "transactional page"
    When user verifies the count of values and value_lables
    Then total count of values should be 5 
    And total count of value_lables should be 5


  Scenario: Verify the values on the screen are greater than 0
    Given user lands on the "transactional page"
    When user verifies the transactional values
    Then values should be greater than 0


  Scenario: Verify the total balance is correct based on the values listed on the screen
    Given user lands on the "transactional page"
    When user verifies the total balance and transactional values
    Then total balance should be equal to the sum of values listed


  Scenario: Verify the values are formatted as currencies
    Given user lands on the "transactional page"
    When user verifies the transactional values
    Then prefix should be "$" 
    And values should have digit decimal value


  Scenario: Verify the total balance matches the sum of the values
    Given user lands on the "transactional page"
    When user verifies the total balance and transactional values
    Then total balance should be equal to the sum of values listed

