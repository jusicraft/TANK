package Game;

public class Player {
    private int x, y;
    private int Armor;
    private int maxArmor;
    private Inventory inventory;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.inventory = new Inventory();
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getArmor() {
        return Armor;
    }
    public void setArmor(int armor) {
        Armor = armor;
    }
    public int getMaxArmor() {
        return maxArmor;
    }
    public void setMaxArmor(int maxArmor) {
        this.maxArmor = maxArmor;
    }

    public String getXy(){
        return x + "," + y;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
