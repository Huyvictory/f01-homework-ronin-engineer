package Assignment11;

import java.util.ArrayList;

public class StackCustom {
    private ArrayList<Integer> stackArray;

    public void init() {
        System.out.println("Initializing stack");
        stackArray = new ArrayList<>();
    }

    public void push(int value) {
        if (value <= 1000000000) {
            stackArray.add(value);
        } else
            System.out.println("Error: value should be less than 10^9");
    }

    public int pop() {
        if (isEmpty() == -1) {
            return -1;
        }
        return stackArray.removeLast();
    }

    public int top() {
        if (isEmpty() == -1) {
            return -1;
        }
        return stackArray.getLast();
    }

    public int size() {
        return stackArray.size();
    }

    public int isEmpty() {
        return stackArray.isEmpty() ? -1 : 0;
    }

    public void end() {
        System.out.println("Ending Program");
    }
}
