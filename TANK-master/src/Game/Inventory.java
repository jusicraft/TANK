package Game;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Item, Integer> inventory;
    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void addItem(Item item, Integer value) {
        inventory.put(item, inventory.getOrDefault(item, 0) + value);
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    public Item getItem(String name) {
        name = name.toLowerCase();
        for (Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            if (entry.getKey().getName().toLowerCase().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
