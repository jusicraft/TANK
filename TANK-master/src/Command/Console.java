package Command;

import Game.Item;
import Game.Player;

import java.util.Map;
import java.util.Scanner;

public class Console {
    Scanner sc;
    InvalidCmd invalidCmd;
    private final LoadMap loadMap;
    private final Player player;
    Map commands;

    public Console() {
        sc = new Scanner(System.in);
        invalidCmd = new InvalidCmd();
        this.loadMap = new LoadMap("map.csv");
        player = new Player(0, 0);
        System.out.println(loadMap.execute());

        commands = Map.of("move", new Move(loadMap, player),
                "help", new Help(),
                "quit", new Quit(),
                "search", new SearchRoom(loadMap.getRooms(), player),
                "inventory", new ShowInventory(player)
                );
    }

    public void start() {
        if (!loadMap.isWorldLoaded()) {
            System.out.println("World failed to load.");
            return;
        }

        boolean b = false;
        loadMap.getRooms().get("0,0").addItem(new Item("Reactive armor", 50, player), 2);

        while (!b) {
            System.out.print("-> ");
            String input = sc.nextLine().toLowerCase();
            System.out.println(
                    doCommand(input).execute()
            );
            b = doCommand(input).exit();
        }
    }

    public Command doCommand(String input) {
        Command command = (Command) commands.get(input);
        if (command == null) {
            command = invalidCmd;
        }
        return command;
    }
}
