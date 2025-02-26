import java.util.Map;

public class Player {
    private int x, y;
    World world;

    public Player(int startX, int startY, World world) {
        this.x = startX;
        this.y = startY;
        this.world = world;
    }

    public void move(String direction) {
        Map<String, int[]> moves = Map.of(
                "north", new int[]{0, 1},
                "south", new int[]{0, -1},
                "west", new int[]{-1, 0},
                "east", new int[]{1, 0}
        );

        if (!moves.containsKey(direction)) {
            System.out.println("Invalid direction!");
            return;
        }

        int newX = x + moves.get(direction)[0];
        int newY = y + moves.get(direction)[1];

        if (world.canMove(x, y, newX, newY)) {
            x = newX;
            y = newY;
            System.out.println("Moved to " + world.getRoomName(newX, newY));
        } else {
            System.out.println("Can't move in that direction!");
        }
    }
}
