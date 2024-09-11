import java.util.Scanner;

public class Assignment_3 {
    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("******************************************");
        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("******************************************");
        System.out.println();

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("******************************************");
        System.out.println();

        // Bai 4
        System.out.println("*****************************************");
        Bai4();
        System.out.println("******************************************");
        System.out.println();

        // Bai 5
        System.out.println("*****************************************");
        Bai5();
        System.out.println("******************************************");

        System.out.println();

    }

    private static void Bai1() {
        String stringVariable = "Hello World";
        System.out.println(stringVariable);
    }

    public static int InputValidIntegerNumber(Scanner scanner, String nameVariable) {
        int intVariable;
        System.out.println("Enter an integer " + nameVariable);
        do {
            String userInput = scanner.next();

            try {
                intVariable = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input please enter a valid integer number");
            }

        } while (true);

        return intVariable;
    }

    private static void Bai2() {
        int intVariable;

        Scanner scanner = new Scanner(System.in);
        intVariable = InputValidIntegerNumber(scanner, "number");

        System.out.println("You entered: " + intVariable);

        // For positive numbers
        if (intVariable > 0 && intVariable % 2 == 0) {
            System.out.println("The number is positive and even");
        }
        if (intVariable > 0 && intVariable % 2 != 0) {
            System.out.println("The number is positive and odd");
        }

        // For negative numbers
        if (intVariable < 0 && intVariable % 2 == 0) {
            System.out.println("The number is negative and even");
        }
        if (intVariable < 0 && intVariable % 2 != 0) {
            System.out.println("The number is negative and odd");
        }
    }

    private static void Bai3() {
        Scanner scanner3 = new Scanner(System.in);
        int a = InputValidIntegerNumber(scanner3, "a");
        int b = InputValidIntegerNumber(scanner3, "b");

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println("a + b: " + (a + b));
        System.out.println("a - b: " + (a - b));
        System.out.println("a * b: " + (a * b));
        if (b != 0) {
            System.out.println("a / b: " + (double) a / b);
        }
    }

    private static void Bai4() {
        Scanner scanner4 = new Scanner(System.in);
        int a = InputValidIntegerNumber(scanner4, "a");
        int b = InputValidIntegerNumber(scanner4, "b");

        if (a > b) {
            System.out.println("a is greater than b");
        } else if (a < b) {
            System.out.println("a is less than b");
        } else {
            System.out.println("a is equal to b");
        }
    }

    private static void Bai5() {
        Scanner scanner5 = new Scanner(System.in);
        int a = InputValidIntegerNumber(scanner5, "a");
        int b = InputValidIntegerNumber(scanner5, "b");

        while (a < 0 || b < 0) {
            if (a < 0) {
                System.out.println("You entered a negative number for a");
                a = InputValidIntegerNumber(scanner5, "a");
            }
            if (b < 0) {
                System.out.println("You entered a negative number for b");
                b = InputValidIntegerNumber(scanner5, "b");
            }
        }

        System.out.println("Circumference of a rectangle is " + ((a + b) * 2));
        System.out.println("Area of a rectangle is " + (a * b));
    }

}
