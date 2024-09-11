import Assignment8.Bai1.WorkForceManagement;
import Assignment8.Bai2.DocumentManagement;
import Assignment8.Bai3.HomeUsage;
import Assignment8.Bai3.ReceiptElectricity;
import Assignment8.Bai4.Enums.Gender;
import Assignment8.Bai4.FairStudent;
import Assignment8.Bai4.GoodStudent;
import Utils.InputUtils;

import java.util.Date;
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

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");
        System.out.println();

        //Bai 4
        System.out.println("*****************************************");
        Bai4();
        System.out.println("*****************************************");
        System.out.println("*****************************************");
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

    private static void Bai3() {
        System.out.println("Create a new HomeUsage object");
        HomeUsage homeUsage = new HomeUsage("Home 1", 1, "123456789");
        homeUsage.PrintDetails();

        // Update the HomeUsage object
        System.out.println("Update the HomeUsage object");
        homeUsage.UpdateHomeUsage("Home 2", 2, "987654321");
        homeUsage.PrintDetails();

        // Delete the HomeUsage object
        System.out.println("Delete the HomeUsage object");
        homeUsage.DeleteHomeUsage();
        homeUsage.PrintDetails();

        HomeUsage homeUsageForReceipt = new HomeUsage("Home 3", 3, "12345678910");

        System.out.println("Create a new ReceiptElectricity object");
        ReceiptElectricity receiptElectricity = new ReceiptElectricity(homeUsageForReceipt, 100, 200);
        receiptElectricity.getHomeUsage().PrintDetails();

        receiptElectricity.CalculateMoneySpent();
    }

    private static void Bai4() {
        GoodStudent goodStudent = new GoodStudent("Good Student", new Date(2021, 1, 1), Gender.MALE, "123456789", "University 1", "Grade 1");
        goodStudent.ShowMyInfo();

        goodStudent.SetGPA();
        goodStudent.SetBestRewardName();
        goodStudent.getGPA();
        goodStudent.getBestRewardName();

        goodStudent.setGPA(6);
        goodStudent.setBestRewardName("Best Reward Name 2");
        goodStudent.getGPA();
        goodStudent.getBestRewardName();

        FairStudent fairStudent = new FairStudent("Fair Student", new Date(2021, 1, 1), Gender.MALE, "123456789", "University 1", "Grade 1");
        fairStudent.ShowMyInfo();
        fairStudent.SetEnglishScore();
        fairStudent.SetEntryTestScore();
        fairStudent.GetEnglishScore();
        fairStudent.GetEntryTestScore();

        fairStudent.setEnglishScore(8);
        fairStudent.SetEntryTestScore(9);
        fairStudent.GetEnglishScore();
        fairStudent.GetEntryTestScore();
    }
}
