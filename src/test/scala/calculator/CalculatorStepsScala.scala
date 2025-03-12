package calculator

import io.cucumber.scala.ScalaDsl
import io.cucumber.scala.EN


class CalculatorStepsScala extends ScalaDsl with EN {
  private var res: Int = 0
  private var calculator: CalculatorScala = _

  Given("I have a Scala Calculator") { () =>
    this.calculator = CalculatorScala.apply()
  }

  When("I add {int} and {int} in scala") { (arg0: Int, arg1: Int) =>
    this.calculator.enter(arg0)
    this.calculator.enter(arg1)
  }

  Then("the sum should be {int} in scala") { (arg0: Int) =>
    this.calculator.add()
    if (arg0 != this.calculator.getResult)
      throw new IllegalStateException()
  }

  // Adding new operations below
  // Multiplication

  When("I multiply {int} and {int} in scala"){ (arg0: Int, arg1: Int) =>
    this.calculator.enter(arg0)
    this.calculator.enter(arg1)
  }

  Then("the multiplication should be {int} in scala") { (arg0: Int) =>
    this.calculator.multiply()
    if (arg0 != this.calculator.getResult)
      throw new IllegalStateException()
  }

  // Division

  When("I divide {int} and {int} in scala") { (arg0: Int, arg1: Int) =>
    this.calculator.enter(arg0)
    this.calculator.enter(arg1)
  }

  Then("the quotient should be {int} in scala") { (arg0: Int) =>
    this.calculator.divide()
    if (arg0 != this.calculator.getResult)
      throw new IllegalStateException()
  }

  // Multiple operations setup

  When("I have {string}, with the numbers {int} and {int} in scala") { (arg0: String, arg1: Int, arg2: Int) =>
    this.calculator.use(arg0)
    this.calculator.enter(arg1)
    this.calculator.enter(arg2)
  }

  Then("the result from the operation should be {int} in scala") { (arg0: Int) =>
    this.calculator.getOperator match {
      case "+" | "-" => this.calculator.add()
      case "*" => this.calculator.multiply()
      case "/" => this.calculator.divide()
      case _ => throw new IllegalStateException()
    }
    if (arg0 != this.calculator.getResult)
      throw new IllegalStateException()
  }
}

