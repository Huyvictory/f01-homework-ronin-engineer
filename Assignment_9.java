import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Assignment_9 {
    public static void main(String[] args) {
        // Bai 2
//        System.out.println("*****************************************");
//        Bai2();
//        System.out.println("*****************************************");
//        System.out.println();

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");
        System.out.println();
    }


    // Code that represents association relationship between two objects
    public static class Address {
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


    public static class Person {
        private String name;
        private ArrayList<Address> Addresses;

        public Person(String name) {
            this.name = name;
        }

        public void getDetails() {
            System.out.printf("Name: %s\n", name);
            System.out.println("Addresses:");
            Addresses.forEach(address -> address.PrintAddress());
        }
    }

    // Code that represents inheritance and realization relationship between two objects
    public static abstract class Animal {
        private String name;

        public abstract void makeSound();

        public Animal(String name) {
            this.name = name;
        }
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.printf("Woof! My name is %s\n", super.name);
        }
    }


    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.printf("Meow! My name is %s\n", super.name);
        }
    }

    // Code that represents dependency relationship between two objects
    public static class MathUtils {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    static class Calculator {
        public int calculateSum(int x, int y) {
            return MathUtils.add(x, y);
        }
    }

    // Code that represents aggregation relationship between two objects
    static class Book {
        private String title;

        public Book(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    static class Library {
        private String name;
        private List<Book> books;

        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void showBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //Code that represents composition relationship between two objects
    static class Room {
        private String name;

        public Room(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class House {
        private String address;
        private List<Room> rooms;

        public House(String address) {
            this.address = address;
            this.rooms = new ArrayList<>();
        }

        public void addRoom(String roomName) {
            Room room = new Room(roomName);
            rooms.add(room);
        }

        public void showRooms() {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    private static void Bai2() {
        // Association Relationship
        System.out.println("*****************************************");
        System.out.println("Association Relationship");

        // A person has a name and an array list of addresses
        // Address has a street, city, state and a person who owns it
        Person johnPerson = new Person("John");
        Address address1 = new Address("123 Main Street", "Anytown", "NY", johnPerson);
        Address address2 = new Address("456 Main Street", "Anytown", "NY", johnPerson);

        johnPerson.Addresses = new ArrayList<>();
        johnPerson.Addresses.add(address1);
        johnPerson.Addresses.add(address2);

        johnPerson.getDetails();
        System.out.println("*****************************************");

        // Inheritance and Realization Relationship
        System.out.println("*****************************************");
        System.out.println("Inheritance and Realization Relationship");

        // Dog and Cat are Animals and they both have a makeSound method implemented from abstract class Animal
        Animal dog = new Dog("Dog");
        Animal cat = new Cat("Cat");

        System.out.println("Dog Sound:");
        dog.makeSound();

        System.out.println("Cat Sound:");
        cat.makeSound();
        System.out.println("*****************************************");

        // Dependency Relationship
        System.out.println("*****************************************");
        System.out.println("Dependency Relationship");
        // Calculator depends on MathUtils add method to perform addition
        Calculator calculator = new Calculator();
        int sum = calculator.calculateSum(10, 20);
        System.out.printf("Sum: %d\n", sum);
        System.out.println("*****************************************");

        // Aggregation Relationship
        System.out.println("*****************************************");
        System.out.println("Aggregation Relationship");
        Book book1 = new Book("Moby Dick");
        Book book2 = new Book("Pride and Prejudice");
        Book book3 = new Book("The Great Gatsby");
        Library library = new Library("City Library");
        library.addBook(book1);
        library.addBook(book2);

        // Books are in the library
        System.out.println("Books are in the library:");
        library.showBooks();
        // Books are not in the library
        System.out.printf("Books are not in the library: %s\n", book3);
        System.out.println("*****************************************");

        // Composition Relationship
        System.out.println("*****************************************");
        System.out.println("Composition Relationship");

        // A house has many rooms
        // If house is destroyed, all rooms are destroyed
        House house = new House("123 Main Street");
        house.addRoom("Living Room");
        house.addRoom("Kitchen");

        // Rooms are in the house
        System.out.println("Rooms are in the house:");
        house.showRooms();
        System.out.println("*****************************************");
    }

    private static void Bai3() {
        // Implementation of the String object
        String str = "Hello World";
        System.out.println(str.toUpperCase());

        // Implementation of the StringBuilder object
        StringBuilder strBuilderHelloWord = new StringBuilder("Hello World");
        strBuilderHelloWord.append(" This is a test");
        System.out.println(strBuilderHelloWord.toString());

        // Implementation of the BigInteger object
        BigInteger bigInteger = new BigInteger("123456789999999");
        BigInteger bigInteger2 = new BigInteger("123456789999999");
        System.out.println(bigInteger.add(bigInteger2));

        // Implementation of BigDecimal object
        BigDecimal bigDecimal = new BigDecimal("123456789999999.5");
        BigDecimal bigDecimal2 = new BigDecimal("123456789999999.8");
        System.out.println(bigDecimal.add(bigDecimal2));
    }
}
