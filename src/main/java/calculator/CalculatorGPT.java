package calculator;

public class CalculatorGPT {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public int evaluate(String expression) {
        // Assumes the expression is in the format "operand operator operand", e.g., "8 / 2"
        String[] tokens = expression.trim().split(" ");
        int left = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int right = Integer.parseInt(tokens[2]);

        switch(operator) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            case "*":
                return multiply(left, right);
            case "/":
                return divide(left, right);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
