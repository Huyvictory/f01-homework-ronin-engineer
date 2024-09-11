import Assignment10.Exceptions.InvalidAgeException;
import Utils.InputUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment_10 {
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

        //Bai 5
        System.out.println("*****************************************");
        try {
            Bai5();
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        Scanner scanner1 = new Scanner(System.in);
        try {
            int so1 = InputUtils.InputValidIntegerNumber(scanner1, "so1: ");
            int so2 = InputUtils.InputValidIntegerNumber(scanner1, "so2: ");

            int result = so1 / so2;

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }
    }

    private static int InputValidIntegerNumber(Scanner scanner, String nameVariable) throws Exception {
        int intVariable;
        System.out.println("Please enter an valid integer: " + nameVariable);
        do {
            String userInput = scanner.next();

            try {
                intVariable = Integer.parseInt(userInput);
                break;
            } catch (Exception e) {
                throw new Exception(userInput + " is an invalid input please enter a valid integer number");
            }

        } while (true);

        System.out.println("You entered integer: " + intVariable);
        return intVariable;
    }

    private static void Bai2() {
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            try {
                InputValidIntegerNumber(scanner2, "a");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void Bai3() {
        int result = 0;
        Object a = null, b = null;
        Scanner scanner3 = new Scanner(System.in);
        String messageException = "";
        while (result == 0) {
            try {
                if (a == null) a = InputValidIntegerNumber(scanner3, "a");
                if (b == null) b = InputValidIntegerNumber(scanner3, "b");

                result = Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
                messageException = "";

                System.out.println("a + b: " + result);

            } catch (Exception e) {
                messageException = e.getMessage();
            } finally {
                if (!messageException.isEmpty()) System.out.println(messageException);
            }
        }
    }

    private static void Bai4() {
        int[] arrayInteger = new int[3];
        Scanner scanner4 = new Scanner(System.in);

        try {
//            // Trigger array index out of bounds exception
//            arrayInteger[3] = 10;

            // Trigger input mismatch exception when input is not an integer
            for (int i = 0; i < arrayInteger.length; i++) {
                System.out.println("Enter an integer " + i);
                arrayInteger[i] = scanner4.nextInt();
            }

            System.out.println(Arrays.toString(arrayInteger));


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Bai5() throws InvalidAgeException {
        Scanner scanner5 = new Scanner(System.in);
        int age;
        age = InputUtils.InputValidIntegerNumber(scanner5, "age");
        if (age < 18) throw new InvalidAgeException();
        System.out.printf("You are %d years old\n", age);
    }
}
