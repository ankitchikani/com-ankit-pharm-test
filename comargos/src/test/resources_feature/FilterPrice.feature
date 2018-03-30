Feature: FILTERS
  AS a Customer
  I want to filter by product price
  So that i can view respective products between that range


  Scenario: Filter by customer rating
    Given I am homepage
    When I hover on "Technology"
    And I select a category  "Televisions & accessories"
    And I select a subcategory  "Televisions"
    And I expand a "PRICE" filter type
    And I select a "£100 - £150" filter value
    Then I should see all respective products set to between 100 and 150
