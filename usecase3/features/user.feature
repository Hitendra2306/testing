#Author: hitendrak2001@gmail.com
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
Feature: User Endpoint

  @step1
  Scenario: Create list of users with the given input array
    Given I have a valid user payload for Create list of users
    When I send a POST request to the /user/createwithlist endpoint
    Then the response status code should be 200 for the list of users creation contains the created list of user details

  @step2
  Scenario: Get a user by username
    Given I have an existing user
    When I send a GET request to the /user/{username} endpoint with username "jojoj"
    Then the response status code should be 200 and the response should contain the user by the username details

  @step3
  Scenario: Update an existing user
    Given I have an existing user
    And I have an updated user payload for the updation
    When I send a PUT request to the /user/{username} endpoint with username "jojoj"
    Then the response status code should be 200 and the response should contain the updated user details

  @step4
  Scenario: Delete a user
    When I send a DELETE request to the /user/{username} endpoint with username "jojoj"
    Given I have an existing user
    Then the response status code should be 200 for the deletion and the response should confirm the user has been deleted

  @step5
  Scenario: Login a user
    Given I have valid login credentials
    When I send a GET request to the /user/login endpoint with (username: "jojoj", password: "123333")
    Then the response status code should be 200 for the login and the response should contain the users session information@

  @step6
  Scenario: Logout a user
    Given I am a logged-in user
    When I send a GET request to the /user/logout endpoint
    Then the response status code should be 200 for the logout and the response should confirm the user has been logged out

  @step7
  Scenario: Create a new user by username
    Given I have a valid user payload
    When I send a POST request to the /user endpoint
    Then the response status code should be 200 for the new user creation and the response should contain the created user details

  @step8
  Scenario: Create list of users with the given list
    Given I have a valid user payload for Create list of users
    When I send a POST request to the /user/createwitharray endpoint
    Then the response status code should be 200 for the list of users creation contains the created list of user details
