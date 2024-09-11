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


}
