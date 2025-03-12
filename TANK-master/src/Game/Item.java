package Game;

public class Item {

    private String name;
    private ItemType type;
    private Player player;
    private int value;

    public Item(String name, int value, Player player) {
        this.name = name;
        this.value = value;
        this.player = player;
    }

    public boolean use(){
        switch (type){
            case REPAIR -> {
                player.setArmor(Math.min(player.getArmor() + value, player.getMaxArmor()));
            }
            case SHIELD -> {
                player.setMaxArmor(player.getMaxArmor()+value);
                player.setArmor(player.getMaxArmor());
            }
            case PRECISION -> {
                //coming soon
            }
            case RECON -> {
                //reveals enemy position
            }
            case null, default -> {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
