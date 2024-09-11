package Assignment8.Bai1;

import Assignment8.Bai1.Enums.Gender;

public class WorkPeople {
    private final String FullName;
    private final int Age;
    private final Gender gender;
    private final String Address;

    public String getFullName() {
        return FullName;
    }

    public int getAge() {
        return Age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return Address;
    }

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
