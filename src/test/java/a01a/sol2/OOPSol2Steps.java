package a01a.sol2;

import a01a.sol2.GUI;
import a01a.sol2.Logic;
import a01a.sol2.LogicImpl;
import a01a.sol2.Position;
import calculator.Calculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class OOPSol2Steps {

    private int size = 10;
    private Logic logic;
    private GUI gui;



    //First Scenario

    @Given("I have a {int} x {int} grid")
    public void iHaveAGrid(int arg0, int arg1) {
        this.size = arg0;
        this.logic = new LogicImpl(this.size);
        this.gui = new GUI(this.size, logic);
    }

    @When("The user clicks on cell in position \\({int}, {int})")
    public void theUserClicksOnCellInPosition(int arg0, int arg1) {
        this.logic.hit(new Position(arg0, arg1));
    }

    @Then("The cell in position \\({int}, {int}) is numbered incrementally starting from {int}")
    public boolean theNumberShouldBe(int arg0, int arg1, int arg2) {
        return this.logic.getMark(new Position(arg0, arg1)).get() == arg2;
    }



    // Second Scenario

    @Given("I have a {int} x {int} grid grid with some numbered cells in positions \\({int}, {int}), \\({int}, {int})")
    public void iHaveAGridWithNumbers(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        this.size = arg0;
        this.logic = new LogicImpl(this.size);
        this.gui = new GUI(this.size, logic);

        this.logic.hit(new Position(arg2, arg3));
        this.logic.hit(new Position(arg4, arg5));
    }

    @When("The user clicks on a cell adjacent to a numbered cell, for example position \\({int}, {int})")
    public void theUserClicksOnCellInPositionNearAnother(int arg0, int arg1) {
        this.logic.hit(new Position(arg0, arg1));
    }

    @Then("All numbered cells move one position up and to the right, for example position \\({int}, {int})")
    public boolean theNumberShouldHaveMoved(int arg0, int arg1) {
        return this.logic.getMark(new Position(arg0, arg1)).isPresent();
    }

    @And("The clicked cell is not numbered, so position \\({int}, {int})")
    public boolean theOriginalCellShouldBeEmpty(int arg0, int arg1) {
        return this.logic.getMark(new Position(arg0, arg1)).isEmpty();
    }



    // Second Scenario

    @And("The cells are already moving, by clicking position \\({int}, {int})")
    public void theCellsAreMoving(int arg0, int arg1) {
        this.logic.hit(new Position(arg0, arg1));
    }

    @When("The user clicks on any cell, for example position \\({int}, {int})")
    public void theUserClicksARandomCell(int arg0, int arg1) {
        this.logic.hit(new Position(arg0, arg1));
    }

    @Then("All numbered cells move one position up and to the right, so check positions \\({int}, {int}), \\({int}, {int})")
    public boolean theNumberShouldHaveMoved(int arg0, int arg1, int arg2, int arg3) {
        return this.logic.getMark(new Position(arg0, arg1)).isPresent() &&
                this.logic.getMark(new Position(arg2, arg3)).isPresent();
    }



    // Second Scenario

    @When("A numbered cell moves out of the grid bounds, by clicking position \\({int}, {int})")
    public void theUserClicksAnExitingCell(int arg0, int arg1) {
        this.logic.hit(new Position(arg0, arg1));
    }

    @Then("The game ends")
    public boolean theGameIsOver(int arg0, int arg1, int arg2, int arg3) {
        return this.logic.isOver();
    }
}
