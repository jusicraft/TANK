package Command;

import Game.Room;

import java.io.*;
import java.util.*;

public class LoadMap implements Command {
    private final Map<String, Room> rooms = new HashMap<>();
    private boolean worldLoaded = false;
    private boolean Running = true;
    private final String filename;

    public LoadMap(String filename) {
        this.filename = filename;
    }

    @Override
    public String execute() {
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
                    throw new NumberFormatException("Invalid coordinates in " + filename + " at line " + lineNumber + ": " + line);
                }
            }

            worldLoaded = true;
            return filename + " loaded successfully";
        } catch (FileNotFoundException e) {
            return "Error: " + filename + " not found";
        } catch (IOException e) {
            return "Error reading file: " + filename + " - " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Error in world data: " + e.getMessage();
        }
    }

    private String getKey(int x, int y) {
        return x + "," + y;
    }

    public boolean canMove(int toX, int toY) {
        return rooms.containsKey(getKey(toX, toY));
    }

    public String getRoomName(int x, int y) {
        Room room = rooms.get(getKey(x, y));
        return (room != null) ? room.getRoomName() : "Void";
    }

    public boolean isWorldLoaded() {
        return worldLoaded;
    }

    public boolean isRunning() {
        return Running;
    }

    public void stopGame() {
        Running = false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
