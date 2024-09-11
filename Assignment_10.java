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

}
