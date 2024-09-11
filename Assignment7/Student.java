package Assignment7;

public class Student {
    private final String FullName;
    private final String Address;
    private final String Email;
    private final String PhoneNumber;
    private final String ID;

    public Student() {
        this.FullName = "Full Name Example";
        this.Address = "Address Example";
        this.Email = "Email Example";
        this.PhoneNumber = "Phone Number Example";
        this.ID = "ID Example";
    }

    public Student(String FullName, String Address, String Email, String PhoneNumber, String ID) {
        this.FullName = FullName;
        this.Address = Address;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.ID = ID;
    }

    public void GetDetailsStudentWithAction(String action) {
        System.out.printf("The full details of the student is FullName: %s,\tAddress: %s,\tEmail: %s,\tPhone Number: %s,\tID: %s is %s\n", FullName, Address, Email, PhoneNumber, ID, action);
    }

    public void Study() {
        GetDetailsStudentWithAction("studying");
    }

    public void DoHomework() {
        GetDetailsStudentWithAction("doing homework");
    }

    public void PayTuitionFee() {
        GetDetailsStudentWithAction("paying tuition fee");
    }

    public void Test() {
        GetDetailsStudentWithAction("testing");
    }
}
