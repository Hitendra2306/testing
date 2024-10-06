Feature: Store Endpoint

  @step1
  Scenario: Place a new order
    Given I have a valid order payload
    When I send a POST request to the /store/order endpoint
    Then the response status code for the store api should be 200 and the response should contain the placed order details

  @step2
  Scenario: Find an order by ID
    Given I have an existing order
    When I send a GET request to the /store/order/{orderId) endpoint with ID "10"
    Then the response status code for the store api should be 200 and the response should contain the order details

  @step3
  Scenario: Delete an order
    Given I have an existing order 
    When I send a DELETE request to the /store/order/{orderId) endpoint with ID "10"
    Then the response status code for the store api should be 200 and should confirm the order has been deleted

  @step4
  Scenario: Get store inventory
    Given I have the base URI
    When I send a GET request to the /store/inventory endpoint
    Then the response status code for the store api should be 200 and the response should contain the store inventory details
