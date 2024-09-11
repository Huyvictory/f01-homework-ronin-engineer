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
        System.out.println("*****************************************");
        System.out.println();

        // Bai 8
        System.out.println("*****************************************");
        Bai8();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 9
        System.out.println("*****************************************");
        Bai9();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 10
        System.out.println("*****************************************");
        Bai10();
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

    private static void Bai5() {
        String inputString = "978013213079";
        int totalDigit13 = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (i % 2 == 0) {
                totalDigit13 += Integer.parseInt(String.valueOf(currentChar));
            } else {
                totalDigit13 += Integer.parseInt(String.valueOf(currentChar)) * 3;
            }
        }

        int checkSum = Math.abs(10 - totalDigit13 % 10);

        if (checkSum == 10) {
            inputString += '0';
        } else {
            inputString += checkSum;
        }

        System.out.println(inputString);
    }

    private static void Bai6() {
        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        arrayNumbers.add(1);
        arrayNumbers.add(2);
        arrayNumbers.add(3);
        arrayNumbers.add(5);
        arrayNumbers.add(5);

        int firstMax = 0;
        for (int number : arrayNumbers) {
            if (number > firstMax) {
                firstMax = number;
            }
        }

        int secondMax = 0;
        for (int number : arrayNumbers) {
            if (number > secondMax && number < firstMax) {
                secondMax = number;
            }
        }

        System.out.println("The first max is " + firstMax);
        System.out.println("The second max is " + secondMax);
    }

    // fibonacci calculation
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void Bai7() {
        Scanner scanner7 = new Scanner(System.in);
        int n = InputUtils.InputValidIntegerNumber(scanner7, "n");

        System.out.println("Fibonacci number " + n + " is " + fibonacci(n));
    }

    // Check if a number is a perfect square number
    private static boolean isPerfectSquareNumber(int number) {
        return Math.sqrt(number) % 1 == 0;
    }

    private static void Bai8() {
        Scanner scanner8 = new Scanner(System.in);
        int n = InputUtils.InputValidIntegerNumber(scanner8, "n");

        System.out.println("Perfect square numbers that are less than " + n + " are: ");
        for (int i = 1; i < n; i++) {
            if (isPerfectSquareNumber(i)) {
                System.out.printf("%d ", i);
            }
        }
    }

    private static void Bai9() {
        double piNumber = 0.0;
        int i = InputUtils.InputValidIntegerNumber(new Scanner(System.in), "i");

        for (int j = 1; j <= i; j++) {
            piNumber += Math.pow(-1, j + 1) / (double) (2 * j - 1);
        }

        System.out.println("The pi is " + piNumber * 4);
    }

    private static void Bai10() {
        String inputString = "ab@#AB69C!}+21";

        StringBuilder stringNumber = new StringBuilder();
        StringBuilder stringLetter = new StringBuilder();
        StringBuilder stringSymbol = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar)) {
                stringNumber.append(currentChar);
            } else if (Character.isLetter(currentChar)) {
                stringLetter.append(currentChar);
            } else {
                stringSymbol.append(currentChar);
            }
        }

        System.out.println("The string number is " + stringNumber);
        System.out.println("The string letter is " + stringLetter);
        System.out.println("The string symbol is " + stringSymbol);
    }
}
