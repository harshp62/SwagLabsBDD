Feature: External Links
  @Links
  Scenario Outline: Test Links
    Given user is logged in
    When the user clicks on the <link> link
    Then the user is navigated to the <link> link page

    Examples:
    |link|
    |facebook|
    |linkedin|
    |twitter |


