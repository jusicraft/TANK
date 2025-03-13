package Command;

import Game.Player;

import java.util.Scanner;

public class UseItem implements Command {

    private Player player;
    Scanner sc = new Scanner(System.in);

    public UseItem(Player player) {
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

        player.getInventory().getItem(sc.next()).use();
        //unfinished

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
