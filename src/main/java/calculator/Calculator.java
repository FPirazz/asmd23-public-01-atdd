package calculator;

import java.util.*;

public class Calculator {
    private String operator;
    private List<Integer> numbers = new LinkedList<>();

    public void use(String op) {
        operator = op;
    }

    public String getOperator() {
        return operator;
    }

    public void enter(int i){
        numbers.add(i);
        if (numbers.size() > 2){
            throw new IllegalStateException();
        }
    }

    public void add(){
        if (numbers.size() != 2){
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) + numbers.get(1));
        numbers.remove(1);
    }

    public int getResult() {
        if (numbers.size() != 1) {
            throw new IllegalStateException();
        }
        int results = numbers.get(0);
        numbers.remove(0);
        return results;
    }

    // Adding new operations below
    // Multiplication

    public void multiply() {
        if(numbers.size() != 2) {
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) * numbers.get(1));
        numbers.remove(1);
    }

    // Division

    public void divide() {
        if(numbers.size() != 2 || numbers.get(1) == 0) {
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) / numbers.get(1));
        numbers.remove(1);
    }





}
