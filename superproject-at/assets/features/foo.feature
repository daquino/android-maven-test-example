Feature: Button
  Pressing the Foo or Bar button should do some stuff.

  Scenario Outline: Press the button and get a result
    Given I have a HelloAndroidActivity
    When I press the <button> button
    Then I should see <result> in the textview
    
  Examples:
    | button | result  |
    | Foo    | result2 |
    | Bar    | result3 |