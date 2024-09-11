package Assignment9.Composition;

import java.util.ArrayList;
import java.util.List;

public class House {
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
