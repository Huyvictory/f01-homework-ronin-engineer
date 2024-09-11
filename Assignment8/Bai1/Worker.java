package Assignment8.Bai1;

public class Worker extends WorkPeople {
    private final int Level;

    public Worker(String FullName, int Age, Gender gender, String Address, int level) {
        super(FullName, Age, gender, Address);
        Level = level;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Level: %d\n", super.getFullName(), super.getAge(), super.getGender(), super.getAddress(), Level);
    }
}
