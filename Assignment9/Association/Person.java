package Assignment9.Association;

import java.util.ArrayList;

public class Person {
    private String name;
    public ArrayList<Address> Addresses;

    public String getName() {
        return name;
    }


    public Person(String name) {
        this.name = name;
    }

    public void getDetails() {
        System.out.printf("Name: %s\n", name);
        System.out.println("Addresses:");
        Addresses.forEach(address -> address.PrintAddress());
    }
}
