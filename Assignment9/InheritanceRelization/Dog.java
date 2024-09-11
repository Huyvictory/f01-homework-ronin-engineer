package Assignment9.InheritanceRelization;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("Woof! My name is %s\n", super.getName());
    }
}
