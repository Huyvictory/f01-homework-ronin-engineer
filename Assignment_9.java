import Assignment9.Aggregation.Book;
import Assignment9.Aggregation.Library;
import Assignment9.Association.Address;
import Assignment9.Association.Person;
import Assignment9.Composition.House;
import Assignment9.Dependency.Calculator;
import Assignment9.InheritanceRelization.Animal;
import Assignment9.InheritanceRelization.Cat;
import Assignment9.InheritanceRelization.Dog;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Assignment_9 {
    public static void main(String[] args) {
        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");
        System.out.println();
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
        System.out.println(strBuilderHelloWord);

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
