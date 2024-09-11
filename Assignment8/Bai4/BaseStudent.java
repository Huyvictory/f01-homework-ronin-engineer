package Assignment8.Bai4;

import Assignment8.Bai4.Enums.Gender;
import Assignment8.Bai4.Interfaces.IStudent;

import java.util.Date;

public class BaseStudent implements IStudent {
    private String FullName;
    private Date Birthday;
    private Assignment8.Bai4.Enums.Gender Gender;
    private String PhoneNumber;
    private String UniversityName;
    private String GradeLevel;

    public String getFullName() {
        return FullName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public Gender getGender() {
        return Gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public String getGradeLevel() {
        return GradeLevel;
    }

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
