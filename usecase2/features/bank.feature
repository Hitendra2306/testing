#Author: hitedrak2001@gmail.com
#Keywords Summary : This feature file is used to automate a banking website.
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
Feature: XYZ Bank Automation

  Background: Go to the website
    Given User navigating to the given website

  @login
  Scenario: Customer Login
    When User click on the Customer Login button
    Then User should be on the Customer Login page
    And User select the name from the dropdown list
    And User click on the Login button
    Then User should see the welcome message, account number, and balance

  @deposit
  Scenario Outline: Deposit Money
    When User click on the Deposit tab 
    And User enter "<amount>" in deposit input box
    And User click on the Deposit button
    Then User should see the message as Deposit Succesful for valid "<amount>" and no result for invalid amount

    Examples: 
      | amount |
      |    200 |
      |      0 |
      |   -100 |

  @withdraw
  Scenario Outline: Withdraw Money
    When User click on the Withdraw tab
    And User enter "<amount>" in the withdraw input box
    And User click on the Withdraw button
    Then User should see the message as Withdraw Succesful for valid "<amount>" and no result for invalid amount

    Examples: 
      | amount |
      |    200 |
      |      0 |
      |   -100 |

  @transactions
  Scenario: View Transactions
    When User click on the Transactions button
    Then User should be on the Transactions page
    And User should see the transaction details in a table

  @logout
  Scenario: Logout
    When User click on the logout button
    Then User should be on the login page

  @home
  Scenario: Go to Home Page
    When User click on the home button
    And User should be on the landing page and click on the Bank Manager Login button
    Then User should be on the Manager page

  @add_customer
  Scenario Outline: Add Customer
    When User click on the Add Customer button 
    And User fill the input elements with data from the "<sheetname>" excel sheet 
    Then User should see the customer id in the alert box along with a success message

    Examples: 
      | sheetname   |
      | addCustomer |

  @open_account
  Scenario Outline: Open Account
    When User click on the Open Account button with existing data from "<excelsheet>"
    And User fill the input elements with data from the "<excelsheet>"
    Then User should see the account details

    Examples: 
      | excelsheet  |
      | addcustomer |

  @customers
  Scenario: View Customers
    When User click on the Customers button
    Then User should see the customer details in a table
    And User should see the search input box functionality

  @delete_customer
  Scenario Outline: Delete Customer
    When User click on the delete button against the newly added customer from the "<excelsheet>"
    Then User should see the customer removed from the table

    Examples: 
      | excelsheet  |
      | addcustomer |
