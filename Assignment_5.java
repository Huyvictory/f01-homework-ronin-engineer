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

        // Bai 4
        System.out.println("*****************************************");
        Bai4();
        System.out.println("*****************************************");
        System.out.println();

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

    private static void extractElements3DArrayToFile(int[][][] arrayX, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[][] SubArrayY : arrayX) {
                for (int[] SubArrayZ : SubArrayY) {
                    for (int i : SubArrayZ) {
                        // Separate elements in a z dimension
                        writer.write(i + " ");
                    }

                    // New line for subArray dimension y
                    writer.write("\n");
                }

                // New line after each y for x dimension
                writer.write("\n");
            }
        }
    }

    private static void Bai4() {

        int[][][] threeDimensionalArray = {
                {{1, 2, 3}, {4, 5, 6}},
                {{7, 8, 9}, {10, 11, 12}}
        };

        String currentUserProjectDirectory = System.getProperty("user.dir");
        String filePath = currentUserProjectDirectory + "\\src\\3dArrayElements.txt";

        try {
            extractElements3DArrayToFile(threeDimensionalArray, filePath);
            System.out.println("Elements extracted to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void OutputFile(String filePath, String content) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.write(content);
            System.out.println("Result extracted to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void Bai5() {
        String currentUserProjectDirectory = System.getProperty("user.dir");
        String filePath = currentUserProjectDirectory + "\\src\\numbers.txt";

        try {
            Scanner scanner5 = new Scanner(new File(filePath));
            int sum = 0;

            // Check for data in the file and read, sum it
            while (scanner5.hasNext()) {

                sum += Integer.parseInt(scanner5.next());
            }

            String filePathResult = currentUserProjectDirectory + "\\src\\result.txt";
            OutputFile(filePathResult, "Sum of the numbers in the file is " + sum);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    private static void Bai6() {
        int[] arrayNumbers = {1, 2, 3, 2, 1};

        int left = 0;
        int right = arrayNumbers.length - 1;

        while (left < right) {
            if (arrayNumbers[left] != arrayNumbers[right]) {
                System.out.println("NO");
                return;
            }

            left++;
            right--;
        }

        System.out.println("YES");
    }

}

