package Assignment8.Bai1;


import Assignment8.Bai1.Enums.Gender;
import Assignment8.Bai1.Enums.TypeOfWorkPeople;
import Utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkForceManagement {
    public ArrayList<WorkPeople> workForce = new ArrayList<>();




    public void CreateNewWorkPeople() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the full name of the new work people: ");
        String fullName = scanner.next();
        System.out.println("Please enter the age of the new work people: ");
        int age = scanner.nextInt();

        String gender;
        Gender genderType;
        while (true) {
            try {
                DisplaySex();
                System.out.println("Please enter the gender of the new work people: ");
                gender = scanner.next();
                genderType = Gender.valueOf(gender);
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again");
            }
        }
        System.out.println("Please enter the address of the new work people: ");
        String address = scanner.next();


        String typeOfWorkPeople;
        TypeOfWorkPeople typeOfWorkPeopleType;

        while (true) {
            try {
                DisplayTypeOfWorkPeople();
                System.out.println("Please enter the type of the new work people: ");
                typeOfWorkPeople = scanner.next();

                typeOfWorkPeopleType = TypeOfWorkPeople.valueOf(typeOfWorkPeople);
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again");
            }
        }

        WorkPeople workPeople = null;

        switch (typeOfWorkPeopleType) {
            case WORKER: {
                int level = InputUtils.InputValidIntegerNumber(scanner, "level of the worker: ");
                while (level < 1 || level > 10) {
                    System.out.println("Wrong input, please try again");
                    level = InputUtils.InputValidIntegerNumber(scanner, "level of the worker: ");
                    if (level >= 1 && level <= 10) {
                        break;
                    }
                }
                workPeople = new Worker(fullName, age, genderType, address, level);
                break;
            }
            case ENGINEER: {
                System.out.println("Please enter the faculty job of the engineer: ");
                String FacultyJob = scanner.next();
                workPeople = new Engineer(fullName, age, genderType, address, FacultyJob);
                break;
            }
            case EMPLOYEE: {
                System.out.println("Please enter the job of the employee: ");
                String Job = scanner.next();
                workPeople = new Employee(fullName, age, genderType, address, Job);
                break;
            }
        }

        workForce.add(workPeople);
    }

    public void DisplayTypeOfWorkPeople() {
        System.out.println("-----------------------");
        System.out.println("1. WORKER");
        System.out.println("2. ENGINEER");
        System.out.println("3. EMPLOYEE");
        System.out.println("-----------------------");
    }

    public void DisplaySex() {
        System.out.println("-----------------------");
        System.out.println("1. MALE");
        System.out.println("2. FEMALE");
        System.out.println("3. OTHER");
        System.out.println("-----------------------");
    }

    public void DisplayCommands() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1. Create a new WorkPeople added into workforce list");
        System.out.println("2. Find the WorkPeople by name");
        System.out.println("3. Show list of workpeople based on certain criteria");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void FindWorkPeopleByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the work people: ");
        String name = scanner.nextLine();
        ArrayList<WorkPeople> foundedWorkPeople = new ArrayList<>();

        if (workForce.isEmpty()) {
            System.out.println("Work force is empty");
            return;
        }

        for (WorkPeople workPeople : workForce) {
            if (workPeople.getFullName().contains(name)) {
                foundedWorkPeople.add(workPeople);
            }
        }

        System.out.println("Founded work people: ");
        DisplayWorkForce(foundedWorkPeople);
    }

    public void DisplayWorkForce(ArrayList<WorkPeople> workForce) {
        for (WorkPeople workPeople : workForce) {
            workPeople.PrintDetails();
        }
    }
}
