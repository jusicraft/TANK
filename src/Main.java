import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        World world = new World("map.csv");
        Player player = new Player(0, 0, world);

        Scanner scanner = new Scanner(System.in);
        while (world.isWorldLoaded()) {
            System.out.print("Enter direction (north, south, west, east): ");
            String direction = scanner.nextLine().toLowerCase();
            player.move(direction);
        }
    }
}