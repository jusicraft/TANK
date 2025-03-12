package Command;

public class Attack implements Command {

    public Attack(){

    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
