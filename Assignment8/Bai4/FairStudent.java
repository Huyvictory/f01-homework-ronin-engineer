package Assignment8.Bai4;

import Assignment8.Bai4.Enums.Gender;
import Utils.InputUtils;

import java.util.Date;
import java.util.Scanner;

public class FairStudent extends BaseStudent {
    private int EnglishScore;
    private int entryTestScore;

    public FairStudent(String FullName, Date Birthday, Assignment8.Bai4.Enums.Gender Gender, String PhoneNumber, String UniversityName, String GradeLevel) {
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
        EnglishScore = InputUtils.InputValidIntegerNumber(scanner, "English Score: ");
    }

    public void setEnglishScore(int EnglishScore) {
        this.EnglishScore = EnglishScore;
    }

    public void GetEntryTestScore() {
        System.out.println("Entry Test Score: " + entryTestScore);
    }

    public void SetEntryTestScore() {
        Scanner scanner = new Scanner(System.in);
        int entryTestScore = InputUtils.InputValidIntegerNumber(scanner, "Entry Test Score: ");
        while (entryTestScore < 1 || entryTestScore > 10) {
            System.out.println("Wrong input, please try again");
            entryTestScore = InputUtils.InputValidIntegerNumber(scanner, "Entry Test Score: ");
        }

        this.entryTestScore = entryTestScore;
    }

    public void SetEntryTestScore(int entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void ShowMyInfo() {
        System.out.printf("Full Name: %s, Birthday: %s, Gender: %s, Phone Number: %s, University Name: %s, Grade Level: %s, English Score: %d, Entry Test Score: %d\n", super.getFullName(), super.getBirthday().toString(), super.getGender(), super.getPhoneNumber(), super.getUniversityName(), super.getGradeLevel(), EnglishScore, entryTestScore);
    }
}
