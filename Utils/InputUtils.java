package Utils;

import java.util.Scanner;

public class InputUtils {
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
}
