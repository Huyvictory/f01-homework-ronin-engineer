package Assignment9.InheritanceRelization;

public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public Animal(String name) {
        this.name = name;
    }
}
