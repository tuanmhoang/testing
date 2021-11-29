@Order
Feature: Order items from an ecommerce shop

  @System
  Scenario Outline: As a system, I can calculate the item price with its quantity
    Given I added to cart the items with the price is <Price>
    And the quantity is <Quantities>
    Then the price that I have to pay is <ItemPrice>
    Examples:
      | Price | Quantities | ItemPrice |
      | 10.99 | 3          | 32.97     |
      | 5.66  | 2          | 11.32     |
      | 7.77  | 5          | 38.85     |
      | 2.5   | 1          | 2.5       |

  @Buyer
  Scenario: As a buyer, I can order items such as
    Given I add to cart the items like this
      | Id | Price | Quantities |
      | 1  | 10.99 | 3          |
      | 2  | 5.66  | 2          |
      | 3  | 7.77  | 5          |
      | 4  | 2.5   | 1          |
    And the shipping fee is 3.7
    And with the discount code I can reduce the price is 2.6
    When I go to the last step
    Then the final price should be 86.74

  @Seller
  Scenario: As a seller, I can update the order status
    Given I update the status of the order like this
      | Id | Status  |
      | 1  | Pending |
      | 2  | Pending |
    And I update the status of the first id is 1 to "Shipped"
    And I update the status of the second id is 2 to "Canceled"
    When I check the order status again
    Then the status should be like this
      | Id | Status   |
      | 1  | Shipped  |
      | 2  | Canceled |