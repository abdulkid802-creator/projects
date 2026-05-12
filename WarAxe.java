public class WarAxe extends Item{

    WarAxe(){
        super("War Axe");
    }

    @Override
    void use(Player player){
        player.attackPower += 8;
        System.out.println("You gained 8 attack power current attack power is: " + player.attackPower);
    }
}
