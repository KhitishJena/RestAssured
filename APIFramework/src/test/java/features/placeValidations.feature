
Feature: Validating place API

  
  Scenario: Verify if add place is adding place successfully
    Given Add Place payload
    When when user call "AddPlaceAPI" with http request
    Then The API call is success with status code "200"
    And "status" in response is "OK"
    And "scope" in the response body is "APP"
    