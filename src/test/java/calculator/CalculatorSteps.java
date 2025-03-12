package calculator;

import io.cucumber.java.en.*;

class CalculatorSteps {
    private int res = 0;
    private Calculator calculator;

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the sum should be {int}")
    public void theSumShouldBe(int arg0) {
        this.calculator.add();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

    // Adding new operations below
    // Multiplication

    @When("I multiply {int} and {int}")
    public void iMultiplyAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the multiplication should be {int}")
    public void theMultiplicationShouldBe(int arg0) {
        this.calculator.multiply();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

    // Division

    @When("I divide {int} and {int}")
    public void iDivideAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the quotient should be {int}")
    public void theQuotientShouldBe(int arg0) {
        this.calculator.divide();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

    // Multiple operations setup

    @When("I have {string}, with the numbers {int} and {int}")
    public void iDivideAnd(String arg0, int arg1, int arg2) {
        this.calculator.use(arg0);
        this.calculator.enter(arg1);
        this.calculator.enter(arg2);
    }

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

}
