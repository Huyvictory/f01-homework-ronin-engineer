package Assignment9.Association;

public class Address {
    private String street;
    private String city;
    private String state;
    private Person owner;

    public Address(String street, String city, String state, Person owner) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.owner = owner;
    }

    public void PrintAddress() {
        System.out.printf("Street: %s City: %s State: %s\n", street, city, state);
    }
}
