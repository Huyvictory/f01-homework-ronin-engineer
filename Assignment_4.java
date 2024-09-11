import Utils.InputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment_4 {
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
        System.out.println();

    }

    private static void Bai1() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter a integer n from 1 => 15");
        int n = scanner1.nextInt();

        // Traverse for every row in the expected triangle result
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.printf("%d ", j);
            }

            for (int k = 2; k <= i; k++) {
                System.out.printf("%d ", k);
            }
            System.out.println();
        }
    }

    private static void Bai2() {
        String inputString = "Programming is fun";
        // Vowels array list

        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int numberOfVowels = 0;
        int numberOfConsonants = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            if (vowels.contains(currentChar)) {
                numberOfVowels++;
            } else {
                numberOfConsonants++;
            }
        }

        System.out.println("The number of vowels is " + numberOfVowels);
        System.out.println("The number of consonants is " + numberOfConsonants);
    }

    private static void Bai3() {
        Scanner scanner3 = new Scanner(System.in);

        int n = InputUtils.InputValidIntegerNumber(scanner3, "n");

        // Shape A
        System.out.println("Shape A");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Shape B
        System.out.println("Shape B");
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Shape C
        System.out.println("Shape C");
        for (int i = n; i >= 1; i--) {
            boolean printStar = false;
            for (int j = 1; j <= n; j++) {
                if (j == i) {
                    printStar = true;
                }
                if (printStar) {
                    System.out.print("* ");
                } else {
                    System.out.print("a ");
                }
            }
            System.out.println();
        }

        // Shape D
        System.out.println("Shape D");
        for (int i = 1; i <= n; i++) {
            boolean printStar = false;
            for (int j = 1; j <= n; j++) {

                if (j == i) {
                    printStar = true;
                }

                if (printStar) {
                    System.out.print("* ");
                } else {
                    System.out.print("a ");
                }
            }
            System.out.println();
        }
    }

    private static void Bai4() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d : %d = %d\n", (i * j), i, ((i * j) / i));
            }
            System.out.println();
        }
    }
}
