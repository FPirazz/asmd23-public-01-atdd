package calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStepsGPT {

    private int result;
    private final CalculatorGPT calculator = new CalculatorGPT();

    @Given("the calculator is turned on")
    public void theCalculatorIsTurnedOn() {
        // Any necessary initialization can be done here.
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int a, int b) {
        result = calculator.add(a, b);
    }

    @When("I subtract {int} from {int}")
    public void iSubtractFrom(int subtrahend, int minuend) {
        // Note: subtract(minuend, subtrahend) to correctly represent "minuend - subtrahend"
        result = calculator.subtract(minuend, subtrahend);
    }

    @When("I multiply {int} by {int}")
    public void iMultiplyBy(int a, int b) {
        result = calculator.multiply(a, b);
    }

    @When("I divide {int} by {int}")
    public void iDivideBy(int a, int b) {
        result = calculator.divide(a, b);
    }

    @When("I enter the expression {string}")
    public void iEnterTheExpression(String expression) {
        result = calculator.evaluate(expression);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expected) {
        assertEquals(expected, result);
    }
}
