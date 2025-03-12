package Command;

import Game.Item;
import Game.Player;

public class ShowInventory implements Command {

    Player player;

    public ShowInventory(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if(player.getInventory().getInventory().isEmpty()) {
            return "Your inventory is empty!";
        }

        StringBuilder inventoryDisplay = new StringBuilder("Your inventory contains:\n");

        player.getInventory().getInventory().forEach((item, quantity) -> {
            inventoryDisplay.append(item.getName())
                    .append(" * ")
                    .append(quantity)
                    .append("\n");
        });

        return inventoryDisplay.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
