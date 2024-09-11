import Assignment8.Bai1.WorkForceManagement;
import Assignment8.Bai2.DocumentManagement;
import Utils.InputUtils;

import java.util.Scanner;

public class Assignment_8 {
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

    private static void Bai2() {
        Scanner scanner = new Scanner(System.in);
        DocumentManagement documentManagement = new DocumentManagement();
        while (true) {
            System.out.println("Please enter the choice: ");
            documentManagement.DisplayCommands();
            int choice = InputUtils.InputValidIntegerNumber(scanner, "choice: ");

            switch (choice) {
                case 1:
                    documentManagement.CreateNewDocument();
                    break;
                case 2:
                    documentManagement.DeleteDocumentById();
                    break;
                case 3:
                    documentManagement.DisplayDocuments(documentManagement.documentList);
                    break;
                case 4:
                    documentManagement.FindDocumentByType();
                    break;
                case 5:
                    System.out.println("Exited successfully");
                    return;
                default:
                    System.out.println("Wrong input, please try again");
                    break;
            }
        }
    }
}
