package Assignment8.Bai1;

import Assignment8.Bai1.Enums.Gender;

public class Engineer extends WorkPeople {
    private final String FacultyJob;

    public String getFacultyJob() {
        return FacultyJob;
    }

    public Engineer(String FullName, int Age, Gender gender, String Address, String FacultyJob) {
        super(FullName, Age, gender, Address);
        this.FacultyJob = FacultyJob;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Faculty Job: %s\n", super.getFullName(), super.getAge(), super.getGender(), super.getAddress(), FacultyJob);
    }
}
