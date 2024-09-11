import Utils.InputUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Assignment_5 {
    public static void main(String[] args) throws FileNotFoundException {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        int foundedIndex = Bai2();
        System.out.printf("The founded index is %d\n", foundedIndex);
        System.out.println("*****************************************");
        System.out.println();

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        int[] arrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = 0;
        for (int number : arrayNumbers) {
            sum += number;
        }

        System.out.println("The sum of the array is " + sum);
    }

    private static int Bai2() {
        Scanner scanner = new Scanner(System.in);
        int[] arrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int n = InputUtils.InputValidIntegerNumber(scanner, "n");

        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] == n) {
                return i;
            }
        }
        return -1;

    }

    private static void Bai3() {
        int[][] array2D = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int maxNumber = 0;

        for (int[] subArray : array2D) {
            for (int number : subArray) {
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
        }

        System.out.println("The max number in the matrix is " + maxNumber);
    }

}

