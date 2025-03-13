package Command;

public class Quit implements Command {

    @Override
    public String execute() {
        return "Game exited";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
