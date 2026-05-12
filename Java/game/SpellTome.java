public class SpellTome extends Item{

    SpellTome(){
        super("Spell Tome");
    }

    @Override
    void use(Player player){
        player.attackPower += 10;
        System.out.println("You gained 10 attack power current attack power is: " + player.attackPower);
    }
}
