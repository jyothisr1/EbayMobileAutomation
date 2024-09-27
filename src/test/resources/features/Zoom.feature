Feature: Zoom Functionality
  Scenario: Verify Zoom with Ebay
    Given user opens application
    Then verify user is on home screen
    When user search for element1 "search.element1"
    Then verify the user is on element1 searched page
    And Click the first element of element1
    And click on the image of element1
    And verify zoom functionality