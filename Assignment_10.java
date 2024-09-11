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

}
