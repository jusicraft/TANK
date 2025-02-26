import java.io.*;
import java.util.*;

public class World {
    private final Map<String, Room> rooms = new HashMap<>();
    private boolean worldLoaded = false;

    public World(String filename) {
        loadWorld(filename);
    }

    private void loadWorld(String filename) {
        worldLoaded = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Invalid format in " + filename + " at line " + lineNumber + ": " + line);
                }
                try {
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());
                    String name = parts[2].trim();
                    Room room = new Room(name);
                    rooms.put(getKey(x, y), room);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Invalid coordinates " + filename + " at line " + lineNumber + ": " + line);
                }
            }

            worldLoaded = true;
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + filename + " not found");
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename + " - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error in world data: " + e.getMessage());
        }
    }


    public boolean canMove(int fromX, int fromY, int toX, int toY) {
        String toKey = getKey(toX, toY);

        if (!rooms.containsKey(toKey)) {
            return false;
        }

        char direction = getDirection(fromX, fromY, toX, toY);

        return direction != ' ';
    }

    private char getDirection(int x1, int y1, int x2, int y2) {
        if (x2 == x1 && y2 == y1 - 1) return 'n'; //north
        if (x2 == x1 && y2 == y1 + 1) return 's'; //south
        if (x2 == x1 - 1 && y2 == y1) return 'w'; //west
        if (x2 == x1 + 1 && y2 == y1) return 'e'; //east
        return ' ';
    }

    private String getKey(int x, int y) {
        return x + "," + y;
    }

    public String getRoomName(int x, int y) {
        Room room = rooms.get(getKey(x, y));
        return (room != null) ? room.getRoomName() : "Void";
    }

    public boolean isWorldLoaded() {
        return worldLoaded;
    }
}
