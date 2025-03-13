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


## Task 2: Tooling
Experiment with installing/using Cucumber with Scala and/or in VSCode. Is VSCode better at all here? Does Cucumber play 
well with Scala 3?

### Work Done:

#### **VSCode**:

Starting with VSCode, the IDE can indeed be used to both write and/or execute Gherkin "programs", the main problem
though lies in the set up, as it is very convoluted to set up the required plugins and steps in order to try and use
Gherkin with multiple languages (Java, Scala, Typescript, Javascript ecc.); compare this with *IntelliJ*, which requires
only the installation of **one** plugin for the IDE to recognize the language and execute it properly.

The first step is to open the main directory of the application we want to write and test to using VSCode, then two
plugins have to be downloaded:

* ***Cucumber (Gherkin) Full Support***, to enable suggestions and help when writing Gherkin resource files;
* ***Cucumber Quick***, to enable the actual running of the Gherkin files using different platforms.

Both plugins also require (if not already present) the creation of the *.vscode* directory, in the main directory of the
application, and the creation ofa a .json file called *settings.json* inside of it, to hold all the configs necessary
for the extensions to run. 

Both are very much customizable, and once the file is set up, the first extension is already ready to use, the problem lies
in lieu of the second one, which requires the installation, set up and configuration of different tools (only one is
needed but it still is very bothersome compared to IntelliJ). The currently supported tools, as per stated in the
extension's main page, are:

* Protractor Cucumber;
* WebDriverIo Cucumber;
* Cypress Cucumber Pre-processor;
* Native CucumberJS;
* Serenity-JS.

It goes without saying that IntelliJ reveals itself to be quite more easy and straightforward to set up, and I will use
it from this point onward for the other tasks (I have also used it for the first Calculator task).


#### **Scala**:

When it comes to Scala, as previously stated, it was surprisingly easy to develop Cucumber tests, considering the 
straightforwardness of IntelliJ. The first thing to do was to download the appropriate plugin, called 
***Cucumber for Scala***, and I also added this line to the SBT build file to download the necessary libraries data with
the following code:

```
ThisBuild / version := "0.1.0-SNAPSHOT"
lazy val root = (project in file("."))
  .settings(
    name := "java-sbt-example",
    libraryDependencies ++= Seq(
        "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
        "io.cucumber" % "cucumber-java" % "6.1.1" % Test,
  --->  "io.cucumber" %% "cucumber-scala" % "6.10.4" % Test,
    )
)
```

As with Java, I implemented both a Scala version of the Calculator implementation, and the Steps implementation. The 
Calculator class is shown as follows:

```
package calculator

import scala.collection.mutable.ListBuffer

trait CalculatorScala {
  def use(op: String): Unit
  def getOperator: String
  def enter(i: Int): Unit
  def add(): Unit
  def getResult: Int
  def multiply(): Unit
  def divide(): Unit
}
object CalculatorScala {
  private class CalculatorScalaImpl extends CalculatorScala {
    private var operator: String = _
    private val numbers: ListBuffer[Int] = ListBuffer()

    override def use(op: String): Unit = {
      operator = op
    }

    override def getOperator: String = operator

    override def enter(i: Int): Unit = {
      numbers += i
      if (numbers.size > 2)
        throw new IllegalStateException()
    }

    override def add(): Unit = {
      if (numbers.size != 2)
        throw new IllegalStateException()
      numbers(0) += numbers(1)
      numbers.remove(1)
    }

    override def getResult: Int = {
      if (numbers.size != 1)
        throw new IllegalStateException()
      val result = numbers.head
      numbers.remove(0)
      result
    }

    // Adding new operations below
    // Multiplication

    override def multiply(): Unit = {
      if (numbers.size != 2)
        throw new IllegalStateException()
      numbers(0) *= numbers(1)
      numbers.remove(1)
    }

    // Division
    override def divide(): Unit = {
      if (numbers.size != 2 || numbers(1) == 0)
        throw new IllegalStateException()
      numbers(0) /= numbers(1)
      numbers.remove(1)
    }
  }
  def apply(): CalculatorScala = new CalculatorScalaImpl
}
```

And here below is a code example of the Steps version of the Scala implementation:

```
Given("I have a Scala Calculator") { () =>
    this.calculator = CalculatorScala.apply()
}
  
...
  
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
```

