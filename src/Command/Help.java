package Command;

public class Help implements Command{
    @Override
    public String execute() {
        return "north, south, west, east, help, quit";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
