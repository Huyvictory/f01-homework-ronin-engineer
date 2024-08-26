import java.util.ArrayList;
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
        System.out.println("******************************************");

        System.out.println("******************************************");

        // Bai 4
        System.out.println("*****************************************");
        Bai4();
        System.out.println("******************************************");

        System.out.println();
    }


    // Classes for Bai 1
    enum Gender {
        MALE, FEMALE, OTHER
    }

    private static class WorkPeople {
        private final String FullName;
        private final int Age;
        private final Gender gender;
        private final String Address;

        public WorkPeople(String FullName, int Age, Gender gender, String Address) {
            this.FullName = FullName;
            this.Age = Age;
            this.gender = gender;
            this.Address = Address;
        }

        public void PrintDetails() {
            System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s\n", FullName, Age, gender, Address);
        }
    }

    private static class Worker extends WorkPeople {
        private final int Level;

        public Worker(String FullName, int Age, Gender gender, String Address, int level) {
            super(FullName, Age, gender, Address);
            Level = level;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Level: %d\n", super.FullName, super.Age, super.gender, super.Address, Level);
        }
    }

    private static class Engineer extends WorkPeople {
        private final String FacultyJob;

        public Engineer(String FullName, int Age, Gender gender, String Address, String FacultyJob) {
            super(FullName, Age, gender, Address);
            this.FacultyJob = FacultyJob;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Faculty Job: %s\n", super.FullName, super.Age, super.gender, super.Address, FacultyJob);
        }
    }

    private static class Employee extends WorkPeople {
        private final String Job;


        public Employee(String FullName, int Age, Gender gender, String Address, String Job) {
            super(FullName, Age, gender, Address);
            this.Job = Job;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Job: %s\n", super.FullName, super.Age, super.gender, super.Address, Job);
        }
    }

    private static class WorkForceManagement {
        ArrayList<WorkPeople> workForce = new ArrayList<>();

        enum TypeOfWorkPeople {
            WORKER, ENGINEER, EMPLOYEE
        }

        private void CreateNewWorkPeople() {
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
                    int level = Assignment_3.InputValidIntegerNumber(scanner, "level of the worker: ");
                    while (level < 1 || level > 10) {
                        System.out.println("Wrong input, please try again");
                        level = Assignment_3.InputValidIntegerNumber(scanner, "level of the worker: ");
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

        private void DisplayTypeOfWorkPeople() {
            System.out.println("-----------------------");
            System.out.println("1. WORKER");
            System.out.println("2. ENGINEER");
            System.out.println("3. EMPLOYEE");
            System.out.println("-----------------------");
        }

        private void DisplaySex() {
            System.out.println("-----------------------");
            System.out.println("1. MALE");
            System.out.println("2. FEMALE");
            System.out.println("3. OTHER");
            System.out.println("-----------------------");
        }

        private void DisplayCommands() {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1. Create a new WorkPeople added into workforce list");
            System.out.println("2. Find the WorkPeople by name");
            System.out.println("3. Show list of workpeople based on certain criteria");
            System.out.println("4. Exit");
            System.out.println("-------------------------------------------------------------------------------");
        }

        private void FindWorkPeopleByName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the name of the work people: ");
            String name = scanner.nextLine();
            ArrayList<WorkPeople> foundedWorkPeople = new ArrayList<>();

            if (workForce.isEmpty()) {
                System.out.println("Work force is empty");
                return;
            }

            for (WorkPeople workPeople : workForce) {
                if (workPeople.FullName.contains(name)) {
                    foundedWorkPeople.add(workPeople);
                }
            }

            System.out.println("Founded work people: ");
            DisplayWorkForce(foundedWorkPeople);
        }

        private void DisplayWorkForce(ArrayList<WorkPeople> workForce) {
            for (WorkPeople workPeople : workForce) {
                workPeople.PrintDetails();
            }
        }
    }

    private static void Bai1() {
        Scanner scanner = new Scanner(System.in);
        WorkForceManagement workForceManagement = new WorkForceManagement();
        while (true) {
            workForceManagement.DisplayCommands();
            int choice = Assignment_3.InputValidIntegerNumber(scanner, "choice: ");

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

    // Classes for Bai 2

    enum DocumentType {
        BOOK, JOURNAL, NEWSPAPER
    }

    public static class Document {
        private int id;
        private String PublisherName;
        private int AmountPublished;
        private DocumentType documentType;

        public Document(int id, String PublisherName, int AmountPublished, DocumentType documentType) {
            this.id = id;
            this.PublisherName = PublisherName;
            this.AmountPublished = AmountPublished;
            this.documentType = documentType;
        }

        public void PrintDetails() {
            System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d\n", id, PublisherName, AmountPublished);
        }
    }

    public static class Book extends Document {
        private String AuthorName;
        private int Pages;

        public Book(int id, String PublisherName, int AmountPublished, String AuthorName, int Pages) {
            super(id, PublisherName, AmountPublished, DocumentType.BOOK);
            this.AuthorName = AuthorName;
            this.Pages = Pages;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Author Name: %s, Pages: %d, Type: %s\n", super.id, super.PublisherName, super.AmountPublished, AuthorName, Pages, super.documentType);
        }
    }

    public static class Journal extends Document {
        private int NumberPublish;
        private Date monthPublish;


        public Journal(int id, String PublisherName, int AmountPublished, int NumberPublish, Date monthPublish) {
            super(id, PublisherName, AmountPublished, DocumentType.JOURNAL);
            this.NumberPublish = NumberPublish;
            this.monthPublish = monthPublish;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Number Publish: %d, Month Publish: %s, Type: %s\n", super.id, super.PublisherName, super.AmountPublished, NumberPublish, monthPublish.toString(), super.documentType);
        }
    }

    public static class Newspaper extends Document {
        private Date dayPublish;


        public Newspaper(int id, String PublisherName, int AmountPublished, Date dayPublish) {
            super(id, PublisherName, AmountPublished, DocumentType.NEWSPAPER);
            this.dayPublish = dayPublish;
        }

        @Override
        public void PrintDetails() {
            System.out.printf("ID: %d, Publisher Name: %s, Amount Published: %d, Day Publish: %s, Type: %s\n", super.id, super.PublisherName, super.AmountPublished, dayPublish.toString(), super.documentType);
        }
    }

    public static class DocumentManagement {
        ArrayList<Document> documentList = new ArrayList<>();

        private void DisplayDocumentTypes() {
            System.out.println("-----------------------");
            System.out.println("1. BOOK");
            System.out.println("2. JOURNAL");
            System.out.println("3. NEWSPAPER");
            System.out.println("-----------------------");
        }

        private void CreateNewDocument() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter the publisher name of the new document: ");
            String publisherName = scanner.next();
            System.out.println("Please enter the amount published of the new document: ");
            int amountPublished = scanner.nextInt();

            String documentType;
            DocumentType documentTypeType;
            while (true) {
                try {
                    DisplayDocumentTypes();
                    System.out.println("Please enter the type of the new document: ");
                    documentType = scanner.next();
                    documentTypeType = DocumentType.valueOf(documentType);
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input, please try again");
                }
            }


            switch (documentTypeType) {
                case BOOK: {
                    System.out.println("Please enter the author name of the book: ");
                    String authorName = scanner.next();
                    System.out.println("Please enter the pages of the book: ");
                    int pages = scanner.nextInt();


                    documentList.add(new Book(documentList.size() + 1, publisherName, amountPublished, authorName, pages));
                    break;
                }
                case JOURNAL: {
                    System.out.println("Please enter the number of the journal: ");
                    int numberPublish = scanner.nextInt();
                    System.out.println("Please enter the month of the journal: ");
                    Date monthPublish = new Date();
                    documentList.add(new Journal(documentList.size() + 1, publisherName, amountPublished, numberPublish, monthPublish));
                    break;
                }
                case NEWSPAPER: {
                    Date dayPublish = new Date();
                    documentList.add(new Newspaper(documentList.size() + 1, publisherName, amountPublished, dayPublish));
                    break;
                }
            }

            System.out.printf("%s added successfully", documentTypeType);
        }

        private void DisplayDocuments(ArrayList<Document> documents) {
            System.out.println("-----------------------");
            System.out.println("Documents:");
            for (Document document : documents) {
                document.PrintDetails();
            }
            System.out.println("-----------------------");
        }

        private void DeleteDocumentById() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the id of the document to be deleted: ");
            int id = scanner.nextInt();

            if (documentList.isEmpty()) {
                System.out.println("Document list is empty");
                return;
            }

            for (Document document : documentList) {
                if (document.id == id) {
                    documentList.remove(document);
                    break;
                }
            }

            System.out.printf("Document with id %d deleted successfully\n", id);
            DisplayDocuments(documentList);
        }

        private void FindDocumentByType() {
            Scanner scanner = new Scanner(System.in);
            DocumentType documentType;
            while (true) {
                try {
                    DisplayDocumentTypes();
                    System.out.println("Please enter the type of the document to be found: ");
                    String type = scanner.next();
                    documentType = DocumentType.valueOf(type);
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input, please try again");
                }
            }

            if (documentList.isEmpty()) {
                System.out.println("Document list is empty");
                return;
            }

            for (Document document : documentList) {
                if (document.documentType == documentType) {
                    document.PrintDetails();
                }
            }
        }

        private void DisplayCommands() {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1. Create a new document added into document list");
            System.out.println("2. Delete a document by id");
            System.out.println("3. Show list of documents");
            System.out.println("4. Find the document by type");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    private static void Bai2() {
        Scanner scanner = new Scanner(System.in);
        DocumentManagement documentManagement = new DocumentManagement();
        while (true) {
            System.out.println("Please enter the choice: ");
            documentManagement.DisplayCommands();
            int choice = Assignment_3.InputValidIntegerNumber(scanner, "choice: ");

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

    // Classes for Bai 3

    public static class HomeUsage {
        private String HomeName;
        private int HomeNumber;
        private String IdPowerTracker;

        public HomeUsage(String HomeName, int HomeNumber, String IdPowerTracker) {
            this.HomeName = HomeName;
            this.HomeNumber = HomeNumber;
            this.IdPowerTracker = IdPowerTracker;
        }

        public void UpdateHomeUsage(String HomeName, int HomeNumber, String IdPowerTracker) {
            this.HomeName = HomeName;
            this.HomeNumber = HomeNumber;
            this.IdPowerTracker = IdPowerTracker;
        }

        public void DeleteHomeUsage() {
            this.HomeName = null;
            this.HomeNumber = 0;
            this.IdPowerTracker = null;
        }

        public void PrintDetails() {
            System.out.printf("Home Name: %s, Home Number: %d, Id Power Tracker: %s\n", HomeName, HomeNumber, IdPowerTracker);
        }
    }

    public static class ReceiptElectricity {
        private final HomeUsage homeUsage;
        private final double OldElectricityCounter;
        private final double NewElectricityCounter;

        public ReceiptElectricity(HomeUsage homeUsage, double OldElectricityCounter, double NewElectricityCounter) {
            this.homeUsage = homeUsage;
            this.OldElectricityCounter = OldElectricityCounter;
            this.NewElectricityCounter = NewElectricityCounter;

        }

        public void CalculateMoneySpent() {
            double moneySpent = (this.NewElectricityCounter - this.OldElectricityCounter) * 5;
            System.out.printf("Money Spent: %.2f\n", moneySpent);
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
        receiptElectricity.homeUsage.PrintDetails();

        receiptElectricity.CalculateMoneySpent();
    }


    // Classes for Bai 4
    interface IStudent {
        void ShowMyInfo();
    }

    public static class BaseStudent implements IStudent {
        private String FullName;
        private Date Birthday;
        private Gender Gender;
        private String PhoneNumber;
        private String UniversityName;
        private String GradeLevel;

        public BaseStudent(String FullName, Date Birthday, Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel) {
            this.FullName = FullName;
            this.Birthday = new Date();
            this.Gender = Gender;
            this.PhoneNumber = PhoneNumber;
            this.UniversityName = UniversityName;
            this.GradeLevel = GradeLevel;
        }

        @Override
        public void ShowMyInfo() {
            System.out.printf("Full Name: %s, Birthday: %s, Gender: %s, Phone Number: %s, University Name: %s, Grade Level: %s\n", FullName, Birthday.toString(), Gender, PhoneNumber, UniversityName, GradeLevel);
        }
    }

    public static class GoodStudent extends BaseStudent {
        private int GPA;
        private String bestRewardName;

        public GoodStudent(String FullName, Date Birthday, Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel) {
            super(FullName, Birthday, Gender, PhoneNumber, UniversityName, GradeLevel);
        }

        public GoodStudent(String FullName, Date Birthday, Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel, int GPA, String bestRewardName) {
            super(FullName, Birthday, Gender, PhoneNumber, UniversityName, GradeLevel);
            this.GPA = GPA;
            this.bestRewardName = bestRewardName;
        }

        public void getGPA() {
            System.out.printf("GPA: %d\n", GPA);
        }

        public void setGPA(int GPA) {
            this.GPA = GPA;
        }

        public void SetGPA() {
            Scanner scanner = new Scanner(System.in);
            int GPA = Assignment_3.InputValidIntegerNumber(scanner, "GPA: ");
            while (GPA < 1 || GPA > 10) {
                System.out.println("Wrong input, please try again");
                GPA = Assignment_3.InputValidIntegerNumber(scanner, "GPA: ");

                if (GPA >= 1 && GPA <= 10) {
                    this.GPA = GPA;
                }
            }
        }

        public void getBestRewardName() {
            System.out.println("Best Reward Name: " + bestRewardName);
        }

        public void SetBestRewardName() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the best reward name: ");
            bestRewardName = scanner.nextLine();
        }

        public void setBestRewardName(String bestRewardName) {
            this.bestRewardName = bestRewardName;
        }

        @Override
        public void ShowMyInfo() {
            System.out.printf("Full Name: %s, Birthday: %s, Gender: %s, Phone Number: %s, University Name: %s, Grade Level: %s, GPA: %d, Best Reward Name: %s\n", super.FullName, super.Birthday.toString(), super.Gender, super.PhoneNumber, super.UniversityName, super.GradeLevel, GPA, bestRewardName);
        }
    }

    public static class FairStudent extends BaseStudent {
        private int EnglishScore;
        private int entryTestScore;

        public FairStudent(String FullName, Date Birthday, Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel) {
            super(FullName, Birthday, Gender, PhoneNumber, UniversityName, GradeLevel);
        }

        public FairStudent(String FullName, Date Birthday, Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel, int EnglishScore, int entryTestScore) {
            super(FullName, Birthday, Gender, PhoneNumber, UniversityName, GradeLevel);
            this.EnglishScore = EnglishScore;
            this.entryTestScore = entryTestScore;
        }

        public void GetEnglishScore() {
            System.out.println("English Score: " + EnglishScore);
        }

        public void SetEnglishScore() {
            Scanner scanner = new Scanner(System.in);
            EnglishScore = Assignment_3.InputValidIntegerNumber(scanner, "English Score: ");
        }

        public void setEnglishScore(int EnglishScore) {
            this.EnglishScore = EnglishScore;
        }

        public void GetEntryTestScore() {
            System.out.println("Entry Test Score: " + entryTestScore);
        }

        public void SetEntryTestScore() {
            Scanner scanner = new Scanner(System.in);
            int entryTestScore = Assignment_3.InputValidIntegerNumber(scanner, "Entry Test Score: ");
            while (entryTestScore < 1 || entryTestScore > 10) {
                System.out.println("Wrong input, please try again");
                entryTestScore = Assignment_3.InputValidIntegerNumber(scanner, "Entry Test Score: ");

                if (entryTestScore >= 1 && entryTestScore <= 10) {
                    this.entryTestScore = entryTestScore;
                }
            }
        }

        public void SetEntryTestScore(int entryTestScore) {
            this.entryTestScore = entryTestScore;
        }

        @Override
        public void ShowMyInfo() {
            System.out.printf("Full Name: %s, Birthday: %s, Gender: %s, Phone Number: %s, University Name: %s, Grade Level: %s, English Score: %d, Entry Test Score: %d\n", super.FullName, super.Birthday.toString(), super.Gender, super.PhoneNumber, super.UniversityName, super.GradeLevel, EnglishScore, entryTestScore);
        }
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

