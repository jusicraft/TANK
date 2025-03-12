package Command;

import Game.Player;

import java.util.Map;
import java.util.Scanner;

public class Move implements Command {
    LoadMap loadMap;
    Player player;
    Help help;
    Map<String, int[]> moves;

    public Move(LoadMap loadMap, Player player) {
        this.loadMap = loadMap;
        this.player = player;
        this.help = new Help();
    }

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        moves = Map.of(
                "north", new int[]{0, 1},
                "south", new int[]{0, -1},
                "west", new int[]{-1, 0},
                "east", new int[]{1, 0}
        );

        if (!moves.containsKey(input)) {
            return "Invalid direction!";
        }

        int x = player.getX();
        int y = player.getY();

        int newX = x + moves.get(input)[0];
        int newY = y + moves.get(input)[1];

        if (loadMap.canMove(newX, newY)) {
            player.setX(newX);
            player.setY(newY);
            return "Moved to " + loadMap.getRoomName(newX, newY);
        } else {
            return "Can't move in that direction!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
