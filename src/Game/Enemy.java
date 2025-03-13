package Game;

public class Enemy {
    private int x,y;
    private int Armor;
    private int Damage;
    private EnemyType type;
    private Player player;

    public Enemy (int x, int y, EnemyType type, Player player) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.player = player;
    }

    public void attack(){
        player.setArmor(player.getArmor()-Damage);
    }
}
