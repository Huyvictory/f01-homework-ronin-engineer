package Assignment9.Composition;

public class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
