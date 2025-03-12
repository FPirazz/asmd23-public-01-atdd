Feature:  Adding numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Calculator

  Background: Start with a Calculator
    Given I have a Calculator

  Scenario:  Add two positive numbers
    When I add 1 and 1
    Then the sum should be 2

  Scenario:  Add a positive and negative number
    When I add 1 and -1
    Then the sum should be 0

  Scenario:  Add two negative numbers
    When I add -1 and -1
    Then the sum should be -2


  Scenario:  Multiply two positive numbers
    Given I have a Calculator
    When I multiply 1 and 5
    Then the multiplication should be 5

  Scenario:  Multiply two negative numbers
    Given I have a Calculator
    When I multiply -2 and 10
    Then the multiplication should be -20


  Scenario:  Divide two positive numbers
    Given I have a Calculator
    When I divide 5 and 5
    Then the divide should be 1

  Scenario:  Divide a negative number and a positive number
    Given I have a Calculator
    When I multiply -10 and 2
    Then the divide should be -5

  Scenario:  Divide a number by zero
    Given I have a Calculator
    When I multiply 0 and 5
    Then the divide should be 0