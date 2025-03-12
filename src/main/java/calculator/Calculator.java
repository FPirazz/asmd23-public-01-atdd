package calculator;

import java.util.*;

public class Calculator {
    private List<Integer> numbers = new LinkedList<>();

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

    public int getResult(){
        if (numbers.size() != 1){
            throw new IllegalStateException();
        }
        return numbers.get(0);
    }

    // Adding new operations below

    public void multiply() {
        if(numbers.size() != 2) {
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) * numbers.get(1));
        numbers.remove(1);
    }

    public void divide() {
        if(numbers.size() != 2 || numbers.get(1) == 0) {
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) / numbers.get(1));
        numbers.remove(1);
    }


}
