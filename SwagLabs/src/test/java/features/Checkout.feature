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



