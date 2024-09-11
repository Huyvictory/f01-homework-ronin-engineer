package Assignment11;

import java.util.ArrayList;

public class QueueCustom {
    private ArrayList<Integer> queueArray;

    public void init() {
        System.out.println("Initializing queue");
        queueArray = new ArrayList<>();
    }

    public int size() {
        return queueArray.size();
    }

    public int isEmpty() {
        return queueArray.isEmpty() ? -1 : 0;
    }

    public void enQueue(int value) {
        if (value < 1000000) {
            queueArray.add(value);
            System.out.println("Queue array after adding " + value + " is " + queueArray);
        }
        else {
            System.out.println("Error: value should be less than 10^6");
        }
    }

    public void deQueue() {
        if (isEmpty() == -1) {
            System.out.println("Queue is empty");
        } else {
            int removedValue = queueArray.removeFirst();
            System.out.println("Removed value is " + removedValue);
            System.out.println("Queue array after removing " + removedValue + " is " + queueArray);
        }
    }

    public void peek() {
        if (isEmpty() == -1) {
            System.out.println("-1");
        } else {
            System.out.println("First element is " + queueArray.getFirst());
        }
    }

    public void tail() {
        if (isEmpty() == -1) {
            System.out.println("-1");
        } else {
            System.out.println("Last element is " + queueArray.getLast());
        }
    }

}
