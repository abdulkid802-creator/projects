public class ManaCrystal extends Item{

    ManaCrystal(){
        super("Mana Crystal");
    }

    @Override
    void use(Player player){
        player.currentHP += 40;
        player.currentHP = Math.min(player.currentHP, player.maxHp);
        player.attackPower += 5;
        System.out.println("You gained 30 HP and 5 attack power current HP/attack power is: " + player.currentHP + " & " + player.attackPower);
    }
}
