Feature: Calculator Operations
  In order to simplify arithmetic for those who dislike manual math
  As a user of the Calculator
  I want to perform various operations like addition, multiplication, and division

  Background:
    Given I have a Calculator

  Scenario Outline: Add two numbers
    When I add <num1> and <num2>
    Then the sum should be <result>

    Examples:
      | num1 | num2 | result |
      | 1    | 1    | 2      |
      | 1    | -1   | 0      |
      | -1   | -1   | -2     |

  Scenario Outline: Multiply two numbers
    When I multiply <num1> and <num2>
    Then the product should be <result>

    Examples:
      | num1 | num2 | result |
      | 1    | 5    | 5      |
      | -2   | 10   | -20    |

  Scenario Outline: Divide two numbers
    When I divide <num1> by <num2>
    Then the quotient should be <result>

    Examples:
      | num1 | num2 | result |
      | 5    | 5    | 1      |
      | -10  | 2    | -5     |

  Scenario: Divide a number by zero
    When I divide 5 by 0
    Then an error message "Cannot divide by zero" should be displayed

  Scenario Outline: Perform various operations
    When I calculate <num1> <operator> <num2>
    Then the result should be <result>

    Examples:
      | operator | num1 | num2 | result |
      | *        | 0    | 5    | 0      |
      | +        | 10   | 5    | 15     |
      | -        | 10   | 5    | 5      |
      | /        | 20   | 2    | 10     |
