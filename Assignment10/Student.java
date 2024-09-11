package Assignment10;

import Assignment10.Exceptions.InfoStudentIncorrectException;

public class Student {
    private String name;
    private int age;


    public Student(String name, int age) throws InfoStudentIncorrectException {
        this.name = name;
        this.age = age;

        //
        if (age < 0) throw new InfoStudentIncorrectException("Age should not be negative");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void ShowStudentDetails() {
        System.out.println("//////////////////////////////////////////");
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("//////////////////////////////////////////");
    }
}
