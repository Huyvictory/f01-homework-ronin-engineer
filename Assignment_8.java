import Assignment8.Bai1.WorkForceManagement;
import Utils.InputUtils;

import java.util.Scanner;

public class Assignment_8 {
    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        Scanner scanner = new Scanner(System.in);
        WorkForceManagement workForceManagement = new WorkForceManagement();
        while (true) {
            workForceManagement.DisplayCommands();
            int choice = InputUtils.InputValidIntegerNumber(scanner, "choice: ");

            switch (choice) {
                case 1: {
                    workForceManagement.CreateNewWorkPeople();
                    break;
                }
                case 2: {
                    workForceManagement.FindWorkPeopleByName();
                    break;
                }
                case 3: {
                    workForceManagement.DisplayWorkForce(workForceManagement.workForce);
                    break;
                }
                case 4: {
                    System.out.println("Exited successfully");
                    return;
                }
                default: {
                    System.out.println("Wrong input, please try again");
                    break;
                }
            }
        }
    }
}
