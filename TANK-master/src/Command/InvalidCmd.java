package Command;

public class InvalidCmd implements Command {
    @Override
    public String execute() {
        return "Invalid Command!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
