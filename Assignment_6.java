
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment_6 {
    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("*****************************************");
        System.out.println();

    }

    private static void Bai1() {
        int[] arrayNumbers = {10, 5, 3, 4, 4, 3, 5, 6, 6, 10, 10};

        // sort array using insertion sort ascending
        for (int i = 1; i < arrayNumbers.length; i++) {
            // get current element of i
            int currentElement = arrayNumbers[i];

            // pointer k move backward when compared to current element at index i
            int k = i - 1;

            // move backward while compared to current element at index i
            while (k >= 0 && arrayNumbers[k] > currentElement) {
                arrayNumbers[k + 1] = arrayNumbers[k];
                k--;
            }

            // move current element to first index k
            arrayNumbers[k + 1] = currentElement;
        }

        for (int number : arrayNumbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        for (int i = 0; i < arrayNumbers.length; i++) {
            int countNumber = 1;

            for (int j = i + 1; j < arrayNumbers.length; j++) {
                if (arrayNumbers[i] == arrayNumbers[j]) {
                    countNumber++;
                } else if (arrayNumbers[j] > arrayNumbers[i]) {
                    System.out.println(arrayNumbers[i] + " appears " + countNumber + " times");

                    // for case last number that doesn't repeat itself
                    if (j == arrayNumbers.length - 1) {
                        System.out.println(arrayNumbers[j] + " appears " + 1 + " times");
                    }
                    i = j - 1;
                    break;
                }

                // for case last number which repeats itself
                if (j == arrayNumbers.length - 1) {
                    System.out.println(arrayNumbers[j] + " appears " + countNumber + " times");
                    i = j;
                }
            }
        }
    }

    private static void Bai2() {
        int[] arrayNumbers = {9, 7, 12, 8, 6, 5};


        // sort array using bubble sort
        for (int i = 0; i < arrayNumbers.length; i++) {
            for (int j = 0; j < arrayNumbers.length - 1; j++) {
                if (arrayNumbers[j] > arrayNumbers[j + 1]) {
                    int temp = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[j + 1];
                    arrayNumbers[j + 1] = temp;
                }
            }
        }

        int minNumber = arrayNumbers[0];
        int secondMinNumber = 0;
        int maxNumber = arrayNumbers[arrayNumbers.length - 1];
        int secondMaxNumber = 0;

        // find second min number
        for (int i = 1; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] > minNumber) {
                secondMinNumber = arrayNumbers[i];
                break;
            }
        }

        // find second max number
        for (int i = arrayNumbers.length - 2; i >= 0; i--) {
            if (arrayNumbers[i] < maxNumber) {
                secondMaxNumber = arrayNumbers[i];
                break;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(maxNumber);
        arrayList.add(minNumber);
        arrayList.add(secondMaxNumber);
        arrayList.add(secondMinNumber);

        // find numbers in array that are not in arrayList
        for (int i = arrayNumbers.length - 1; i >= 0; i--) {
            if (!arrayList.contains(arrayNumbers[i])) {
                arrayList.add(arrayNumbers[i]);
            }
        }

        System.out.println(Arrays.toString(arrayList.toArray()));
    }

}

