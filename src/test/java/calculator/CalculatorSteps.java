package calculator;

import io.cucumber.java.en.*;

public class CalculatorSteps {
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


    @When("I divide {int} and {int}")
    public void iDivideAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the divide should be {int}")
    public void theDivideShouldBe(int arg0) {
        this.calculator.divide();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

}
