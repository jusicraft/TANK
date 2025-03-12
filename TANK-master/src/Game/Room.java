package Game;

import java.util.HashMap;

public class Room {
    private final String roomName;
    private HashMap<Item, Integer> roomItems;

    public Room(String roomName) {
        this.roomName = roomName;
        this.roomItems = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        roomItems.put(item, roomItems.getOrDefault(item, quantity));
    }

    public String getRoomName() {
        return roomName;
    }

    public HashMap<Item, Integer> getRoomItems() {
        return roomItems;
    }
}
