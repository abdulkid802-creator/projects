public class HeavyArmour extends Item{

    HeavyArmour(){
        super("Heavy Armour");
    }

    @Override
    void use(Player player){
        player.defence += 8;
        System.out.println("You gained 8 defence current defence is: " + player.defence);
    }
}
