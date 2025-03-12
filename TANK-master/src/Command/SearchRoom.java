package Command;

import Game.Item;
import Game.Player;
import Game.Room;

import java.util.Map;

public class SearchRoom implements Command {

    private final Map<String, Room> rooms;
    private final Player player;

    public SearchRoom(Map<String, Room> rooms, Player player) {
        this.rooms = rooms;
        this.player = player;
    }

    @Override
    public String execute() {
        Map<Item, Integer> roomItems = rooms.get(player.getXy()).getRoomItems();

        if (roomItems.isEmpty()) {
            return "The room is empty.";
        }

        StringBuilder itemNames = new StringBuilder("You have found: ");

        for (Map.Entry<Item, Integer> entry : roomItems.entrySet()) {
            player.getInventory().addItem(entry.getKey(), entry.getValue());
            itemNames.append(entry.getKey().getName()).append(" * ").append(entry.getValue()).append(", ");
        }

        roomItems.clear();
        return itemNames.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