Following the implementation of the code in the project, IntelliJ is able to run Cucumber tests using Scala without any
problems, showing that is capable of supporting not only Java, but as a matter of fact other languages and subsets of 
languages (For example Typescript).

## Task 5: ATDD-LLM

LLMs/ChatGPT can arguably help in write/improve/complete/implement/reverse-engineer a Gherkin specification. 
Experiment with this, based on the above tasks or in other cases. Is ChatGPT useful for all that?

### Word Done:

As the task asks, I tried different things operations to perform to either write, improve, complete, implement or
reverse-engineer Gherkin specifications, and as a baseline I used the specs I developed for the first task, using the
ChatGPT model available on OpenAI as of 13/03/2025, which let you also use separate options for do more reasoning before
responding, and also search answers on the web;  for every operation I also tried to use to the best of my abilities 
prompt engineering, in order to get better results, for each operation I will include the prompt and any changes to 
it to a certain extent when needed, and finally I will create a different chat for each operation to ensure the model
isn't using data previously produced. The operations went as follows:

* Write: For this operation I asked with the following prompt:
```
Could you pretty pretty please help me write a Cucumber script in Gherkin for a java application. The application is 
just a basic idea of a Calculator, and I want the main operations to be covered (sum, difference, multiplication and 
division), and also a case where the operation is inputted alongside the numbers.
```
As much as silly as the pleading looks, I've found it helps with the results being overly polite to LLM models generally
speaking, reading online that it might stem as a bias in the training data of LLMs generally speaking, were usually, as 
it is in real life, "better responses" are given if the question was asked politely rather than rudely.

GPT actually produced a decent Gherkin script, that looks like the one present in the Gherkin file called 
CalculatorGPT.feature.

Very much similar to mine, I've also asked to produce a Java file for the steps definition, in a similar manner as the
first one, that ended up producing the code for the steps definition ***and*** the business logic, defined respectively
in the CalculatorStepsGPT.java and CalculatorGPT.java files. I did not paste the content here to not make the README 
heavier.

And after turning this code into proper Java and feature files, it actually worked well! (Aside from some very minor
cleanup). Therefore, the writing operation went really well.

* Improve/Complete: The prompt given in this case was:
```
Could you pretty pretty please help me imrpove a Cucumber script in Gherkin for a java application. The application is 
just a basic idea of a Calculator, and it's written like this:
"
...
"
```
Where the "dots" (...) part included the whole of the Calculator.feature file, and in turn it produced what is contained
inside the CalculatorGPTimproved.feature. The result was actually, again, quite good! It produced multiple Scenario 
Outlines without ever presenting in the prompt, and also simplification like the Background. For the "Complete" operation
I provided GPT, in another chat, with a half finished (not working) version of the Calculator.feature script, which in
turn produced a result basically very similar to the previous one (Mainly the components, obviously the words and
phrases provided by the LLM were different).

* Reverse-Engineer: Finally for the reverse-engineering, I fed GPT this prompt:
```
Could you pretty pretty please help me reverse engineer a Cucumber script in Gherkin from the java business logic and 
steps? The business logic is as follows:
"
...
"
And the steps are as follows:
"
...
"
```
Where in the first few dots I included the Calculator.java file, in the second ones the CalculatorSteps.java one. It once
again produced a Gherkin file, that looks like this:
```
Feature: Basic Calculator Operations

  Scenario: Adding two numbers
    Given I have a Calculator
    When I add 5 and 3
    Then the sum should be 8

  Scenario: Multiplying two numbers
    Given I have a Calculator
    When I multiply 4 and 2
    Then the multiplication should be 8

  Scenario: Dividing two numbers
    Given I have a Calculator
    When I divide 10 and 2
    Then the quotient should be 5

  Scenario: Performing a specified operation
    Given I have a Calculator
    When I have "+", with the numbers 6 and 4
    Then the result from the operation should be 10

  Scenario: Performing multiplication using the operation keyword
    Given I have a Calculator
    When I have "*", with the numbers 7 and 3
    Then the result from the operation should be 21

  Scenario: Performing division using the operation keyword
    Given I have a Calculator
    When I have "/", with the numbers 20 and 4
    Then the result from the operation should be 5
```
Which is again very well done and usable, even though obviously it's not as identical as the one I made.

**Conclusion**
GPT revealed itself to be quite useful actually in producing Gherkin specification, whether this be the work of updating
the knowledge of GPT or in some other way I don't know but it definitely can be used for the job in question. 