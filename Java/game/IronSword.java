public class IronSword extends Item{

    IronSword(){
        super("Iron Sword");
    }

    @Override
    void use(Player player){
        player.attackPower += 5;
        System.out.println("You gained 5 attack power current attack power is: " + player.attackPower);
    }
}
