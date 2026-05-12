public class SpeedBoots extends Item{

    SpeedBoots(){
        super("Speed Boots");
    }

    @Override
    void use(Player player){
        player.cooldown -= 1;
        player.cooldown = Math.max(0,player.cooldown - 1);
        System.out.println("You cooldown as gone down by 1 current cd: " + player.cooldown);
    }
}
