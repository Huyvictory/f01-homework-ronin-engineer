import Assignment11.DoublyLinkedList;
import Assignment11.QueueCustom;
import Assignment11.SinglyLinkedList;
import Assignment11.StackCustom;
import Utils.InputUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment_11 {
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
    }

    private static void Bai1() {
        ArrayList<Integer[]> pascalTriangleRows = new ArrayList<Integer[]>();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the number of rows of the pascal triangle: ");
        int numberOfRows = InputUtils.InputValidIntegerNumber(scanner1, "numberOfRows");

        for (int i = 1; i <= numberOfRows; i++) {
            Integer[] rowElements = new Integer[i];

            rowElements[0] = 1;
            rowElements[rowElements.length - 1] = 1;

            if (pascalTriangleRows.size() <= 2 && i <= 2) {
                pascalTriangleRows.add(rowElements);
                continue;
            }
            Integer[] previousRow = pascalTriangleRows.get(i - 2);

            var sumElementsPreviousRow = new ArrayList<Integer>();

            // Find sum of the previous row
            for (int j = 0; j < previousRow.length; j++) {
                if (j == previousRow.length - 1) {
                    break;
                }
                Integer sum = previousRow[j] + previousRow[j + 1];
                sumElementsPreviousRow.add(sum);
            }

            // Update the row elements with the sum of the previous row
            for (int k = 0; k < sumElementsPreviousRow.size(); k++) {
                rowElements[k + 1] = sumElementsPreviousRow.get(k);
            }
            pascalTriangleRows.add(rowElements);

        }

        // Print the pascal triangle

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < pascalTriangleRows.size(); i++) {
            sb.append(Arrays.toString(pascalTriangleRows.get(i)));
            if (i < pascalTriangleRows.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println("Pascal triangle: " + sb);
    }

    private static void StringArrayPlusOne(int[] number) {
        String stringBuilderResult = getStringFromArrayNumbers(number);
        int[] arrayResult = new int[stringBuilderResult.length()];

        for (int i = 0; i < arrayResult.length; i++) {
            try {
                arrayResult[i] = Integer.parseInt(String.valueOf(stringBuilderResult.charAt(i)));
            } catch (Exception e) {
                System.err.println("Error parsing string to integer: " + arrayResult[i]);
            }
        }

        System.out.println(Arrays.toString(arrayResult));
    }

    private static String getStringFromArrayNumbers(int[] number) {
        StringBuilder stringInput = new StringBuilder();
        for (int j : number) {
            stringInput.append(j);
        }

        var numberInputFromArray = Integer.parseInt(stringInput.toString()) + 1;

        StringBuilder sbResult = new StringBuilder();

        String stringResult = String.valueOf(numberInputFromArray);

        // Find the first non-zero digit
        for (int i = 0; i < stringResult.length(); i++) {
            if (stringResult.charAt(i) != '0') {
                sbResult.append(stringResult.substring(i));
                break;
            }
        }

        return sbResult.toString();
    }

    private static void Bai2() {
        int[] testCase1 = {0, 1, 2, 3};
        StringArrayPlusOne(testCase1);

        int[] testCase2 = {4, 3, 2, 1};
        StringArrayPlusOne(testCase2);

        int[] testCase3 = {9};
        StringArrayPlusOne(testCase3);

        int[] testCase4 = {9, 9};
        StringArrayPlusOne(testCase4);
    }

    private static void Bai3() {
        StackCustom stackCustom = new StackCustom();

        stackCustom.init();
        stackCustom.push(1);
        System.out.println(stackCustom.isEmpty());
        stackCustom.push(2);
        stackCustom.push(3);
        stackCustom.push(4);
        stackCustom.push(5);
        stackCustom.push(1000000002);
        System.out.println(stackCustom.size());
        System.out.println(stackCustom.top());
        System.out.println(stackCustom.pop());
        System.out.println(stackCustom.size());
        System.out.println(stackCustom.top());
        stackCustom.end();
    }

}
