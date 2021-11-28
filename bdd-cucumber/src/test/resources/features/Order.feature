Feature: Order items from an ecommerce shop

  Scenario Outline: As a buyer I can order the items
    Given I added to cart the items with the <ItemId>
    And with the <Price>
    And the <Quantities>
    And the shipping price is 3.6
    And I have a discount code which is 2.5
    Then the price that I have to pay is 86.74
    Examples:
      | ItemId | Price | Quantities |
      | 1      | 10.99 | 3          |
      | 2      | 5.66  | 2          |
      | 3      | 7.77  | 5          |
      | 4      | 2.5   | 1          |