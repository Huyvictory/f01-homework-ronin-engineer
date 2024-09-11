package Assignment9.InheritanceRelization;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("Meow! My name is %s\n", super.getName());
    }
}
