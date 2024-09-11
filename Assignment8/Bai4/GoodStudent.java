package Assignment8.Bai4;

import Assignment8.Bai4.Enums.Gender;
import Utils.InputUtils;

import java.util.Date;
import java.util.Scanner;

public class GoodStudent extends BaseStudent {
    private int GPA;
    private String bestRewardName;

    public GoodStudent(String FullName, Date Birthday, Assignment8.Bai4.Enums.Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel) {
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
        int GPA = InputUtils.InputValidIntegerNumber(scanner, "GPA: ");
        while (GPA < 1 || GPA > 10) {
            System.out.println("Wrong input, please try again");
            GPA = InputUtils.InputValidIntegerNumber(scanner, "GPA: ");

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
        System.out.printf("Full Name: %s, Birthday: %s, Gender: %s, Phone Number: %s, University Name: %s, Grade Level: %s, GPA: %d, Best Reward Name: %s\n", super.getFullName(), super.getBirthday().toString(), super.getGender(), super.getPhoneNumber(), super.getUniversityName(), super.getGradeLevel(), GPA, bestRewardName);
    }
}
