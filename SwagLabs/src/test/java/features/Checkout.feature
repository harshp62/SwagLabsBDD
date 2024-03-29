Feature: checkout products

@Checkout
Scenario Outline: test user checkout

Given user is logged in
And user is on the Inventory Page and the products tab is displayed
When User adds <product> to the cart
And goes to the cart page
Then user is navigated to the cart page
And cartpage title is displayed
And <product> is displayed in the cart

Examples:

|product|
|Sauce Labs Backpack|
|Sauce Labs Bike Light|
|Sauce Labs Bolt T Shirt|
|Sauce Labs Fleece Jacket|
|Sauce Labs Onesie|
|Test.allTheThings() T Shirt (Red)|

@Regression
Scenario Outline: Test end-to-end flow

  Given user is logged in
  And user is on the Inventory Page and the products tab is displayed
  When User adds <product> to the cart
  And goes to the cart page
  Then user is navigated to the cart page
  And cartpage title is displayed
  And <product> is displayed in the cart
  When user checks out
  Then user is navigated to the checkout one page
  When user enters his information as "Michael", "Scott", "380007" and continues
  Then user is navigated to checkout part two page
  And <product> name is displayed
  And the total price of the product after tax is <total>
  When user clicks on finish button
  Then user is navigated to checkout complete page
  And Success message "Thank you for your order!" is displayed

  Examples:
    |product              |total |
    |Sauce Labs Backpack  | 32.39|
    |Sauce Labs Bike Light| 10.79|

@Datavalidation
  Scenario Outline: test checkout data validations
    Given user is logged in
    And user is on the Inventory Page and the products tab is displayed
    When User adds <product> to the cart
    And goes to the cart page
    Then user is navigated to the cart page
    And cartpage title is displayed
    And <product> is displayed in the cart
    When user checks out
    Then user is navigated to the checkout one page
    When user enters his information as "<firstname>", "<lastname>", "<postalcode>" and continues next
    Then <errormessage> error is displayed

    Examples:

      |product              |errormessage                  |firstname   |lastname   |postalcode|
      |Sauce Labs Backpack  |Error: First Name is required |            |Scott      |123456    |
      |Sauce Labs Backpack  |Error: Last Name is required  |Michael     |           |123456    |
      |Sauce Labs Backpack  |Error: Postal Code is required|Dwight      |Schrute    |          |

@Remove
  Scenario Outline: Test Remove items button
    Given user is logged in
    And user is on the Inventory Page and the products tab is displayed
    When User adds <product> to the cart
    And removes the <product> from the cart by cliking th remove item button
    Then the items is removed from the cart and the cart icon is changed

  Examples:

    |product|
    |Sauce Labs Backpack|
    |Sauce Labs Bike Light|









