Feature:  Adding numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Calculator

  Scenario Outline: Add two numbers
    Given I have a Calculator
    When I add <arg0> and <arg1>
    Then the sum should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 1    | 1    | 2   |
      | 1    | -1   | 0   |
      | -5   | -6   | -11 |

  Scenario Outline: Multiply two numbers
    Given I have a Calculator
    When I multiply <arg0> and <arg1>
    Then the multiplication should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 1    | 1    | 1   |
      | 1    | -1   | -1  |
      | -5   | -6   | 30  |

  Scenario Outline: Divide two numbers
    Given I have a Calculator
    When I divide <arg0> and <arg1>
    Then the divide should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 5    | 5    | 1   |
      | 10   | -2   | -5  |
      | 0    | 20   | 0   |


  Scenario Outline: Trying different operators
    Given I have a Calculator
    When I have <operator>, with the numbers <arg0> and <arg1>
    Then the result from the operation should be <res>
    Examples:
      | operator | arg0 |  | arg1 | res |
      | "+"      | 10   |  | 5    | 15  |
      | "-"      | 10   |  | -5   | 5   |
      | "*"      | 10   |  | 10   | 100 |
      | "/"      | 20   |  | 2    | 10  |
