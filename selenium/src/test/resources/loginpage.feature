
Feature: Login to website

  
  Scenario: user login
    Given user email ID and password
    When clicks on login
    And user enters "<UserName>","<Password>" 
    And user clicks login Button;
    Then User login successfull
    
    Examples:
    |UserName|Password|
    |||

  