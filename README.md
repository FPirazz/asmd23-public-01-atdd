# 01Lab - Requirements, Acceptance Testing, and BDD/ATDD

## Task 1: Calculator
The repo has a calculator example (with Gherkin specification, step implementation, and production code). Play with it. 
Add examples and operations, use all Gherkin features. Strictly use ATDD. Does everything work as expected?

### Work Done:

As to firstly try the features offered by the lab as a practical introduction to Gherkin, I used the IntelliJ IDE to try
the calculator example, simply by installing the appropriate plugins available on the marketplace, making sure that
everything was working properly.

After doing that, I tested the capabilities of Gherkin by introducing a new executable operation for our calculator, that
is the division operation, and therefore I implemented the new Scenarios in Gherkin firstly, as to follow the **ATDD**
specifications, and thereafter I added the necessary Steps and Implementation needed to achieve the correct result, as
shown below.

The new scenarios produced for the division:
```
Scenario:  Divide two positive numbers
    Given I have a Calculator
    When I divide 5 and 5
    Then the quotient should be 1
```

```
  Scenario:  Divide a negative number and a positive number
    Given I have a Calculator
    When I multiply -10 and 2
    Then the quotient should be -5
```

```
  Scenario:  Divide a number by zero
    Given I have a Calculator
    When I multiply 0 and 5
    Then the quotient should be 0
```

I also added a Scenario Outline in order to cover more test cases easily, like this:
```
  Scenario Outline: Divide two numbers
    Given I have a Calculator
    When I divide <arg0> and <arg1>
    Then the quotient should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 5    | 5    | 1   |
      | 10   | -2   | -5  |
      | 0    | 20   | 0   |
```

Thereafter, I defined the necessary steps:

```
@When("I divide {int} and {int}")
    public void iDivideAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }
```

```
    @Then("the quotient should be {int}")
    public void theQuotientShouldBe(int arg0) {
        this.calculator.divide();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }
```

Finally adding the necessary code in the Calculator.java class for the actual division to take place, which also checks
that the second number given is **not** a zero, otherwise an exception is thrown:

```
public void divide() {
        if(numbers.size() != 2 || numbers.get(1) == 0) {
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) / numbers.get(1));
        numbers.remove(1);
    }
```

After that, in order to make the tests more interesting, I thought of adding a logic system to automatically calculate the
result of a certain operation, given the operator to use (e.g. if the "+" operator is given, then a sum, or difference,
is to be performed).

I achieved this in the same way I did of introducing the division operator and operations, with the Scenarios created as
shown below:

```
  Scenario:  Trying different operators
    Given I have a Calculator
    When I have "*", with the numbers 0 and 5
    Then the result from the operation should be 0
    When I have "+", with the numbers 10 and 5
    Then the result from the operation should be 15
    When I have "-", with the numbers 10 and -5
    Then the result from the operation should be 5
    When I have "/", with the numbers 20 and 2
    Then the result from the operation should be 10
```

```
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
```

Then the proper Steps were implemented, where the operator and the two number are given:

```
@When("I have {string}, with the numbers {int} and {int}")
    public void iDivideAnd(String arg0, int arg1, int arg2) {
        this.calculator.use(arg0);
        this.calculator.enter(arg1);
        this.calculator.enter(arg2);
    }
```

And here we check to see which operation has been chosen, and the appropriate method to call.

```
@Then("the result from the operation should be {int}")
    public void theResultFromOperationShouldBe(int arg0) {
        if(this.calculator.getOperator().equals("+") || this.calculator.getOperator().equals("-")) {
            this.calculator.add();
        } else if(this.calculator.getOperator().equals("*")) {
            this.calculator.multiply();
        } else if(this.calculator.getOperator().equals("/")) {
            this.calculator.divide();
        } else {
            throw new IllegalStateException();
        }
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }
```

And finally in the proper code implementation in the .java class, I added a variable to store the operator to use, like 
this:

```
private String operator;
```

```
public void use(String op) {
        operator = op;
    }
```

```
public String getOperator() {
        return operator;
    }
```