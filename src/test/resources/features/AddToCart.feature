Feature: Verify AddToCart functionality

  Scenario: Verify the product is adding to cart
    Given user opens application
    Then verify user is on home screen
    When user search for element1 "search.element1"
    Then verify the user is on element1 searched page
#    And Click the first element of element1
#    And user click on add to cart button
#    When user search for element2 "search.element2"
#    Then verify the user is on element2 searched page
#    And Click the first element of element2
#    And verify item information on cart page
#    And verify item prices display correctly on cart page