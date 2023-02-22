Feature: Product List

Scenario Outline: Test product list

Given user is logged in
When user is on the Inventory Page and the products tab is displayed
Then the <productname> is present on the page

Examples:

|productname|
|Sauce Labs Backpack|
|Sauce Labs Bike Light|
|Sauce Labs Bolt T-Shirt|
|Sauce Labs Fleece Jacket|
|Sauce Labs Onesie|
|Test.allTheThings() T-Shirt (Red)|


Scenario: Test Aplhabetical filter


Given user is logged in
And user is on the Inventory Page and the products tab is displayed
When User filters the products alphabetically is descending order (Z-A)
Then The products should be displayed in descending alphabetical order

Scenario: Test Price Filter - Low to High 

Given user is logged in
And user is on the Inventory Page and the products tab is displayed
When User filters the products by price from low to high
Then The products should be displayed by price from low to high

