
import Utils.InputUtils;

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

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 4
        System.out.println("*****************************************");
        Bai4();
        System.out.println("*****************************************");
        System.out.println("*****************************************");

        // Bai 5
        System.out.println("*****************************************");
        Bai5();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 6
        System.out.println("*****************************************");
        Bai6();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 7
        System.out.println("*****************************************");
        Bai7();
        System.out.println("******************************************");
        System.out.println();

        // Bai 8
        System.out.println("*****************************************");
        Bai8();
        System.out.println("******************************************");
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

    private static void Bai3() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(3);
        arrayList2.add(4);
        arrayList2.add(5);

        ArrayList<Integer> mergedList = new ArrayList<>(arrayList1);
        mergedList.addAll(arrayList2);

        System.out.println(mergedList);

        // sort merged list using selection sort
        for (int i = 0; i < mergedList.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < mergedList.size(); j++) {
                if (mergedList.get(j) < mergedList.get(minIndex)) {
                    minIndex = j;
                }
            }

            int temp = mergedList.get(i);
            mergedList.set(i, mergedList.get(minIndex));
            mergedList.set(minIndex, temp);
        }

        System.out.println(mergedList);
    }

    private static void Bai4() {
        Scanner scanner4 = new Scanner(System.in);

        int n = InputUtils.InputValidIntegerNumber(scanner4, " n: ");

        int arrayNumbers[] = new int[n];
        for (int i = 0; i < n; i++) {

            arrayNumbers[i] = InputUtils.InputValidIntegerNumber(scanner4, "Enter valid integer number " + (i + 1) + ": ");
        }

        int k = InputUtils.InputValidIntegerNumber(scanner4, "Enter valid integer number k: ");

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

        System.out.println(Arrays.toString(arrayNumbers));

        int count = 0;

        //Element at k element
        int elementAtK = arrayNumbers[k - 1];

        // find duplicate of element k and update its index
        for (int i = k; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] == elementAtK) {
                elementAtK = k;
                break;
            }
        }

        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] <= elementAtK) {
                count++;
            }

            if (count == k) {
                System.out.println(arrayNumbers[i]);
                return;
            }
        }

        System.out.println("-1");
    }

    private static void Bai5() {
        Scanner scanner5 = new Scanner(System.in);
        // Read input (N and the array of customer notes)
        int n = InputUtils.InputValidIntegerNumber(scanner5, " n: ");

        int[] customerNotes = new int[n];

        for (int i = 0; i < n; i++) {
            customerNotes[i] = InputUtils.InputValidIntegerNumber(scanner5, "Enter note of customer " + (i + 1) + ": ");
        }

        // Change for 25k note
        int change25 = 0;

        // Change for 50k note
        int change50 = 0;

        for (int i = 0; i < n; i++) {
            int note = customerNotes[i];

            // Customer gave note exact for the ticket price
            if (note == 25) {
                change25++;
            }

            // Customer gave note that is double of the ticket price then give change for customer with a 25k note
            else if (note == 50) {
                if (change25 > 0) {
                    change25--;
                    change50++;
                } else {
                    System.out.println("NO");
                    return;
                }
            }

            // Customer gave note that is quadruple of the ticket price
            else if (note == 100) {

                // Give change back for customer with total of 75k
                if (change50 > 0 && change25 > 0) {
                    change50--;
                    change25--;
                } else if (change25 >= 3) {
                    change25 -= 3;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    private static void Bai6() {
        Scanner scanner6 = new Scanner(System.in);


        // Input amount of height that snail can climb per day
        int a = InputUtils.InputValidIntegerNumber(scanner6, "amount of height that snail can climb per day");

        // Input amount of height that snail drops per day after a sleep night
        int b = InputUtils.InputValidIntegerNumber(scanner6, "amount of height that snail drops per day after a sleep night");

        // Input height of the pole that snail has to climb
        int v = InputUtils.InputValidIntegerNumber(scanner6, "height of the pole");

        int daysReachToTheTop = 1;
        int heightClimbed = 0;

        while (heightClimbed < v) {
            heightClimbed += a;

            // reach to the top then stop climbing
            if (heightClimbed >= v) {
                break;
            }

            daysReachToTheTop++;
            heightClimbed -= b;
        }

        System.out.println("The snail climbed " + daysReachToTheTop + " days");
    }

    private static void Bai7() {
        Scanner scanner7 = new Scanner(System.in);

        // Input numbers of red shoe
        int redShoe = InputUtils.InputValidIntegerNumber(scanner7, "red shoe");

        // Input numbers of blue shoe
        int blueShoe = InputUtils.InputValidIntegerNumber(scanner7, "blue shoe");

        int numberOfDaysWearingPairDifferentColor = 0;
        int numberOfDaysWearingPairSameColor = 0;

        // Find the number of days that the bear wears pair shoes that are different color
        while (redShoe != 0 && blueShoe != 0) {

            // Every day the pair shoes wears needs to be different color
            redShoe--;
            blueShoe--;
            numberOfDaysWearingPairDifferentColor++;
        }

        // Find the number of days that the bear wears pair shoes that are same color
        while (redShoe != 0) {
            // Every day the pair shoes wears needs to be same color
            if (redShoe >= 2) {
                redShoe -= 2;
                numberOfDaysWearingPairSameColor++;
            } else {
                break;
            }
        }

        while (blueShoe != 0) {
            // Every day the pair shoes wears needs to be same color
            if (blueShoe >= 2) {
                blueShoe -= 2;
                numberOfDaysWearingPairSameColor++;
            } else {
                break;
            }
        }

        System.out.println("The bear wears pair shoes that are different color for " + numberOfDaysWearingPairDifferentColor + " days");
        System.out.println("The bear wears pair shoes that are same color for " + numberOfDaysWearingPairSameColor + " days");
    }

    private static void Bai8() {
        Scanner scanner8 = new Scanner(System.in);


        int[] arrayCrayonsBought = new int[]{
                1, 7, 3, 3
        };

        // sort array using bubble sort
        for (int i = 0; i < arrayCrayonsBought.length; i++) {
            for (int j = 0; j < arrayCrayonsBought.length - 1; j++) {
                if (arrayCrayonsBought[j] > arrayCrayonsBought[j + 1]) {
                    int temp = arrayCrayonsBought[j];
                    arrayCrayonsBought[j] = arrayCrayonsBought[j + 1];
                    arrayCrayonsBought[j + 1] = temp;
                }
            }
        }

        // find occurrences of each crayon
        HashMap<Integer, Integer> mapCrayons = new HashMap<>();
        for (int i = 0; i < arrayCrayonsBought.length; i++) {
            if (mapCrayons.containsKey(arrayCrayonsBought[i])) {
                mapCrayons.put(arrayCrayonsBought[i], mapCrayons.get(arrayCrayonsBought[i]) + 1);
            } else {
                mapCrayons.put(arrayCrayonsBought[i], 1);
            }
        }

        // Get the crayons that has the occurrences more than 1
        ArrayList<Integer> arrayListDuplicatedCrayons = new ArrayList<>();

        for (int crayon : mapCrayons.keySet()) {
            if (mapCrayons.get(crayon) > 1) {
                arrayListDuplicatedCrayons.add(mapCrayons.get(crayon));
            }
        }

        // Find number of crayons that the mother has to buy again
        int numberOfCrayonsToBuyAgain = 0;
        for (int crayon : arrayListDuplicatedCrayons) {
            numberOfCrayonsToBuyAgain += crayon - 1;
        }

        System.out.println("Number of crayons that the mother has to buy again: " + numberOfCrayonsToBuyAgain);
    }
}

