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

        // Bai 6
        System.out.println("*****************************************");
        try {
            Bai6();
        } catch (NumberFormatException e) {
            try {
                throw new NegativeNumberException(e.getMessage());
            } catch (NegativeNumberException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("*****************************************");
        System.out.println();

        // Bai 7
        System.out.println("*****************************************");
        Bai7();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 8
        System.out.println("*****************************************");
        try {
            Bai8();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
        try {
            int so1 = Assignment_3.InputValidIntegerNumber(scanner1, "so1: ");
            int so2 = Assignment_3.InputValidIntegerNumber(scanner1, "so2: ");

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

    private static int InputValidIntegerNumber(Scanner scanner) {
        int intVariable;
        System.out.println("Enter an integer ");
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

    private static class InvalidAgeException extends Exception {
        InvalidAgeException() {
            super("Age should not be less than 18");
        }
    }

    private static void Bai5() throws InvalidAgeException {
        Scanner scanner5 = new Scanner(System.in);
        int age;
        age = InputValidIntegerNumber(scanner5);
        if (age < 18) throw new InvalidAgeException();
        System.out.printf("You are %d years old\n", age);
    }

    private static class NegativeNumberException extends Exception {
        NegativeNumberException(String message) {
            super(message);
        }
    }

    private static void Bai6() {
        Scanner scanner6 = new Scanner(System.in);
        int a;
        a = InputValidIntegerNumber(scanner6);

        if (a < 0) throw new NumberFormatException("Number should not be negative");
    }

    private static void Bai7() {
        String currentUserProjectDirectory = System.getProperty("user.dir");
        String filePath = currentUserProjectDirectory + "\\src\\demoFile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void Bai8() throws IllegalArgumentException {
        Scanner scanner8 = new Scanner(System.in);
        int a = InputValidIntegerNumber(scanner8);

        if (a < 0) throw new IllegalArgumentException("Number should not be negative");

        System.out.println("Square root of " + a + " is " + Math.sqrt(a));
    }

    private static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String message) {
            super(message);
        }
    }

    private static class BankAccount {
        private int balance;

        public BankAccount(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) throws InsufficientFundsException {
            if (amount > balance)
                throw new InsufficientFundsException(amount + " is greater than balance " + balance);
            balance -= amount;
        }
    }

    private static void Bai9() {
        BankAccount account = new BankAccount(1000);
        System.out.println("Current account balance: " + account.getBalance());

        // Withdraw 100 from the account after that we will get insufficient funds exception
        try {
            account.withdraw(100);
            account.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Account balance after withdrawal: " + account.getBalance());
    }

    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) throws InfoStudentIncorrectException {
            this.name = name;
            this.age = age;

            //
            if (age < 0) throw new InfoStudentIncorrectException("Age should not be negative");
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        private void ShowStudentDetails() {
            System.out.println("//////////////////////////////////////////");
            System.out.println("Name: " + this.getName());
            System.out.println("Age: " + this.getAge());
            System.out.println("//////////////////////////////////////////");
        }
    }

    private static class EmptyListStudentsException extends Exception {
        EmptyListStudentsException(String message) {
            super(message);
        }
    }

    private static class InfoStudentIncorrectException extends Exception {
        InfoStudentIncorrectException(String message) {
            super(message);
        }
    }

    private static void Bai10() {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner10 = new Scanner(System.in);

        try {
//            // Trigger NullPointerException when after adding null object to the list
//            students.add(null);
//            students.getFirst().name.length();

            System.out.println("Enter the number of students: ");
            int numberOfStudents = InputValidIntegerNumber(scanner10);

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Enter name and age of student " + (i + 1));
                System.out.print("Enter name: ");
                String name = scanner10.next();
                int age = InputValidIntegerNumber(scanner10);
                students.add(new Student(name, age));
            }

//            // Trigger IndexOutOfBoundsException through the use of the remove method
//            students.remove(9999);

//            // Trigger EmptyListStudentsException
//            students.clear();

            // Full list of students
            System.out.println("List Students: ");
            for (Student student : students) {
                student.ShowStudentDetails();
            }

            // valid remove method
            students.removeFirst();

            if (students.isEmpty()) throw new EmptyListStudentsException("List is empty");

            System.out.println("List Students after removing: ");
            for (Student student : students) {
                student.ShowStudentDetails();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
