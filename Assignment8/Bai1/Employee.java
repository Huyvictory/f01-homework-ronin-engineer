package Assignment8.Bai1;

public class Employee extends WorkPeople {
    private final String Job;

    public String getJob() {
        return Job;
    }


    public Employee(String FullName, int Age, Gender gender, String Address, String Job) {
        super(FullName, Age, gender, Address);
        this.Job = Job;
    }

    @Override
    public void PrintDetails() {
        System.out.printf("Full Name: %s, Age: %d, Gender: %s, Address: %s, Job: %s\n", super.getFullName(), super.getAge(), super.getGender(), super.getAddress(), Job);
    }
}
