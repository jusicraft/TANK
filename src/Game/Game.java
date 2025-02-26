package Game;

import Command.LoadMap;
import Command.Move;

public class Game {
    private final LoadMap loadMap;
    private final Move move;

    public Game() {
        this.loadMap = new LoadMap("map.csv");
        System.out.println(loadMap.execute());

        if (loadMap.isWorldLoaded()) {
            Player player = new Player(0, 0);
            this.move = new Move(loadMap, player);
        } else {
            this.move = null;
        }
    }

    public void start() {
        if (!loadMap.isWorldLoaded() || move == null) {
            System.out.println("World failed to load. Exiting.");
            return;
        }

        while (loadMap.isRunning()) {
            System.out.print("-> ");
            System.out.println(move.execute());
        }
    }
}
