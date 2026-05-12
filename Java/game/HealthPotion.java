public class HealthPotion extends Item{

    HealthPotion(){
        super("Health Potion");
    }

    @Override
    void use(Player player){
        player.currentHP += 30;
        player.currentHP = Math.min(player.currentHP, player.maxHp);
        System.out.println("You gained 30 HP current HP is: " + player.currentHP);
    }
}
