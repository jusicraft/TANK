package Command;

public class Help implements Command{
    @Override
    public String execute() {
        return "move, search, help, quit, inventory" + " (move: east, west, north, south)";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
