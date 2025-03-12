Feature:  Adding numbers with a Scala Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Scala Calculator and not a Java one

  Scenario:  Add two positive numbers
    Given I have a Scala Calculator
    When I add 1 and 1 in scala
    Then the sum should be 2 in scala

  Scenario:  Add a positive and negative number
    Given I have a Scala Calculator
    When I add 1 and -1 in scala
    Then the sum should be 0 in scala

  Scenario:  Add two negative numbers
    Given I have a Scala Calculator
    When I add -1 and -1 in scala
    Then the sum should be -2 in scala


  Scenario:  Multiply two positive numbers
    Given I have a Scala Calculator
    When I multiply 1 and 5 in scala
    Then the multiplication should be 5 in scala

  Scenario:  Multiply a negative number and a positive number
    Given I have a Scala Calculator
    When I multiply -2 and 10 in scala
    Then the multiplication should be -20 in scala


  Scenario:  Divide two positive numbers
    Given I have a Scala Calculator
    When I divide 5 and 5 in scala
    Then the quotient should be 1 in scala

  Scenario:  Divide a negative number and a positive number
    Given I have a Scala Calculator
    When I multiply -10 and 2 in scala
    Then the quotient should be -5 in scala

  Scenario:  Divide a number by zero
    Given I have a Scala Calculator
    When I multiply 0 and 5 in scala
    Then the quotient should be 0 in scala


  Scenario:  Trying different operators
    Given I have a Scala Calculator
    When I have "*", with the numbers 0 and 5 in scala
    Then the result from the operation should be 0 in scala
    When I have "+", with the numbers 10 and 5 in scala
    Then the result from the operation should be 15 in scala
    When I have "-", with the numbers 10 and -5 in scala
    Then the result from the operation should be 5 in scala
    When I have "/", with the numbers 20 and 2 in scala
    Then the result from the operation should be 10 in scala
