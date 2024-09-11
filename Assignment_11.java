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

        //Bai 4
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

    private static void StringArrayPlusOne(int[] number) {
        String stringBuilderResult = getStringFromArrayNumbers(number);
        int[] arrayResult = new int[stringBuilderResult.length()];

        for (int i = 0; i < arrayResult.length; i++) {
            try {
                arrayResult[i] = Integer.parseInt(String.valueOf(stringBuilderResult.charAt(i)));
            } catch (Exception e) {
                System.err.println("Error parsing string to integer: " + arrayResult[i]);
            }
        }

        System.out.println(Arrays.toString(arrayResult));
    }

    private static String getStringFromArrayNumbers(int[] number) {
        StringBuilder stringInput = new StringBuilder();
        for (int j : number) {
            stringInput.append(j);
        }

        var numberInputFromArray = Integer.parseInt(stringInput.toString()) + 1;

        StringBuilder sbResult = new StringBuilder();

        String stringResult = String.valueOf(numberInputFromArray);

        // Find the first non-zero digit
        for (int i = 0; i < stringResult.length(); i++) {
            if (stringResult.charAt(i) != '0') {
                sbResult.append(stringResult.substring(i));
                break;
            }
        }

        return sbResult.toString();
    }

    private static void Bai2() {
        int[] testCase1 = {0, 1, 2, 3};
        StringArrayPlusOne(testCase1);

        int[] testCase2 = {4, 3, 2, 1};
        StringArrayPlusOne(testCase2);

        int[] testCase3 = {9};
        StringArrayPlusOne(testCase3);

        int[] testCase4 = {9, 9};
        StringArrayPlusOne(testCase4);
    }

    private static void Bai3() {
        StackCustom stackCustom = new StackCustom();

        stackCustom.init();
        stackCustom.push(1);
        System.out.println(stackCustom.isEmpty());
        stackCustom.push(2);
        stackCustom.push(3);
        stackCustom.push(4);
        stackCustom.push(5);
        stackCustom.push(1000000002);
        System.out.println(stackCustom.size());
        System.out.println(stackCustom.top());
        System.out.println(stackCustom.pop());
        System.out.println(stackCustom.size());
        System.out.println(stackCustom.top());
        stackCustom.end();
    }

    private static void Bai4() {
        QueueCustom queueCustom = new QueueCustom();

        queueCustom.init();
        System.out.printf("Is Queue empty: %s\n", queueCustom.isEmpty() == -1 ? "Yes" : "No");
        queueCustom.enQueue(1);
        queueCustom.enQueue(2);
        queueCustom.enQueue(3);
        queueCustom.enQueue(4);
        queueCustom.enQueue(5);
        queueCustom.enQueue(1000000002);
        System.out.println("Size: " + queueCustom.size());
        System.out.printf("Is Queue empty: %s\n", queueCustom.isEmpty() == -1 ? "Yes" : "No");
        queueCustom.deQueue();
        System.out.println(queueCustom.size());
        queueCustom.peek();
        queueCustom.tail();
    }

    private static void Bai5() {
        ArrayList<String> validInputs = new ArrayList<>();
        validInputs.add("()");
        validInputs.add("[]");
        validInputs.add("{}");

        String openSymbol = "({[";

        Stack<Character> stackOpenSymbols = new Stack<>();
        Stack<Character> stackCloseSymbols = new Stack<>();

        String testCase = "[()]{}{[()()]()}";

        for (char c : testCase.toCharArray()) {
            if (openSymbol.indexOf(c) != -1) {
                stackOpenSymbols.push(c);
            } else {
                stackCloseSymbols.push(c);
            }

            if (!stackOpenSymbols.isEmpty() && !stackCloseSymbols.isEmpty()) {
                String pairPattern = new String(new char[]{stackOpenSymbols.pop(), stackCloseSymbols.pop()});

                if (!validInputs.contains(pairPattern)) {
                    System.out.println("False");
                    return;
                }
            }
        }

        if (stackOpenSymbols.isEmpty() && stackCloseSymbols.isEmpty())
            System.out.println("True");
        else
            System.out.println("False");
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void Bai6() {
        // Read HTML file
        String currentUserProjectDirectory = System.getProperty("user.dir");
        String filePath = currentUserProjectDirectory + "\\src\\html_Assignment11.html";

        try {
            String htmlContent = readFile(filePath);

            Stack<String> stackOpenTags = new Stack<>();

            // Pattern to get closing and tag name
            Pattern tagPattern = Pattern.compile("<(/?)(\\w+)([^>]*)>");
            Matcher matches = tagPattern.matcher(htmlContent);

            String[] selfClosingTags = new String[]{"img", "br", "hr", "input", "link", "meta", "area", "base", "col", "command", "embed", "keygen", "param", "source", "track", "wbr"};

            while (matches.find()) {
                String isClosing = matches.group(1);
                String tagName = matches.group(2).toLowerCase();

                // Ignore self-closing tags
                if (Arrays.asList(selfClosingTags).contains(tagName)) {
                    continue;
                }

                // Open tag then push to stack
                if (isClosing.isEmpty()) {
                    stackOpenTags.push(tagName);
                } else {
                    // Meet close tag but no equivalent open tag or stack is empty then it's not a valid HTML file
                    if (stackOpenTags.isEmpty() || !stackOpenTags.pop().equals(tagName)) {
                        System.out.println("Not a valid HTML file");
                        return;
                    }
                }
            }

            System.out.println("Valid HTML file");

        } catch (Exception e) {
            System.err.println("Error reading file: " + filePath);
        }
    }

    public static String decimalToBinaryStack(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        Stack<Integer> stackRemainder = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stackRemainder.push(remainder);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stackRemainder.isEmpty()) {
            binary.append(stackRemainder.pop());
        }

        return binary.toString();
    }

    private static void Bai7() {
        int[] testNumbers = {0, 1, 2, 5, 10, 15, 20, 50, 100};

        for (int num : testNumbers) {
            System.out.println(num + " in binary: " + decimalToBinaryStack(num));
        }
    }
}
