Feature: Pet Endpoint

  @step1
  Scenario: Create a new pet
    Given I have a valid pet payload
    When I send a POST request to the /pet endpoint
    Then the response status code should b be 200 and contains the created pet details

  @step2
  Scenario: Update an existing pet
    Given I have an existing pet with ID "20" for updation
    And I have an updated pet payload
    When I send a PUT request to the /pet endpoint
    Then the response status code should ould be 200 for the update and contains the updated pet details

 
  @step4
  Scenario: Upload an image for a pet
    Given I have an existing pet with ID "20" for uploading image
    And I have a valid image file
    When I send a POST request to the /pet/{petId}/uploadImage endpoint
    Then the response status code should be 200 and the response should contain the uploaded image details

  @step6
  Scenario: get a pet
    Given I have an existing pet with ID for get
    When I send a get request to the /pet/{petId} endpoint
    Then the response status code should be 200 for the pet request and the response should confirm the pet request is succesfull

  @step7
  Scenario: get a pet by availability status
    Given I have an existing pet with ID for get
    When I send a request to the /pet/findbystatus endpoint
    Then the response status code should be 200 for the pet request and the response should list all the information
    
     @step3
  Scenario: Delete a pet
    Given I have an existing pet with ID "20" for deletion
    When I send a DELETE request to the /pet/{petId} endpoint
    Then the response status code should be 200 for the deleted pet
    
