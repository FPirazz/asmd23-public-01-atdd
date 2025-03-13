Feature: Calculator Operations
  As a user of the calculator
  I want to perform basic arithmetic operations
  So that I can get correct results for addition, subtraction, multiplication, and division.

  Background:
    Given the calculator is turned on

  Scenario: Addition
    When I add 2 and 3
    Then the result should be 5

  Scenario: Subtraction
    When I subtract 2 from 7
    Then the result should be 5

  Scenario: Multiplication
    When I multiply 4 by 3
    Then the result should be 12

  Scenario: Division
    When I divide 12 by 4
    Then the result should be 3

  Scenario: Evaluate expression from input string
    When I enter the expression "8 / 2"
    Then the result should be 4
