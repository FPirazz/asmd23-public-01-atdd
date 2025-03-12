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

